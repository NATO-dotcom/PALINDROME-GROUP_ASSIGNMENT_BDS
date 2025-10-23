package School_Management;

import School_Management.manager.SchoolManager;

public class Main {
    public static void main(String[] args) {
        SchoolManager schoolManager = new SchoolManager();
        
        // Demonstrate all features
        schoolManager.demonstrateAllFeatures();
        
        // Additional interactive demonstrations can be added here
        demonstrateInteractiveFeatures(schoolManager);
    }
    
    private static void demonstrateInteractiveFeatures(SchoolManager schoolManager) {
        System.out.println("\n\nINTERACTIVE FEATURES DEMONSTRATION:");
        
        // Test enrolling a new student
        String newStudentId = schoolManager.getStudentRegistry()
                .addStudent("Emma Thompson", "emma@meru.edu", 1);
        System.out.println("New student registered: " + newStudentId);
        
        // Test course enrollment with new student
        String result = schoolManager.getCourseScheduler()
                .enrollStudent("CS101", newStudentId);
        System.out.println("Enrollment result: " + result);
        
        // Add a grade for new student
        schoolManager.getAnalyticsEngine()
                .addGrade(newStudentId, "CS101", 88.5);
        
        // Show updated analytics
        schoolManager.getAnalyticsEngine()
                .displayStudentPerformance(newStudentId);
    }
}
