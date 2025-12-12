# 🏫 School Management System - Data Structures in Action

A comprehensive Java-based School Management System that demonstrates the practical application of five fundamental data structures in solving real-world problems. Developed as part of a Data Structures and Algorithms academic assignment.

## 📋 Project Overview

This system modernizes university operations by implementing core management modules using optimized data structures and algorithms. Each module leverages a specific data structure that best suits its operational requirements, showcasing thoughtful design and efficient algorithmic solutions.

## 🎯 Modules & Data Structures Implemented

| Module | Data Structure | Key Operations | Time Complexity |
|--------|---------------|----------------|-----------------|
| **Student Registry** | Hash Table | Insert, Lookup, Delete | O(1) average |
| **Course Scheduling** | Queue | Enqueue, Dequeue | O(1) |
| **Fee Tracking** | Binary Search Tree | Insert, Range Query, In-order Traversal | O(log n) average |
| **Library System** | Stack + Hash Map | Push, Pop, Lookup | O(1) |
| **Performance Analytics** | Graph (Adjacency List) | Add Edge, Traverse, Analyze | O(V+E) |

## 🏗️ System Architecture

```
School_Management/
├── model/                 # Data Entities
│   ├── Student.java      # Student profile with courses list
│   ├── Course.java       # Course info with capacity
│   ├── Grade.java        # Student performance metrics
│   ├── Book.java         # Library items with borrow history
│   └── Transaction.java  # Fee transactions (BST node)
│
├── modules/              # Core Functionality (5 modules)
│   ├── StudentRegistry.java    # Hash Table implementation
│   ├── CourseScheduler.java    # Queue implementation
│   ├── FeeTracker.java         # Binary Search Tree
│   ├── LibrarySystem.java      # Stack + Hash Map
│   └── AnalyticsEngine.java    # Graph (Adjacency List)
│
├── manager/
│   └── SchoolManager.java      # Orchestrator & facade
│
└── Main.java            # Entry point
```

## 🚀 Features

### 1. Student Registry Module
- **Fast student lookup** using HashMap for O(1) average time complexity
- Automatic student ID generation
- Search students by name
- Comprehensive student management

### 2. Course Scheduling Module  
- **Fair course allocation** using Priority Queue
- Waitlist management with timestamp-based priority
- Capacity enforcement and automatic enrollment from waitlists
- Real-time course status tracking

### 3. Fee Tracking Module
- **Efficient financial reporting** using Binary Search Tree
- Date-range queries for transaction history
- Student-specific payment tracking
- Automated revenue calculation

### 4. Library System Module
- **LIFO book tracking** using Stack for borrow/return history
- ISBN-based quick lookup with HashMap
- Real-time availability status
- Comprehensive activity logging

### 5. Performance Analytics Module
- **Relationship analysis** using Graph with adjacency lists
- Course performance metrics
- Top performer identification
- Student-course relationship mapping

## 💻 Installation & Execution

### Prerequisites
- Java JDK 8 or higher
- Command-line interface

### Compilation & Execution
```bash
# Create directory structure
mkdir -p school-management-system/src/{model,modules,manager}

# Compile all Java files
cd school-management-system/src
javac model/*.java modules/*.java manager/*.java Main.java

# Run the application
java Main
```

## 📊 Sample Output
The system demonstrates all modules with comprehensive sample data:

```
MERU UNIVERSITY MANAGEMENT SYSTEM DEMONSTRATION 

1. STUDENT REGISTRY MODULE

REGISTERED STUDENTS (5)
Student{id=S1001, name=Alice Johnson, email=alice@meru.edu, year=2}
Student{id=S1002, name=Bob Smith, email=bob@meru.edu, year=2}

2. COURSE SCHEDULING MODULE

 Data Structures (CS101) 
Capacity: 3 | Enrolled: 3
Waitlist: 2 students
Enrolled: [S1001, S1002, S1003]

3. FEE TRACKING MODULE

FINANCIAL TRANSACTIONS (7)
T0001: S1001 paid $350.00 on 2024-09-10
T0002: S1002 paid $275.00 on 2024-09-15
Total Revenue: $2,150.00

4. LIBRARY SYSTEM MODULE

 LIBRARY CATALOG 
ISBN: 978-0262033848 | Introduction to Algorithms | Available: 3/5

5. ANALYTICS ENGINE MODULE

 COURSE ANALYSIS: CS101 
Average Grade: 82.50
Highest Grade: 95.00
Top Performers:
  1. S1004: 95.00
  2. S1001: 88.00
```

## 🔍 Algorithm Analysis

### Time Complexity
- **Student Operations**: O(1) average for insert, lookup, delete
- **Course Enrollment**: O(log n) for priority queue operations  
- **Financial Reports**: O(n) for BST traversal, O(log n) for inserts
- **Library Operations**: O(1) for all stack and hash map operations
- **Analytics Queries**: O(V+E) for graph traversals

### Space Complexity
- **Overall**: O(n) where n is the number of data elements
- **Each module**: Optimized for their specific use cases

## 🎓 Educational Value

This project demonstrates:
- **Practical data structure application** in real-world scenarios
- **Algorithm optimization** for different operational needs
- **Object-oriented design principles** with proper encapsulation
- **Modular architecture** for maintainable code
- **Performance analysis** using Big-O notation

## 👥 Team Contribution

This project was developed as a group assignment with the following contributions:
- **System Architecture & Integration**
- **Algorithm Design & Implementation**  
- **Performance Analysis & Optimization**
- **Documentation & Testing**

## 📝 Assignment Requirements Met

- [x] **Five different data structures** implemented
- [x] **Modular system design** with clear separation of concerns
- [x] **Comprehensive documentation** with code comments
- [x] **Performance analysis** using Big-O notation
- [x] **Sample data** for demonstration
- [x] **Ethical considerations** in system design

## 🔮 Future Enhancements

- Database persistence integration
- Web-based user interface
- Advanced analytics with machine learning
- Multi-threading for concurrent operations
- REST API for system integration



