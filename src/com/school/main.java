package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("---- 🏫 Attendance Management System (Part 8) ----");

        // 1️⃣ Create Students
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Student s3 = new Student("Charlie");

        List<Student> allStudents = new ArrayList<>();
        allStudents.add(s1);
        allStudents.add(s2);
        allStudents.add(s3);

        // 2️⃣ Create Courses
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Science");

        List<Course> allCourses = new ArrayList<>();
        allCourses.add(c1);
        allCourses.add(c2);

        // 3️⃣ FileStorageService + AttendanceService
        FileStorageService storageService = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(storageService);

        // 4️⃣ Mark Attendance (Overloaded Method 1)
        attendanceService.markAttendance(s1, c1, "Present");
        attendanceService.markAttendance(s2, c1, "Absent");

        // 5️⃣ Mark Attendance (Overloaded Method 2)
        attendanceService.markAttendance(s3.getStudentId(), c2.getCourseId(), "Present", allStudents, allCourses);

        // 6️⃣ Display All Logs
        attendanceService.displayAttendanceLog();

        // 7️⃣ Display for Specific Student
        attendanceService.displayAttendanceLog(s1);

        // 8️⃣ Display for Specific Course
        attendanceService.displayAttendanceLog(c1);

        // 9️⃣ Save Attendance
        attendanceService.saveAttendanceData();

        System.out.println("✅ Part 8 Complete: Overloaded methods implemented successfully.");
    }
}
