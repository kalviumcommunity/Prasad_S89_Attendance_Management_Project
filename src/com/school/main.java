// package com.school;

// public class Main {
//     public static void main(String[] args) {
//         System.out.println("Welcome to the School Attendance System!");
//         System.out.println("Session 1: Project setup and Orientation complete");
//     }
// }

package com.school;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        Student[] students = new Student[2];
        students[0] = new Student();
        students[0].setDetails(1, "Alice");
        students[1] = new Student();
        students[1].setDetails(2, "Bob");

        Course[] courses = new Course[2];
        courses[0] = new Course();
        courses[0].setDetails("CS101", "Intro to programming");
        courses[1] = new Course();
        courses[1].setDetails("MA101", "Calculus I");

        System.out.println("\nRegistered Students:");
        for (Student student : students) {
            if(student != null) {
                student.displayDetails();
            }
        }
        System.out.println("\nAvailable Courses:");
        for (Course course : courses) {
            if(course != null) {
                course.displayDetails();
            }
        }
        System.out.println("\nSession 2: Core Domain Modelling Complete");
    }
}