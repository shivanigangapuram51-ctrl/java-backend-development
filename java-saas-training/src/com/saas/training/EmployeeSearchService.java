package com.saas.training;

import com.saas.training.model.Employee;
import java.util.List;
import java.util.Optional;
import java.util.Objects;

public class EmployeeSearchService {

    private final List<Employee> employees;

    public EmployeeSearchService(List<Employee> employees) {
        this.employees = employees;
    }

    public Optional<Employee> findEmployeeById(Long id) {
        return employees.stream()
                .filter(e -> Objects.equals(e.getId(), id))
                .findFirst();
    }
}
