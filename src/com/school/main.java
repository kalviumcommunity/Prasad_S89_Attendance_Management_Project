package com.school;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("---- 🏫 Attendance Management System (Part 9: SOLID SRP) ----");

        // 1️⃣ Instantiate Services: Inject dependencies in order
        FileStorageService storageService = new FileStorageService();
        
        // RegistrationService manages all entities and uses storageService
        RegistrationService regService = new RegistrationService(storageService);
        
        // AttendanceService handles attendance and uses both storageService and regService
        AttendanceService attService = new AttendanceService(storageService, regService);

        // 2️⃣ Register Entities using RegistrationService
        
        // Create and Register Students (IDs will auto-increment from 1)
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Student s3 = new Student("Charlie");
        regService.registerStudent(s1);
        regService.registerStudent(s2);
        regService.registerStudent(s3);
        
        // Create and Register Teachers (IDs will auto-increment from 201)
        Teacher t1 = new Teacher(201, "Mr. Smith", "Physics"); // Manual ID for demo
        regService.registerTeacher(t1);

        // Create and Register Staff (IDs will auto-increment from 301)
        Staff staff1 = new Staff(301, "Ms. Jones", "Librarian"); // Manual ID for demo
        regService.registerStaff(staff1);

        // Create and Register Courses (IDs will auto-increment from 501)
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Science");
        regService.createCourse(c1);
        regService.createCourse(c2);

        // 3️⃣ Display Directory using RegistrationService
        // Pass regService to the refactored display method
        displaySchoolDirectory(regService);

        // 4️⃣ Mark Attendance (Simplified call)
        // Now using attService.markAttendance(ID, ID, status), which uses regService internally
        
        // Alice (ID 1) in Mathematics (ID 501)
        attService.markAttendance(s1.getId(), c1.getId(), "Present");
        // Bob (ID 2) in Mathematics (ID 501)
        attService.markAttendance(s2.getId(), c1.getId(), "Absent");
        // Charlie (ID 3) in Science (ID 502)
        attService.markAttendance(s3.getId(), c2.getId(), "Present");
        
        // Try marking attendance with non-existent ID
        attService.markAttendance(999, c1.getId(), "ErrorCheck");


        // 5️⃣ Display Logs
        attService.displayAttendanceLog();

        // 6️⃣ Display for Specific Student/Course (using entity looked up from regService)
        // We use the objects created earlier, which have the correct IDs.
        attService.displayAttendanceLog(s1);
        attService.displayAttendanceLog(c1);

        // 7️⃣ Save Data
        // Call regService to save all entity data (students.txt, teachers.txt, staff.txt, courses.txt)
        regService.saveAllRegistrations(); 
        
        // Call attService to save attendance log
        attService.saveAttendanceData();

        System.out.println("✅ Part 9 Complete: SOLID Service Layer Separation applied successfully.");
    }
    
    /**
     * Updated to accept RegistrationService and use its unified getAllPeople() method.
     */
    private static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\n=== 📚 School Directory ===");
        
        // Use the unified list from the RegistrationService
        List<Person> allPeople = regService.getAllPeople();
        
        if (allPeople.isEmpty()) {
            System.out.println("(No people registered)");
            return;
        }
        
        for (Person p : allPeople) {
            p.displayDetails();
        }
    }
}