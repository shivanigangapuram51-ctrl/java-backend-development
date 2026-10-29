//TASK 13,EPIC 01 ,DAY 4
package com.saas.training.model;

public class HR extends User {

    public HR() {
        super();
    }

    public HR(Long id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public String getRole() {
        return "HR";
    }

    @Override
    public void showPermissions() {
        System.out.println("Manage employees");
    }
}

