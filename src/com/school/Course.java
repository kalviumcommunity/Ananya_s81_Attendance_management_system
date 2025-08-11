
package com.school;

public class Course {
    private static int nextCourseIdCounter = 101; 
    int courseId;
    String courseName;

    public Course(String courseName) {
        this.courseId = nextCourseIdCounter++;
        this.courseName = courseName;
    }

    public void displayDetails() {
        System.out.println("Course ID: C" + courseId);
        System.out.println("Course Name: " + courseName);
    }
}