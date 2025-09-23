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
        List<AttendanceRecord> attendanceLog = new ArrayList<>();
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

        System.out.print("\nEnter number of attendance records: ");
        int recordCount = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < recordCount; i++) {
            System.out.print("Enter student index (0 to " + (students.size() - 1) + "): ");
            int index = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter course index (0 to " + (courses.size() - 1) + "): ");
            int courseIndex = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter status (Present/Absent): ");
            String status = sc.nextLine();

\            attendanceLog.add(new AttendanceRecord(students.get(index), courses.get(courseIndex), status));
        }

        List<Person> schoolPeople = new ArrayList<>();
        schoolPeople.addAll(students);
        schoolPeople.addAll(teachers);
        schoolPeople.addAll(staffMembers);

        displaySchoolDirectory(schoolPeople);

        System.out.println("\n=== Attendance Records ===");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        List<Student> studentsToSave = schoolPeople.stream()
        .filter(p -> p instanceof Student)
        .map(p -> (Student) p)
        .collect(Collectors.toList());

        FileStorageService.saveData(studentsToSave, "students.txt");

        sc.close();
    }
}
