// model/Student.java
package School_Management.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String name;
    private String email;
    private int year;
    private List<String> courses;

    public Student(String studentId, String name, String email, int year) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.year = year;
        this.courses = new ArrayList<>();
    }

    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getYear() {
        return year;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void addCourse(String courseId) {
        if (!courses.contains(courseId)) {
            courses.add(courseId);
        }
    }

    @Override
    public String toString() {
        return String.format("Student{id=%s, name=%s, email=%s, year=%d}",
                studentId, name, email, year);
    }
}