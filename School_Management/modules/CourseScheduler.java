// modules/CourseScheduler.java
package School_Management.modules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import School_Management.model.Course;

public class CourseScheduler {  //declare queue
    private Map<String, Course> courses;
    private Map<String, Queue<String>> waitlists; // Course ID -> Queue of Student IDs
    private Map<String, Set<String>> enrolledStudents; // Course ID -> Set of enrolled Student IDs

    public CourseScheduler() { //initialize maps
        this.courses = new HashMap<>();
        this.waitlists = new HashMap<>();
        this.enrolledStudents = new HashMap<>();
        initializeSampleCourses();
    }

    private void initializeSampleCourses() {
        addCourse(new Course("CS101", "Data Structures", 3));
        addCourse(new Course("MATH201", "Calculus", 2));
        addCourse(new Course("PHY301", "Physics", 4));
    }

    public void addCourse(Course course) {
        courses.put(course.getCourseId(), course);
        waitlists.put(course.getCourseId(), new LinkedList<>());
        enrolledStudents.put(course.getCourseId(), new HashSet<>());
    }

    public String enrollStudent(String courseId, String studentId) {
        if (!courses.containsKey(courseId)) {
            return "Course not found";
        }

        Course course = courses.get(courseId);
        Set<String> enrolled = enrolledStudents.get(courseId);
        Queue<String> waitlist = waitlists.get(courseId);

        // Check if already enrolled
        if (enrolled.contains(studentId)) {
            return "Student already enrolled in this course";
        }

        // Check capacity
        if (enrolled.size() < course.getCapacity()) {
            enrolled.add(studentId);
            return "Successfully enrolled in " + course.getName();
        } else {
            // Add to waitlist if not already there
            if (!waitlist.contains(studentId)) {
                waitlist.offer(studentId);
                int position = waitlist.size();
                return "Added to waitlist for " + course.getName() + " at position " + position;
            } else {
                return "Already on waitlist for this course";
            }
        }
    }

    public List<String> processWaitlist(String courseId) {
        List<String> newlyEnrolled = new ArrayList<>();

        if (!courses.containsKey(courseId)) {
            return newlyEnrolled;
        }

        Course course = courses.get(courseId);
        Set<String> enrolled = enrolledStudents.get(courseId);
        Queue<String> waitlist = waitlists.get(courseId);

        while (!waitlist.isEmpty() && enrolled.size() < course.getCapacity()) {
            String studentId = waitlist.poll();
            enrolled.add(studentId);
            newlyEnrolled.add(studentId);
        }

        return newlyEnrolled;
    }

    public void displayCourseStatus(String courseId) {
        if (courses.containsKey(courseId)) {
            Course course = courses.get(courseId);
            Set<String> enrolled = enrolledStudents.get(courseId);
            Queue<String> waitlist = waitlists.get(courseId);

            System.out.println("\n" + course.getName() + " Status ");
            System.out.println("Capacity: " + course.getCapacity());
            System.out.println("Enrolled: " + enrolled.size() + " students");
            System.out.println("Waitlist: " + waitlist.size() + " students");

            System.out.println("Enrolled Students: " + enrolled);
            System.out.println("Waitlist: " + waitlist);
        }
    }
}