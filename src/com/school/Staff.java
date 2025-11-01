package com.school;

public class Staff extends Person implements Storable {
    private String role;

    // Updated Constructor: Uses super(id, name)
    public Staff(int id, String name, String role) {
        super(id, name);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + this.getId() + ", Name: " + this.getName());
        System.out.println("Role: Staff, Position: " + role);
    }

    /**
     * Required by Storable interface.
     * Format: id,name,role
     */
    @Override
    public String toDataString() {
        return String.format("%d,%s,%s", this.getId(), this.getName(), this.role);
    }
}