package School_Management.modules;

import java.util.*;

import School_Management.model.Grade;

public class AnalyticsEngine {
    // Graph representation: Node -> List of connected nodes with weights
    private Map<String, List<Grade>> graph;

    public AnalyticsEngine() {
        this.graph = new HashMap<>();
    }

    public void addGrade(String studentId, String courseId, double score) {
        Grade grade = new Grade(studentId, courseId, score);

        // Add student -> course connection
        if (!graph.containsKey(studentId)) {
            graph.put(studentId, new ArrayList<>());
        }
        graph.get(studentId).add(grade);

        // Add course -> student connection
        if (!graph.containsKey(courseId)) {
            graph.put(courseId, new ArrayList<>());
        }
        graph.get(courseId).add(grade);
    }

    public List<Grade> getStudentGrades(String studentId) {
        List<Grade> grades = graph.get(studentId);
        if (grades == null) {
            return new ArrayList<>();
        }

        // Filter to only return course grades (not student connections)
        List<Grade> result = new ArrayList<>();
        for (Grade grade : grades) {
            if (!grade.getCourseId().equals(studentId)) {
                result.add(grade);
            }
        }
        return result;
    }

    public Map<String, Object> getCoursePerformance(String courseId) {
        Map<String, Object> performance = new HashMap<>();
        List<Grade> grades = graph.get(courseId);

        if (grades == null || grades.isEmpty()) {
            performance.put("average", 0.0);
            performance.put("topPerformer", "N/A");
            performance.put("topScore", 0.0);
            performance.put("allGrades", new ArrayList<Grade>());
            return performance;
        }

        // Calculate statistics
        double sum = 0;
        double maxScore = 0;
        String topStudent = "";
        List<Grade> validGrades = new ArrayList<>();

        for (Grade grade : grades) {
            if (!grade.getStudentId().equals(courseId)) { // Ensure it's a student grade
                sum += grade.getScore();
                validGrades.add(grade);
                if (grade.getScore() > maxScore) {
                    maxScore = grade.getScore();
                    topStudent = grade.getStudentId();
                }
            }
        }

        double average = sum / validGrades.size();

        performance.put("average", average);
        performance.put("topPerformer", topStudent);
        performance.put("topScore", maxScore);
        performance.put("allGrades", validGrades);

        return performance;
    }

    public List<String> getStudentCourses(String studentId) {
        List<Grade> grades = getStudentGrades(studentId);
        List<String> courses = new ArrayList<>();
        for (Grade grade : grades) {
            courses.add(grade.getCourseId());
        }
        return courses;
    }

    public void displayStudentPerformance(String studentId) {
        List<Grade> grades = getStudentGrades(studentId);
        System.out.println("\n PERFORMANCE FOR " + studentId + " ");
        if (grades.isEmpty()) {
            System.out.println("No grades recorded.");
        } else {
            double average = grades.stream()
                    .mapToDouble(Grade::getScore)
                    .average()
                    .orElse(0.0);

            for (Grade grade : grades) {
                System.out.printf("Course: %s | Score: %.2f%n",
                        grade.getCourseId(), grade.getScore());
            }
            System.out.printf("Overall Average: %.2f%n", average);
        }
    }

    public void displayCourseAnalytics(String courseId) {
        Map<String, Object> performance = getCoursePerformance(courseId);
        System.out.println("\n ANALYTICS FOR " + courseId + " ");
        System.out.printf("Average Score: %.2f%n", performance.get("average"));
        System.out.printf("Top Performer: %s (%.2f)%n",
                performance.get("topPerformer"), performance.get("topScore"));

        @SuppressWarnings("unchecked")
        List<Grade> grades = (List<Grade>) performance.get("allGrades");
        System.out.println("All Grades:");
        for (Grade grade : grades) {
            System.out.printf("  %s: %.2f%n", grade.getStudentId(), grade.getScore());
        }
    }
}