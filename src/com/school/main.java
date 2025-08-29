// package com.school;

// public class Main {
//     public static void main(String[] args) {
//         System.out.println("Welcome to the School Attendance System!");
//         System.out.println("Session 1: Project setup and Orientation complete");
//     }
// }

// package com.school;

// public class Main {
//     public static void main(String[] args) {
//         System.out.println("--- School Attendance System ---");

//         Student[] students = new Student[2];
//         students[0] = new Student();
//         students[0].setDetails(1, "Alice");
//         students[1] = new Student();
//         students[1].setDetails(2, "Bob");

//         Course[] courses = new Course[2];
//         courses[0] = new Course();
//         courses[0].setDetails("CS101", "Intro to programming");
//         courses[1] = new Course();
//         courses[1].setDetails("MA101", "Calculus I");

//         System.out.println("\nRegistered Students:");
//         for (Student student : students) {
//             if(student != null) {
//                 student.displayDetails();
//             }
//         }
//         System.out.println("\nAvailable Courses:");
//         for (Course course : courses) {
//             if(course != null) {
//                 course.displayDetails();
//             }
//         }
//         System.out.println("\nSession 2: Core Domain Modelling Complete");
//     }
// }

// package com.school;


// public class Main{
//     public static void main(String[] args){
//         System.out.println("----Attendence Management System----");
//         Student[] students = new Student[2];
//         students[0] = new Student();
//         students[0].setDetails(1, "Hemanth" );
//         students[1] = new Student();
//         students[1].setDetails(2, "Sai" );

//          System.out.println("---Registered Students---");
//         for(Student student: students){
//             if(student != null){
//                 student.displayDetails();
//             }
//         }


//         Course[]  courses = new Course[2];
//         courses[0] = new Course();
//         courses[0].setDetails("CJAVA", "Java" );
//         courses[1] = new Course();
//         courses[1].setDetails("CPYTHON", "Python" );


       
//         System.out.println("---Registered Courses---");
//         for(Course course: courses){
//            if(course != null){
//             course.displayDetails();
//            }
//         }

//         System.out.println("---Marking Attendance---");
//         Attendance[] attendanceRecords = new Attendance[2];

//          attendanceRecords[0] = new Attendance();
//           attendanceRecords[0].markAttendance(1, "CJAVA", true);

//          attendanceRecords[1] = new Attendance();
//          attendanceRecords[1].markAttendance(2, "CPYTHON", false);

//        for (Attendance attendance : attendanceRecords) {
//            if (attendance != null) {
//              attendance.getAttendance();
//           }
// }




//         System.out.println("Session 2: Student and Course classes created.");
//         System.out.println("Session 3: Attendance feature added.");
//     }
// }

package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("---- Attendance Management System ----");

        // Create students
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        // Create courses
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Science");

        // Display students & courses
        System.out.println("--- Registered Students ---");
        s1.displayDetails();
        s2.displayDetails();

        System.out.println("--- Registered Courses ---");
        c1.displayDetails();
        c2.displayDetails();

        // Attendance Records
        System.out.println("--- Attendance Log ---");
        List<Attendance> attendanceLog = new ArrayList<>();

        attendanceLog.add(new Attendance(s1.getStudentId(), c1.getCourseId(), "Present"));
        attendanceLog.add(new Attendance(s2.getStudentId(), c2.getCourseId(), "Absent"));
        attendanceLog.add(new Attendance(s1.getStudentId(), c2.getCourseId(), "Late")); // invalid test

        // Display
        for (Attendance record : attendanceLog) {
            record.displayRecord();
        }

        System.out.println("Session 4: Data Encapsulation & Attendance Recording Validation Complete.");
    }
}
