package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("---- Attendance Management System ----");

        // --- Register Students ---
        Student student1 = new Student("Hemanth");
        Student student2 = new Student("Sai");

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        System.out.println("\n--- Registered Students ---");
        for (Student s : students) {
            s.displayDetails();
        }

        // --- Register Teachers ---
        Teacher teacher1 = new Teacher("Mr. Ramesh", "Mathematics");
        Teacher teacher2 = new Teacher("Mrs. Sita", "Computer Science");

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher1);
        teachers.add(teacher2);

        System.out.println("\n--- Registered Teachers ---");
        for (Teacher t : teachers) {
            t.displayDetails();
        }

        // --- Register Staff ---
        Staff staff1 = new Staff("Kiran", "Administrator");
        Staff staff2 = new Staff("Latha", "Librarian");

        List<Staff> staffList = new ArrayList<>();
        staffList.add(staff1);
        staffList.add(staff2);

        System.out.println("\n--- Registered Staff ---");
        for (Staff st : staffList) {
            st.displayDetails();
        }

        // --- Register Courses ---
        Course course1 = new Course("Java Programming");
        Course course2 = new Course("Python Basics");

        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        System.out.println("\n--- Registered Courses ---");
        for (Course c : courses) {
            c.displayDetails();
        }

        // --- Mark Attendance ---
        System.out.println("\n--- Attendance Log ---");
        List<Attendance> attendanceLog = new ArrayList<>();

        // Valid entries
        attendanceLog.add(new Attendance(student1.getStudentId(), course1.getCourseId(), "Present"));
        attendanceLog.add(new Attendance(student2.getStudentId(), course2.getCourseId(), "Absent"));

        // Invalid status test
        attendanceLog.add(new Attendance(student1.getStudentId(), course2.getCourseId(), "Late"));

        for (Attendance record : attendanceLog) {
            record.displayRecord();
        }

        System.out.println("\n✅ Session Complete: All modules integrated successfully!");
    }
}
