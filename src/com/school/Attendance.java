package com.school;

public class Attendance {
    int studentId;
    String courseId;
    boolean isPresent;

    public void markAttendance(int studentId, String courseId, boolean isPresent) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.isPresent = isPresent;
    }

    public void getAttendance() {
        System.out.println("Student ID: " + studentId 
            + " | Course ID: " + courseId 
            + " | Present: " + (isPresent ? "Yes" : "No"));
    }
}