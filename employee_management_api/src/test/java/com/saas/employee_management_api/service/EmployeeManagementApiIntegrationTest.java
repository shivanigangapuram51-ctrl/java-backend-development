//EPIC 03,DAY 5,
package com.saas.employee_management_api.service;

import tools.jackson.databind.ObjectMapper;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import com.saas.employee_management_api.dto.EmployeeRequest;
import com.saas.employee_management_api.entity.Employee;
import com.saas.employee_management_api.repository.EmployeeRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.http.MediaType;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeManagementApiIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void cleanDatabase() {
        employeeRepository.deleteAll();
    }

    @Test
    void createEmployeeReturnsCreatedStatus() throws Exception {

        EmployeeRequest request = new EmployeeRequest();
        request.setName("Shivani");
        request.setEmail("shivani@example.com");
        request.setSalary(30000);

        mockMvc.perform(post("/api/v1/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Shivani"))
                .andExpect(jsonPath("$.email")
                        .value("shivani@example.com"));
    }

    @Test
    void createEmployeeWithInvalidEmailReturnsBadRequest()
            throws Exception {

        EmployeeRequest request = new EmployeeRequest();
        request.setName("Shivani");
        request.setEmail("invalid-email");
        request.setSalary(30000);

        mockMvc.perform(post("/api/v1/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.validationErrors.email").exists());
    }

    @Test
    void getMissingEmployeeReturnsNotFound() throws Exception {

        mockMvc.perform(get("/api/v1/employees/99999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.message")
                        .value("Employee not found with ID: 99999"));
    }

    @Test
    void getAllEmployeesReturnsOk() throws Exception {

        mockMvc.perform(get("/api/v1/employees"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteMissingEmployeeReturnsNotFound() throws Exception {

        mockMvc.perform(delete("/api/v1/employees/99999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void updateEmployeeReturnsOk() throws Exception {

        Employee employee = new Employee();
        employee.setName("Shivani");
        employee.setEmail("shivani@example.com");
        employee.setSalary(30000);

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeRequest request = new EmployeeRequest();
        request.setName("Shivani Updated");
        request.setEmail("shivani.updated@example.com");
        request.setSalary(35000);

        mockMvc.perform(put("/api/v1/employees/" + savedEmployee.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Shivani Updated"))
                .andExpect(jsonPath("$.email")
                        .value("shivani.updated@example.com"))
                .andExpect(jsonPath("$.salary").value(35000));
    }

    @Test
    void deleteEmployeeReturnsNoContent() throws Exception {

        Employee employee = new Employee();
        employee.setName("Rahul");
        employee.setEmail("rahul@example.com");
        employee.setSalary(25000);

        Employee savedEmployee = employeeRepository.save(employee);

        mockMvc.perform(delete("/api/v1/employees/" + savedEmployee.getId()))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/api/v1/employees/" + savedEmployee.getId()))
                .andExpect(status().isNotFound());
    }
}
