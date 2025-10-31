package com.school;

public class Course {
    private int courseId;
    private String courseName;

    public Course(int id, String name) {
        this.courseId = id;
        this.courseName = name;
    }

    public int getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }

    public void displayDetails() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
    }

    @Override
    public String toString() {
        return courseId + "," + courseName;
    }
}
