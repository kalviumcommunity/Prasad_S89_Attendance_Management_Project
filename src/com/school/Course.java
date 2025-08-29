// package com.school;

// public class Course {
//     String courseId;
//     String courseName;

//     public void setDetails(String id,String CName){
//         this.courseId=id;
//         this.courseName=CName;
//     }

//     public void displayDetails(){
//         System.out.println("Course Id: "+this.courseId+", Name: "+this.courseName);
//     }
// }


package com.school;

public class Course {
    private static int nextCourseIdCounter = 101;
    private int courseId;
    private String courseName;

    public Course(String courseName) {
        this.courseId = nextCourseIdCounter++;
        this.courseName = courseName;
    }

    // Getters
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void displayDetails() {
        System.out.println("Course ID: C" + courseId + ", Course Name: " + courseName);
    }
}
