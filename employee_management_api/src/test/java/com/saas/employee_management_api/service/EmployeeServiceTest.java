//EPIC 03 ,DAY 5
package com.saas.employee_management_api.service;

import com.saas.employee_management_api.dto.EmployeeRequest;
import com.saas.employee_management_api.entity.Employee;
import com.saas.employee_management_api.exception.EmployeeNotFoundException;
import com.saas.employee_management_api.repository.EmployeeRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee(
                "Shivani",
                "shivani@example.com",
                30000
        );

        employee.setId(1L);
    }

    @Test
    void getEmployeeByIdReturnsEmployeeWhenFound() {
        when(employeeRepository.findById(1L))
                .thenReturn(Optional.of(employee));

        Employee result = employeeService.getEmployeeById(1L);

        assertEquals(1L, result.getId());
        assertEquals("Shivani", result.getName());

        verify(employeeRepository).findById(1L);
    }

    @Test
    void getEmployeeByIdThrowsExceptionWhenNotFound() {
        when(employeeRepository.findById(100L))
                .thenReturn(Optional.empty());

        assertThrows(
                EmployeeNotFoundException.class,
                () -> employeeService.getEmployeeById(100L)
        );
    }

    @Test
    void createEmployeeSavesEmployee() {
        EmployeeRequest request = new EmployeeRequest();

        request.setName("Shivani");
        request.setEmail("shivani@example.com");
        request.setSalary(30000);

        when(employeeRepository.save(any(Employee.class)))
                .thenReturn(employee);

        Employee result = employeeService.createEmployee(request);

        assertEquals("Shivani", result.getName());
        assertEquals(30000, result.getSalary());

        verify(employeeRepository).save(any(Employee.class));
    }
}