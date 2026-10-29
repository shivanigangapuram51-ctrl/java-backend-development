//EPIC 01,DAY 04,TASK 14
package com.saas.training.model;

public class Admin extends User {

    public Admin() {
        super();
    }

    public Admin(Long id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public String getRole() {
        return "ADMIN";
    }

    @Override
    public void showPermissions() {
        System.out.println("Manage organization");
    }
}

