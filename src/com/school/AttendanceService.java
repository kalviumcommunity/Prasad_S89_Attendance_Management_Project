package com.school;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    public AttendanceService(FileStorageService storageService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
    }

    // ✅ 1️⃣ Overloaded method: Using Student & Course objects directly
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
        System.out.println("✅ Marked attendance for " + student.getName() + " in " + course.getCourseName());
    }

    // ✅ 2️⃣ Overloaded method: Using IDs + lookups
    public void markAttendance(int studentId, int courseId, String status, 
                               List<Student> allStudents, List<Course> allCourses) {
        Student student = findStudentById(studentId, allStudents);
        Course course = findCourseById(courseId, allCourses);

        if (student != null && course != null) {
            markAttendance(student, course, status);
        } else {
            System.out.println("⚠️ Could not find student or course for IDs: " 
                + studentId + ", " + courseId);
        }
    }

    // 🔍 Helper methods
    private Student findStudentById(int id, List<Student> allStudents) {
        for (Student s : allStudents) {
            if (s.getStudentId() == id) {
                return s;
            }
        }
        return null;
    }

    private Course findCourseById(int id, List<Course> allCourses) {
        for (Course c : allCourses) {
            if (c.getCourseId() == id) {
                return c;
            }
        }
        return null;
    }

    // 📝 Display All
    public void displayAttendanceLog() {
        System.out.println("=== 📜 Full Attendance Log ===");
        if (attendanceLog.isEmpty()) {
            System.out.println("(No records yet)");
            return;
        }
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }

    // 📝 Display for specific student
    public void displayAttendanceLog(Student student) {
        System.out.println("=== 📚 Attendance Log for Student: " + student.getName() + " ===");
        List<AttendanceRecord> filtered = attendanceLog.stream()
                .filter(r -> r.getStudent().getStudentId() == student.getStudentId())
                .collect(Collectors.toList());
        if (filtered.isEmpty()) {
            System.out.println("(No records for this student)");
            return;
        }
        filtered.forEach(AttendanceRecord::displayRecord);
    }

    // 📝 Display for specific course
    public void displayAttendanceLog(Course course) {
        System.out.println("=== 🧠 Attendance Log for Course: " + course.getCourseName() + " ===");
        List<AttendanceRecord> filtered = attendanceLog.stream()
                .filter(r -> r.getCourse().getCourseId() == course.getCourseId())
                .collect(Collectors.toList());
        if (filtered.isEmpty()) {
            System.out.println("(No records for this course)");
            return;
        }
        filtered.forEach(AttendanceRecord::displayRecord);
    }

    // 💾 Save to file
    public void saveAttendanceData() {
        List<String> dataLines = new ArrayList<>();
        for (AttendanceRecord record : attendanceLog) {
            dataLines.add(record.toDataString());
        }
        storageService.saveData(dataLines, "attendance_log.txt");
        System.out.println("💾 Attendance data saved to attendance_log.txt");
    }
}
