// EPIC 04- DAY 2
package com.saas.employee_management_api.dto;

public record EmployeeDepartmentResponse(
        Long id,
        String name,
        String email,
        String departmentName
) {
}