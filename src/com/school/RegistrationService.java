package com.school;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    private FileStorageService fileStorageService;
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Staff> staffMembers = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public RegistrationService(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    // === Student Registration ===
    public void registerStudent(Student student) {
        students.add(student);
        System.out.println("✅ Student registered: " + student.getName());
    }

    // === Teacher Registration ===
    public void registerTeacher(Teacher teacher) {
        teachers.add(teacher);
        System.out.println("👩‍🏫 Teacher registered: " + teacher.getName());
    }

    // === Staff Registration ===
    public void registerStaff(Staff staff) {
        staffMembers.add(staff);
        System.out.println("🧑‍💼 Staff registered: " + staff.getName());
    }

    // === Course Creation (with capacity) ===
    public void createCourse(Course course) {
        courses.add(course);
        System.out.println("📘 Course created: " + course.getCourseName() + " (Capacity: " + course.getCapacity() + ")");
    }

    public Course createCourse(int id, String name, int capacity) {
        Course course = new Course(id, name, capacity);
        createCourse(course);
        return course;
    }

    // === Enrollment ===
    public boolean enrollStudentInCourse(Student student, Course course) {
        boolean success = course.addStudent(student);
        if (success) {
            System.out.println("✅ " + student.getName() + " successfully enrolled in " + course.getCourseName());
        } else {
            System.out.println("⚠️ Enrollment failed: Course '" + course.getCourseName() + "' is at full capacity.");
        }
        return success;
    }

    // === Getters ===
    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Staff> getStaffMembers() {
        return staffMembers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Person> getAllPeople() {
        List<Person> all = new ArrayList<>();
        all.addAll(students);
        all.addAll(teachers);
        all.addAll(staffMembers);
        return all;
    }

    // === Find methods for AttendanceService ===
    public Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public Course findCourseById(int id) {
        for (Course c : courses) {
            if (c.getCourseId() == id) return c;
        }
        return null;
    }

    // === Save all data ===
    public void saveAllRegistrations() {
        fileStorageService.saveStudents(students);
        fileStorageService.saveTeachers(teachers);
        fileStorageService.saveStaff(staffMembers);
        fileStorageService.saveCourses(courses);
    }
}
