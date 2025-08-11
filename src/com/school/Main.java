package com.school;

public class Main {
    public static void main(String[] args) {

        Student[] students = new Student[2];
        students[0] = new Student();
        students[0].setDetails("Alice");
        students[1] = new Student();
        students[1].setDetails("Bob");

        for (Student s : students) {
            s.displayDetails();
            System.out.println("-------------------");
        }
        Course[] courses = new Course[2];
        courses[0] = new Course();
        courses[0].setDetails(101, "Java Programming");
        courses[1] = new Course();
        courses[1].setDetails(102, "Data Structures");

        for (Course c : courses) {
            c.displayDetails();
            System.out.println("-------------------");
        }
    }
}