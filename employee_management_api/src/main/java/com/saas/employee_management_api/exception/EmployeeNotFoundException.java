//EPIC 03,DAY 2
package com.saas.employee_management_api.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id) {
        super("Employee not found with ID: " + id);
    }
}