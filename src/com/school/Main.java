// Main.java
package com.school;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[3];
        for (int i = 0; i < students.length; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            students[i] = new Student(sc.nextLine());
        }

        for (Student s : students) {
            s.displayDetails();
            System.out.println("----------------");
        }

        Course[] courses = new Course[2];
        for (int i = 0; i < courses.length; i++) {
            System.out.print("Enter name of course " + (i + 1) + ": ");
            courses[i] = new Course(sc.nextLine());
        }

        for (Course c : courses) {
            c.displayDetails();
            System.out.println("----------------");
        }

        sc.close();
    }
}