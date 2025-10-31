package com.school;

public class Staff extends Person implements Storable {
    private String role;

    public Staff(int id, String name, String role) {
        super(id, name);
        this.role = role;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Staff Role: " + role);
        System.out.println("Role Type: Non-Teaching Staff");
    }

    @Override
    public String getStorageFormat() {
        return getId() + "," + getName() + "," + role;
    }
}
