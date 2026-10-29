//EPIC 02,TASK 4 ,DAY 2
package com.saas.training.repository;

import com.saas.training.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EmployeeRepository {

    private final Map<Long, Employee> employees = new HashMap<>();

    public Employee save(Employee employee) {
        employees.put(employee.getId(), employee);
        return employee;
    }

    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(employees.get(id));
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }

    public void deleteById(Long id) {
        employees.remove(id);
    }

    public boolean existsById(Long id) {
        return employees.containsKey(id);
    }
}

