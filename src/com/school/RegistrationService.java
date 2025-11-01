package com.school;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegistrationService {
    private final FileStorageService storageService;

    // Managed lists
    private final List<Student> students = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();
    private final List<Staff> staffMembers = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();

    public RegistrationService(FileStorageService storageService) {
        this.storageService = storageService;
    }

    // --- Registration Methods ---

    public void registerStudent(Student student) { 
        students.add(student); 
    }
    
    public void registerTeacher(Teacher teacher) { 
        teachers.add(teacher); 
    }
    
    public void registerStaff(Staff staff) { 
        staffMembers.add(staff); 
    }
    
    public void createCourse(Course course) { 
        courses.add(course); 
    }

    // --- Getter & Lookup Methods ---

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
    
    public List<Teacher> getTeachers() {
        return new ArrayList<>(teachers);
    }

    public List<Staff> getStaffMembers() {
        return new ArrayList<>(staffMembers);
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }
    
    // 🟢 FIX for Main.java: Implementation of getAllPeople()
    public List<Person> getAllPeople() {
        // Merge all Person-derived lists (Student, Teacher, Staff)
        return Stream.of(students, teachers, staffMembers)
                     .flatMap(List::stream)
                     .collect(Collectors.toList());
    }

    public Student findStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Course findCourseById(int id) {
        return courses.stream()
                // Assuming Course has a getId() or getCourseId() method
                .filter(c -> c.getId() == id) 
                .findFirst()
                .orElse(null);
    }

    // --- Persistence Methods ---

    public void saveAllRegistrations() {
        System.out.println("Saving all registration data...");

        // Calls the corrected generic helper method (saveData)
        saveData("students.txt", students);
        saveData("teachers.txt", teachers);
        saveData("staff.txt", staffMembers);
        saveData("courses.txt", courses);
        
        System.out.println("Registration data saved successfully.");
    }

    /**
     * Helper method to convert List<T extends Storable> to List<String> 
     * and pass it to FileStorageService.
     */
    private <T extends Storable> void saveData(String fileName, List<T> entities) {
        List<String> dataStrings = entities.stream()
                                           .map(Storable::toDataString)
                                           .collect(Collectors.toList());
        // Assumes FileStorageService.saveData(List<String> data, String fileName) exists
        storageService.saveData(dataStrings, fileName);
    }
}