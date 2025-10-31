package com.school;

import java.io.*;
import java.util.*;

public class FileStorageService {
    private String filename;

    public FileStorageService(String filename) {
        this.filename = filename;
    }

    public FileStorageService() {
        this.filename = "default_log.txt";
    }

    // === Generic Save Method ===
    public static <T> void saveData(List<T> dataList, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, false))) {
            for (T item : dataList) {
                writer.println(item.toString());
            }
            System.out.println("✅ Data saved to " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error saving data: " + e.getMessage());
        }
    }

    // === Specific Save Methods ===
    public void saveStudents(List<Student> students) {
        saveData(students, "students.txt");
    }

    public void saveTeachers(List<Teacher> teachers) {
        saveData(teachers, "teachers.txt");
    }

    public void saveStaff(List<Staff> staffMembers) {
        saveData(staffMembers, "staff.txt");
    }

    public void saveCourses(List<Course> courses) {
        saveData(courses, "courses.txt");
    }

    public void saveAttendance(List<AttendanceRecord> attendanceRecords) {
        saveData(attendanceRecords, "attendance_log.txt");
    }
}
