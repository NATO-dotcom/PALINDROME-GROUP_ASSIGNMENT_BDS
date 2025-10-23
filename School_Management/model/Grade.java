package School_Management.model;

public class Grade {
    private String studentId;
    private String courseId;
    private double score;

    public Grade(String studentId, String courseId, double score) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.score = score;
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.format("Grade{student=%s, course=%s, score=%.2f}",
                studentId, courseId, score);
    }
}