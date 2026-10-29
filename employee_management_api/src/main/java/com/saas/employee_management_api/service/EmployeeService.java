
// EPIC 03 - DAY 2

package com.saas.employee_management_api.service;

import com.saas.employee_management_api.dto.EmployeeRequest;
import com.saas.employee_management_api.entity.Employee;
import com.saas.employee_management_api.exception.EmployeeNotFoundException;
import com.saas.employee_management_api.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // EPIC 04 ,DAY 2; Get employees with pagination
    public Page<Employee> getAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    // Create an employee
    public Employee createEmployee(EmployeeRequest request) {
        Employee employee = new Employee(
                request.getName(),
                request.getEmail(),
                request.getSalary()
        );

        return employeeRepository.save(employee);
    }

    // Get all employees without pagination
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get an employee by ID
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    // Update an employee
    @Transactional
    public Employee updateEmployee(Long id, EmployeeRequest request) {
        Employee employee = getEmployeeById(id);

        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setSalary(request.getSalary());

        return employeeRepository.save(employee);
    }

    // Delete an employee
    @Transactional
    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }
}
