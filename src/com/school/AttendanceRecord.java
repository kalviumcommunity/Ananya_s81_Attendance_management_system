package com.school;

public class AttendanceRecord {
    private Student student;
    private Course course;
    private String status;

    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;
        if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            this.status = status;
        } else {
            this.status = "Invalid";
        }
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getStatus() {
        return status;
    }

    public void displayRecord() {
        System.out.println("=== Attendance Record ===");
        System.out.println("Student ID: " + student.getId());
        System.out.println("Student Name: " + student.getName());
        System.out.println("Course ID: " + course.getCourseId());
        System.out.println("Course Name: " + course.getCourseName());
        System.out.println("Status: " + status);
        System.out.println("-------------------------");
    }

    public String toDataString() {
        return student.getId() + "," + course.getCourseId() + "," + status;
    }
}
