package com.school;

public class Student extends Person implements Storable { // NOTE: Student should extend Person
    // NOTE: The previous code was using studentId, but Person already defines 'id'.
    // For simplicity, I'm adjusting to match the Person class's fields if Student extends it.

    // If Student does NOT extend Person, use the fields below:
    /*
    private static int nextStudentIdCounter = 1;
    private int studentId;
    private String name;
    */
    
    // Assuming Student extends Person (as Teacher and Staff did)
    
    // 1. Constructor for new student creation (auto-incrementing ID)
    public Student(String name) {
        super(name); // Uses Person's constructor that auto-generates the ID
    }

    // 2. NEW Constructor for loading existing data (explicit ID)
    // This is required for loading data from students.txt
    public Student(int id, String name) {
        super(id, name); // Uses Person's constructor that accepts an explicit ID
    }

    // Getters
    // We can rely on Person's getId() and getName(), but keeping these for compatibility:
    public int getStudentId() {
        return this.getId();
    }

    // public String getName() is already inherited from Person

    @Override
    public void displayDetails() {
        System.out.println("Student ID: " + this.getId() + ", Name: " + this.getName());
    }

    /**
     * Required by Storable interface to format data for file storage.
     * Format: id,name
     */
    @Override
    public String toDataString() {
        return String.format("%d,%s", this.getId(), this.getName());
    }
}