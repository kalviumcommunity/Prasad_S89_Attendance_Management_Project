// package com.school;

// public class Student {
//     int studentId;
//     String name;

//     public  void setDetails(int id,String studentName) {
//         this.studentId=id;
//         this.name=studentName;
//     }

//     public void displayDetails(){
//         System.out.println("Student Id:"+this.studentId+", Name: "+this.name);
//     }
// }


package com.school;

public class Student {
    private static int nextStudentIdCounter = 1;
    private int studentId;
    private String name;

    public Student(String name) {
        this.studentId = nextStudentIdCounter++;
        this.name = name;
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void displayDetails() {
        System.out.println("Student ID: " + studentId + ", Name: " + name);
    }
}
