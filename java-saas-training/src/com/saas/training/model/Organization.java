//EPIC 01,TASK 11,DAY 3;
package com.saas.training.model;

import java.util.ArrayList;
import java.util.List;

public class Organization {

    private Long id;
    private String name;
    private List<Employee> employees = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();
    private Subscription subscription;

    public Organization() {
    }

    public Organization(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}
