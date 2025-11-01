package com.school;

// It is common practice for a base class like Person to be abstract.
public abstract class Person {
    private static int nextIdCounter = 1; 
    protected int id;
    protected String name;

    // 1. Existing Constructor (for initial creation/auto-increment)
    public Person(String name) {
        this.id = nextIdCounter++;
        this.name = name;
    }

    // 2. NEW Constructor (Required for loading existing data or manual ID assignment)
    // This supports the super(id, name) call in Teacher/Staff.
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
        // Optional: Update counter if the assigned ID is higher than the current counter
        if (id >= nextIdCounter) {
            nextIdCounter = id + 1;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Making displayDetails abstract forces child classes to implement their own display logic.
    public abstract void displayDetails();
}