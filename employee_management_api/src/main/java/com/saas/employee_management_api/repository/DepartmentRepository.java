//EPIC 04,DAY 2
package com.saas.employee_management_api.repository;

import com.saas.employee_management_api.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository
        extends JpaRepository<Department, Long> {
}
