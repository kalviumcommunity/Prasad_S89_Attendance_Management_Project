package com.school;

public class Course implements Storable {
    private static int nextCourseIdCounter = 501; // Starting ID higher than students/staff for clarity
    private int courseId;
    private String courseName;

    // 1. Constructor for new course creation (auto-incrementing ID)
    public Course(String courseName) {
        this.courseId = nextCourseIdCounter++;
        this.courseName = courseName;
    }

    // 2. NEW Constructor for loading existing data (explicit ID)
    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        // Update counter to avoid conflicts if the loaded ID is higher
        if (courseId >= nextCourseIdCounter) {
            nextCourseIdCounter = courseId + 1;
        }
    }

    // Getters
    public int getId() {
        return courseId; // Renamed for consistency with findCourseById(int id)
    }

    public String getTitle() {
        return courseName; // Renamed for clarity in lookup (if needed)
    }
    
    // Existing Getters for backwards compatibility
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void displayDetails() {
        System.out.println("Course ID: " + courseId + ", Course Name: " + courseName);
    }
    
    /**
     * Required by Storable interface to format data for file storage.
     * Format: id,name
     */
    @Override
    public String toDataString() {
        // Use courseId and courseName for persistence
        return String.format("%d,%s", this.courseId, this.courseName);
    }
}