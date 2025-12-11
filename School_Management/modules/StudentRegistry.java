package School_Management.modules;

import java.util.HashMap;
import java.util.Map;

import School_Management.model.Student;

public class StudentRegistry {
    private Map<String, Student> students; // Hash Table
    private int nextId;
    
    public StudentRegistry() {
        this.students = new HashMap<>();// Initialize HashMap
        this.nextId = 1001;
    }
    
    public String addStudent(String name, String email, int year) {
        String studentId = "S" + nextId++;
        Student student = new Student(studentId, name, email, year);
        students.put(studentId, student);
        return studentId;
    }
    
    public Student findStudent(String studentId) {
        return students.get(studentId);
    }
    
    public boolean removeStudent(String studentId) {
        if (students.containsKey(studentId)) {
            students.remove(studentId);
            return true;
        }
        return false;
    }
    
    public void displayAllStudents() {
        System.out.println("\nALL STUDENTS ");
        for (Student student : students.values()) {
            System.out.println(student);
        }
    }
    
    public int getTotalStudents() {
        return students.size();
    }
}