package com.school;

public class Course {
    String courseId;
    String courseName;

    public void setDetails(String id,String CName){
        this.courseId=id;
        this.courseName=CName;
    }

    public void displayDetails(){
        System.out.println("Course Id: "+this.courseId+", Name: "+this.courseName);
    }
}
