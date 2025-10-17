package com.school;

public class AttendanceRecord {
    private Student student;
    private Course course;
    private String status;

    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;

        if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            this.status = status.substring(0, 1).toUpperCase() + status.substring(1).toLowerCase();
        } else {
            this.status = "Invalid";
            System.out.println("⚠️ Warning: Invalid status entered for student: " 
                + student.getName() + ". Defaulting to 'Invalid'.");
        }
    }

    // Getters
    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getStatus() {
        return status;
    }

    // Display method - richer display with polymorphic data
    public void displayRecord() {
        System.out.println(
            "Student: " + student.getName() + " (ID: " + student.getStudentId() + ") | " +
            "Course: " + course.getCourseName() + " (C" + course.getCourseId() + ") | " +
            "Status: " + status
        );
    }

    // For saving to file: keep it simple with IDs
    public String toDataString() {
        return student.getStudentId() + "," + course.getCourseId() + "," + status;
    }
}
