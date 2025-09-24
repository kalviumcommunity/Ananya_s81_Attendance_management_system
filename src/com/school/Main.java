package com.school;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("\n=== School Directory ===");
        for (Person person : people) {
            person.displayDetails(); // polymorphic call
            System.out.println("-----------------");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();
        List<Staff> staffMembers = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int studentCount = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < studentCount; i++) {
            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter grade level: ");
            String grade = sc.nextLine();
            students.add(new Student(id, name, grade));
        }

        System.out.print("\nEnter number of teachers: ");
        int teacherCount = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < teacherCount; i++) {
            System.out.print("Enter teacher name: ");
            String name = sc.nextLine();
            System.out.print("Enter subject taught: ");
            String subject = sc.nextLine();
            teachers.add(new Teacher(name, subject));
        }

        System.out.print("\nEnter number of staff: ");
        int staffCount = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < staffCount; i++) {
            System.out.print("Enter staff name: ");
            String name = sc.nextLine();
            System.out.print("Enter staff role: ");
            String role = sc.nextLine();
            staffMembers.add(new Staff(name, role));
        }

        System.out.print("\nEnter number of courses: ");
        int courseCount = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < courseCount; i++) {
            System.out.print("Enter course ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter course name: ");
            String name = sc.nextLine();
            courses.add(new Course(id, name));
        }

        FileStorageService storageService = new FileStorageService("attendance_log.txt");
        AttendanceService attendanceService = new AttendanceService(storageService);


        System.out.println("\n=== Enter Attendance Records (Enter student ID 0 to stop) ===");

while (true) {
    int tempStudentId = -1;
    int tempCourseId = -1;
    String status = "";

    // Get valid student ID
    while (true) {
        try {
            System.out.print("\nEnter student ID (or 0 to stop): ");
            tempStudentId = Integer.parseInt(sc.nextLine().trim());
            break;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    if (tempStudentId == 0) break; // exit loop

    // Get valid course ID
    while (true) {
        try {
            System.out.print("Enter course ID: ");
            tempCourseId = Integer.parseInt(sc.nextLine().trim());
            break;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    // Get status
    while (true) {
        System.out.print("Enter status (Present/Absent): ");
        status = sc.nextLine().trim();
        if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            break;
        } else {
            System.out.println("Invalid status. Enter 'Present' or 'Absent'.");
        }
    }

    // Make final copies for lambda
    final int studentId = tempStudentId;
    final int courseId = tempCourseId;

    // Lookup student and course
    Student student = students.stream()
            .filter(s -> s.getId() == studentId)
            .findFirst()
            .orElse(null);
    Course course = courses.stream()
            .filter(c -> c.getCourseId() == courseId)
            .findFirst()
            .orElse(null);

    if (student != null && course != null) {
        attendanceService.markAttendance(studentId, courseId, status, students, courses);
    } else {
        System.out.println("Student or Course not found for IDs: " + studentId + ", " + courseId);
    }
    System.out.print("Do you want to enter another record? (yes/no): ");
    String choice = sc.nextLine().trim();
    if (choice.equalsIgnoreCase("no")) {
        break;
    }
}


        List<Person> schoolPeople = new ArrayList<>();
        schoolPeople.addAll(students);
        schoolPeople.addAll(teachers);
        schoolPeople.addAll(staffMembers);
        displaySchoolDirectory(schoolPeople);

        System.out.println("\n=== Attendance Records ===");
        attendanceService.displayAttendanceLog();
        if (!students.isEmpty()) {
            attendanceService.displayAttendanceLog(students.get(0));
        }
        if (!courses.isEmpty()) {
            attendanceService.displayAttendanceLog(courses.get(0));
        }

        attendanceService.saveAttendanceData();

        List<Student> studentsToSave = schoolPeople.stream()
                .filter(p -> p instanceof Student)
                .map(p -> (Student) p)
                .collect(Collectors.toList());
        FileStorageService.saveData(studentsToSave, "students.txt");

        sc.close();
    }
}
