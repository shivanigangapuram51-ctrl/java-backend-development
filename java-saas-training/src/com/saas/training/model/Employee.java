//EPIC 01,TASK_8,9,10,DAY_3
package com.saas.training.model;

import java.time.LocalDate;

public class Employee extends User {

    private String phone;
    private double salary;
    private String department;
    private String status = "ACTIVE";
    private LocalDate joiningDate;

    public Employee() {
        super();
    }

    public Employee(Long id, String name) {
        super(id, name, null);
    }

    public Employee(Long id, String name,
                    String email, double salary) {
        super(id, name, email);
        setSalary(salary);
    }

    @Override
    public String getRole() {
        return "EMPLOYEE";
    }

    @Override
    public void showPermissions() {
        System.out.println("View own profile");
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }
//EPIC_01,DAY_3,TASK_10
    public void setSalary(double salary) {
        if (!Double.isFinite(salary) || salary < 0) {
            throw new IllegalArgumentException(
                    "Salary must be a valid non-negative number");
        }
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }
//EPIC 02 ,TASK 06,DAY2
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Employee)) {
            return false;
        }

        Employee other = (Employee) obj;

        return getId() != null
                && getId().equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getId() == null ? 0 : getId().hashCode();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", status='" + status + '\'' +
                ", joiningDate=" + joiningDate +
                '}';
    }
}






