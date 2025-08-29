// package com.school;

// public class Attendance {
//     int studentId;
//     String courseId;
//     boolean isPresent;

//     public void markAttendance(int studentId, String courseId, boolean isPresent) {
//         this.studentId = studentId;
//         this.courseId = courseId;
//         this.isPresent = isPresent;
//     }

//     public void getAttendance() {
//         System.out.println("Student ID: " + studentId 
//             + " | Course ID: " + courseId 
//             + " | Present: " + (isPresent ? "Yes" : "No"));
//     }
// }

package com.school;

public class Attendance {
    private int studentId;
    private int courseId;
    private String status;

    public Attendance(int studentId, int courseId, String status) {
        this.studentId = studentId;
        this.courseId = courseId;

        if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            this.status = status;
        } else {
            this.status = "Invalid";
            System.out.println("⚠️ Warning: Invalid status entered for Student ID " + studentId);
        }
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getStatus() {
        return status;
    }

    public void displayRecord() {
        System.out.println("Student ID: " + studentId + ", Course ID: C" + courseId + ", Status: " + status);
    }
}
