package com.school;

public class Teacher extends Person implements Storable {
    private String subjectTaught;

    // Updated Constructor: Uses super(id, name)
    public Teacher(int id, String name, String subjectTaught) {
        super(id, name);
        this.subjectTaught = subjectTaught;
    }

    public String getSubjectTaught() {
        return subjectTaught;
    }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + this.getId() + ", Name: " + this.getName());
        System.out.println("Role: Teacher, Subject: " + subjectTaught);
    }
    
    /**
     * Required by Storable interface.
     * Format: id,name,subjectTaught
     */
    @Override
    public String toDataString() {
        return String.format("%d,%s,%s", this.getId(), this.getName(), this.subjectTaught);
    }
}