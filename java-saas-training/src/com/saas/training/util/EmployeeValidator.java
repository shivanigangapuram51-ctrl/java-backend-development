package com.saas.training.util;

import com.saas.training.exception.InvalidEmployeeException;

public class EmployeeValidator {

    public static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new InvalidEmployeeException(
                    "Employee name cannot be blank"
            );
        }
    }

    public static void validateEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new InvalidEmployeeException(
                    "Invalid employee email"
            );
        }
    }

    public static void validateSalary(double salary) {
        if (salary <= 0) {
            throw new InvalidEmployeeException(
                    "Salary must be greater than zero"
            );
        }
    }
}
