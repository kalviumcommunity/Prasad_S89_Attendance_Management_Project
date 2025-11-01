package com.school;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceService {
    private final List<AttendanceRecord> attendanceLog;
    private final FileStorageService storageService;
    
    // 🆕 Dependency: RegistrationService handles all entity lookups.
    private final RegistrationService registrationService; 

    // 🆕 Updated Constructor: Takes RegistrationService
    public AttendanceService(FileStorageService storageService, RegistrationService registrationService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
        this.registrationService = registrationService;
    }

    // ❌ REMOVED: Overloaded method using Student & Course objects directly (Part 8 version)
    // We are focusing on the ID-based public API for the Main class.
    /*
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
        System.out.println("✅ Marked attendance for " + student.getName() + " in " + course.getCourseName());
    }
    */
    
    // 🔄 REFACTORED method: Now relies solely on RegistrationService for lookup.
    // The previous List<Student> and List<Course> parameters are GONE.
    public boolean markAttendance(int studentId, int courseId, String status) {
        
        // 🔍 Use RegistrationService for lookups (SRP)
        Student student = registrationService.findStudentById(studentId);
        Course course = registrationService.findCourseById(courseId);

        if (student != null && course != null) {
            AttendanceRecord record = new AttendanceRecord(student, course, status);
            attendanceLog.add(record);
            System.out.printf("✅ Marked attendance for %s (ID: %d) in %s (C%d) as %s.%n", 
                              student.getName(), student.getId(), course.getCourseName(), course.getCourseId(), status);
            return true;
        } else {
            System.out.println("⚠️ Could not find student or course for IDs: " 
                + studentId + ", " + courseId + ". Attendance not marked.");
            return false;
        }
    }

    // ❌ REMOVED: Overloaded method using IDs and external lists (Part 8 version)
    // This is replaced by the simplified method above.
    
    // ❌ REMOVED: Helper methods findStudentById and findCourseById
    // These responsibilities now belong to RegistrationService.

    // 📝 Display All (No change needed)
    public void displayAttendanceLog() {
        System.out.println("\n=== 📜 Full Attendance Log ===");
        if (attendanceLog.isEmpty()) {
            System.out.println("(No records yet)");
            return;
        }
        for (AttendanceRecord record : attendanceLog) {
            // Assuming AttendanceRecord has a displayRecord() method
            System.out.println(record.toDataString()); 
        }
    }

    // 📝 Display for specific student (Requires Student object, which Main will need to look up)
    public void displayAttendanceLog(Student student) {
        System.out.println("=== 📚 Attendance Log for Student: " + student.getName() + " ===");
        List<AttendanceRecord> filtered = attendanceLog.stream()
                .filter(r -> r.getStudent().getId() == student.getId())
                .collect(Collectors.toList());
        if (filtered.isEmpty()) {
            System.out.println("(No records for this student)");
            return;
        }
        filtered.forEach(r -> System.out.println(r.toDataString()));
    }

    // 📝 Display for specific course (Requires Course object, which Main will need to look up)
    public void displayAttendanceLog(Course course) {
        System.out.println("=== 🧠 Attendance Log for Course: " + course.getCourseName() + " ===");
        List<AttendanceRecord> filtered = attendanceLog.stream()
                .filter(r -> r.getCourse().getCourseId() == course.getCourseId())
                .collect(Collectors.toList());
        if (filtered.isEmpty()) {
            System.out.println("(No records for this course)");
            return;
        }
        filtered.forEach(r -> System.out.println(r.toDataString()));
    }

    // 💾 Save to file (No change needed)
    public void saveAttendanceData() {
        List<String> dataLines = new ArrayList<>();
        for (AttendanceRecord record : attendanceLog) {
            dataLines.add(record.toDataString());
        }
        storageService.saveData(dataLines, "attendance_log.txt");
        System.out.println("💾 Attendance data saved to attendance_log.txt");
    }
}