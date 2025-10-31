package com.school;

public class Teacher extends Person implements Storable {
    private String subject;

    public Teacher(int id, String name, String subject) {
        super(id, name);
        this.subject = subject;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Subject: " + subject);
    }

    @Override
    public String getStorageFormat() {
        return getId() + "," + getName() + "," + subject;
    }
}
