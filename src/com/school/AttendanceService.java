package com.school;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {

    private final RegistrationService registrationService;
    private final FileStorageService FileStorageService;
    private final List<AttendanceRecord> attendanceLog;

    public AttendanceService(RegistrationService registrationService, FileStorageService storageService) {
        this.registrationService = registrationService;
        this.FileStorageService = storageService;
        this.attendanceLog = new ArrayList<>();
    }


    public void markAttendance(int studentId, int courseId, String status) {
        Student student = registrationService.findStudentById(studentId);
        Course course = registrationService.findCourseById(courseId);

        if (student != null && course != null) {
            AttendanceRecord record = new AttendanceRecord(student, course, status);
            attendanceLog.add(record);
            System.out.println("✅ Attendance marked for " + student.getName() + " in " + course.getCourseName());
        } else {
            System.out.println("❌ Student or Course not found for IDs: " + studentId + ", " + courseId);
        }
    }

    public void displayAttendanceLog() {
        System.out.println("\n📋 Full Attendance Log:");
        for (AttendanceRecord record : attendanceLog) {
            System.out.println(record);
        }
    }

    public void displayAttendanceLog(Student student) {
        System.out.println("\n📋 Attendance Log for Student: " + student.getName());
        for (AttendanceRecord record : attendanceLog) {
            if (record.getStudent().equals(student)) {
                System.out.println(record);
            }
        }
    }

    public void displayAttendanceLog(Course course) {
        System.out.println("\n📋 Attendance Log for Course: " + course.getCourseName());
        for (AttendanceRecord record : attendanceLog) {
            if (record.getCourse().equals(course)) {
                System.out.println(record);
            }
        }
    }

    public void saveAttendanceData() {
        FileStorageService.saveData(attendanceLog, "attendance_log.txt");
        System.out.println("💾 Attendance data saved successfully.");
    }
}
