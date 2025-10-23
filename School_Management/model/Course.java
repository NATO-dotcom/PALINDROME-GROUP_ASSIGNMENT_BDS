package School_Management.model;

public class Course {
    private String courseId;
    private String name;
    private int capacity;

    public Course(String courseId, String name, int capacity) {
        this.courseId = courseId;
        this.name = name;
        this.capacity = capacity;
    }

    // Getters
    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return String.format("Course{id=%s, name=%s, capacity=%d}",
                courseId, name, capacity);
    }
}