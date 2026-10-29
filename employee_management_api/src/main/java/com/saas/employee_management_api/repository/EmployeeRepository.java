
// EPIC 03 - DAY 1

package com.saas.employee_management_api.repository;

import com.saas.employee_management_api.dto.EmployeeDepartmentResponse;
import com.saas.employee_management_api.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//EPIC 04 DAY 2
    @Query("""
            SELECT new com.saas.employee_management_api.dto.EmployeeDepartmentResponse(
                e.id,
                e.name,
                e.email,
                d.name
            )
            FROM Employee e
            LEFT JOIN e.department d
            """)
    Page<EmployeeDepartmentResponse> findEmployeeDepartmentDetails(
            Pageable pageable
    );
}
