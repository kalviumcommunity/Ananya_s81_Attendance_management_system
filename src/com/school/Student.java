package com.school;

public class Student extends Person {
    private int id;  
    private String name;
    private String gradeLevel;

    public Student(int id, String name, String gradeLevel) {
        super(name); 
        this.id = id;
        this.name = name;
        this.gradeLevel = gradeLevel;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }   

    public String getGradeLevel() {
        return gradeLevel;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Student ID: " + id);
        System.out.println("Grade Level: " + gradeLevel);
        System.out.println("Role: Student");
    }

    public String toDataString() {
        return id + "," + getName() + "," + gradeLevel;
    }
}
