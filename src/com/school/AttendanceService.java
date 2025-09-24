package com.school;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {

    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    // Constructor
    public AttendanceService(FileStorageService storageService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
    }

    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
        System.out.println("Attendance marked for " + student.getName() + " in " + course.getCourseName());
    }

    public void markAttendance(int studentId, int courseId, String status, List<Student> allStudents, List<Course> allCourses) {
        Student student = findStudentById(studentId, allStudents);
        Course course = findCourseById(courseId, allCourses);

        if (student != null && course != null) {
            markAttendance(student, course, status);
        } else {
            System.out.println("Student or Course not found for IDs: " + studentId + ", " + courseId);
        }
    }

    private Student findStudentById(int id, List<Student> allStudents) {
        for (Student s : allStudents) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    private Course findCourseById(int id, List<Course> allCourses) {
        for (Course c : allCourses) {
            if (c.getCourseId() == id) return c;
        }
        return null;
    }

    public void displayAttendanceLog() {
        System.out.println("Full Attendance Log:");
        for (AttendanceRecord record : attendanceLog) {
            System.out.println(record);
        }
    }

    public void displayAttendanceLog(Student student) {
        System.out.println("Attendance Log for Student: " + student.getName());
        for (AttendanceRecord record : attendanceLog) {
            if (record.getStudent().equals(student)) {
                System.out.println(record);
            }
        }
    }

    public void displayAttendanceLog(Course course) {
        System.out.println("Attendance Log for Course: " + course.getCourseName());
        for (AttendanceRecord record : attendanceLog) {
            if (record.getCourse().equals(course)) {
                System.out.println(record);
            }
        }
    }

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog);
        System.out.println("Attendance data saved.");
    }
}
