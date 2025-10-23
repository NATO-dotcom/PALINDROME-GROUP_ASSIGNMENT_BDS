package School_Management.manager;

import School_Management.modules.*;
import java.util.Random;

public class SchoolManager {
    private StudentRegistry studentRegistry;
    private CourseScheduler courseScheduler;
    private FeeTracker feeTracker;
    private LibrarySystem librarySystem;
    private AnalyticsEngine analyticsEngine;
    private Random random;

    public SchoolManager() {
        this.studentRegistry = new StudentRegistry();
        this.courseScheduler = new CourseScheduler();
        this.feeTracker = new FeeTracker();
        this.librarySystem = new LibrarySystem();
        this.analyticsEngine = new AnalyticsEngine();
        this.random = new Random();

        initializeSampleData();
    }

    private void initializeSampleData() {
        // Add sample students
        String[] students = {
                studentRegistry.addStudent("Alice Johnson", "alice@meru.edu", 2),
                studentRegistry.addStudent("Bob Smith", "bob@meru.edu", 2),
                studentRegistry.addStudent("Carol Davis", "carol@meru.edu", 1),
                studentRegistry.addStudent("David Wilson", "david@meru.edu", 3)
        };

        // Add sample fee transactions
        for (String studentId : students) {
            feeTracker.addTransaction(studentId, 250.00 + random.nextInt(200),
                    "2024-09-" + (10 + random.nextInt(10)));
        }

        // Enroll students in courses and add grades
        String[] courses = { "CS101", "MATH201", "PHY301" };
        for (String studentId : students) {
            for (String courseId : courses) {
                if (random.nextBoolean()) {
                    courseScheduler.enrollStudent(courseId, studentId);
                    // Add random grade between 70-95
                    double grade = 70 + random.nextInt(26);
                    analyticsEngine.addGrade(studentId, courseId, grade);
                }
            }
        }

        // Process some waitlists
        courseScheduler.processWaitlist("CS101");
    }

    // Public methods to access modules
    public StudentRegistry getStudentRegistry() {
        return studentRegistry;
    }

    public CourseScheduler getCourseScheduler() {
        return courseScheduler;
    }

    public FeeTracker getFeeTracker() {
        return feeTracker;
    }

    public LibrarySystem getLibrarySystem() {
        return librarySystem;
    }

    public AnalyticsEngine getAnalyticsEngine() {
        return analyticsEngine;
    }

    public void demonstrateAllFeatures() {
        System.out.println("MERU UNIVERSITY MANAGEMENT SYSTEM DEMONSTRATION: ");

        // 1. Student Registry Demo
        studentRegistry.displayAllStudents();

        // 2. Course Scheduling Demo
        courseScheduler.displayCourseStatus("CS101");
        courseScheduler.displayCourseStatus("MATH201");

        // 3. Fee Tracking Demo
        feeTracker.displayAllTransactions();

        // 4. Library System Demo
        librarySystem.displayAllBooks();
        librarySystem.displayBookStatus("ISBN001");

        // 5. Analytics Demo
        analyticsEngine.displayStudentPerformance("S1001");
        analyticsEngine.displayCourseAnalytics("CS101");
    }
}