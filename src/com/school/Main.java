package com.school;

import java.util.Scanner;

public class Main {

    private static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\n=== 🏫 School Directory ===");
        for (Person person : regService.getAllPeople()) {
            person.displayDetails();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        FileStorageService storageService = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(storageService);
        AttendanceService attendanceService = new AttendanceService(registrationService, storageService);

        System.out.print("Enter number of students: ");
        int studentCount = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < studentCount; i++) {
            System.out.print("Enter student ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter grade level: ");
            String grade = sc.nextLine();
            registrationService.registerStudent(new Student(id, name, grade));
        }

        System.out.print("\nEnter number of teachers: ");
        int teacherCount = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < teacherCount; i++) {
            System.out.print("Enter teacher ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Enter teacher name: ");
            String name = sc.nextLine();
            System.out.print("Enter subject taught: ");
            String subject = sc.nextLine();
            registrationService.registerTeacher(new Teacher(id, name, subject));
        }

        System.out.print("\nEnter number of staff: ");
        int staffCount = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < staffCount; i++) {
            System.out.print("Enter staff ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Enter staff name: ");
            String name = sc.nextLine();
            System.out.print("Enter staff role: ");
            String role = sc.nextLine();
            registrationService.registerStaff(new Staff(id, name, role));
        }

        System.out.print("\nEnter number of courses: ");
        int courseCount = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < courseCount; i++) {
            System.out.print("Enter course ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Enter course name: ");
            String name = sc.nextLine();
            registrationService.createCourse(new Course(id, name));
        }

        System.out.println("\n=== 📋 Enter Attendance Records (Enter 0 to stop) ===");
        while (true) {
            System.out.print("\nEnter student ID (or 0 to stop): ");
            int studentId = Integer.parseInt(sc.nextLine());
            if (studentId == 0) break;

            System.out.print("Enter course ID: ");
            int courseId = Integer.parseInt(sc.nextLine());

            System.out.print("Enter status (Present/Absent): ");
            String status = sc.nextLine();

            attendanceService.markAttendance(studentId, courseId, status);

            System.out.print("Do you want to enter another record? (yes/no): ");
            String choice = sc.nextLine().trim();
            if (choice.equalsIgnoreCase("no")) break;
        }

        displaySchoolDirectory(registrationService);
        attendanceService.displayAttendanceLog();

        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\n✅ All registration and attendance data saved successfully!");

        sc.close();
    }
}
