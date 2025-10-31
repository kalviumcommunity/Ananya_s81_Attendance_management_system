package com.school;

public class Student extends Person {
    private String gradeLevel;

    public Student(int id, String name, String gradeLevel) {
        super(id, name); // Calls Person constructor
        this.gradeLevel = gradeLevel;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Student ID: " + getId()); 
        System.out.println("Grade Level: " + gradeLevel);
        System.out.println("Role: Student");
    }

    public String toDataString() {
        return getId() + "," + getName() + "," + gradeLevel;
    }
}
