//EPIC 01,TASK 16,17,19,DAY 2;
package com.saas.training.service;

import com.saas.training.exception.EmployeeNotFoundException;
import com.saas.training.exception.InvalidOrganizationException;
import com.saas.training.exception.InvalidSalaryException;
import com.saas.training.model.Employee;
import com.saas.training.model.SubscriptionPlan;
import com.saas.training.repository.EmployeeRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeService {

    private final EmployeeRepository repository;
    private final Set<String> departments = new HashSet<>();

    // Constructor dependency injection
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    // Task 15: Add Employee
    public void addEmployee(Employee employee) {
        if (employee == null || employee.getId() == null) {
            throw new IllegalArgumentException(
                    "Employee and employee ID are required");
        }

        if (repository.existsById(employee.getId())) {
            throw new IllegalArgumentException(
                    "Employee ID already exists");
        }

        validateSalary(employee.getSalary());
        repository.save(employee);
        updateDepartment(employee);

        System.out.println("Employee added successfully.");
    }

    // View all employees
    public List<Employee> viewEmployees() {
        return repository.findAll();
    }

    // Find employee by ID
    public Employee searchEmployee(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee not found with ID: " + id));
    }

    // Update employee name
    public void updateEmployee(Long id, String newName) {
        Employee employee = searchEmployee(id);

        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException(
                    "Employee name cannot be empty");
        }

        employee.setName(newName);
        repository.save(employee);

        System.out.println("Employee updated successfully.");
    }

    // Delete employee
    public void deleteEmployee(Long id) {
        searchEmployee(id);
        repository.deleteById(id);

        System.out.println("Employee deleted successfully.");
    }

    // Filter active employees
    public List<Employee> getActiveEmployees() {
        return repository.findAll().stream()
                .filter(employee ->
                        "ACTIVE".equalsIgnoreCase(employee.getStatus()))
                .collect(Collectors.toList());
    }

    // Calculate total salary
    public double getTotalSalary() {
        return repository.findAll().stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    // Calculate average salary
    public double getAverageSalary() {
        return repository.findAll().stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

    // Salary report grouped by department
    public Map<String, Double> getSalaryReportByDepartment() {
        return repository.findAll().stream()
                .filter(employee -> employee.getDepartment() != null)
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)
                ));
    }

    // Validate subscription plan employee limit
    public void validateSubscriptionPlan(
            SubscriptionPlan plan, int employeeCount) {

        if (plan == null) {
            throw new IllegalArgumentException(
                    "Subscription plan is required");
        }

        if (employeeCount < 0) {
            throw new IllegalArgumentException(
                    "Employee count cannot be negative");
        }

        int limit;

        switch (plan) {
            case FREE:
                limit = 5;
                break;
            case BASIC:
                limit = 25;
                break;
            case PRO:
                limit = 100;
                break;
            case ENTERPRISE:
                limit = Integer.MAX_VALUE;
                break;
            default:
                throw new IllegalArgumentException(
                        "Unsupported subscription plan");
        }

        if (employeeCount > limit) {
            throw new IllegalArgumentException(
                    plan + " plan allows a maximum of "
                            + limit + " employees");
        }
    }

    // Validate salary
    public void validateSalary(double salary) {
        if (!Double.isFinite(salary) || salary < 0) {
            throw new InvalidSalaryException(
                    "Salary must be a valid non-negative number");
        }
    }

    // Validate organization name
    public void validateOrganization(String organizationName) {
        if (organizationName == null
                || organizationName.isBlank()) {
            throw new InvalidOrganizationException(
                    "Organization name is required");
        }
    }

    // View unique departments
    public Set<String> viewDepartments() {
        return new HashSet<>(departments);
    }

    // Keep track of department names
    private void updateDepartment(Employee employee) {
        if (employee.getDepartment() != null
                && !employee.getDepartment().isBlank()) {
            departments.add(employee.getDepartment());
        }
    }

    // Find employee (Task 18)
    public Employee findEmployee(Long id) {
        return searchEmployee(id);
    }
}


