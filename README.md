# Grading System

A comprehensive Java-based grading system designed to manage student grades, calculate averages, and generate academic reports.

## 📚 Overview

This grading system is divided into three parts, each implementing progressive features and improvements:

```
┌─────────────┐     ┌─────────────┐     ┌─────────────┐
│   Part 1    │ --> │   Part 2    │ --> │   Part 3    │
│   Basic     │     │   Enhanced  │     │  Advanced   │
│  Features   │     │  Features   │     │  Features   │
└─────────────┘     └─────────────┘     └─────────────┘
```

## 🎯 Features

### Part 1 - Basic Grading System
- **Student Management**: Add and manage student records
- **Grade Entry**: Input grades for individual students
- **Basic Calculations**: Calculate average grades
- **Simple Reports**: Generate basic grade reports

### Part 2 - Enhanced Grading System
- **Multiple Courses**: Support for multiple course grading
- **Grade Categories**: Assignments, quizzes, midterms, finals
- **Weighted Calculations**: Calculate weighted averages
- **Improved UI**: Better user interface for data entry
- **Data Validation**: Input validation and error handling

### Part 3 - Advanced Grading System
- **Complete Grade Management**: Full CRUD operations
- **Advanced Analytics**: Statistical analysis of grades
- **Grade Distribution**: View grade distribution charts
- **Export/Import**: Save and load grade data
- **User Roles**: Different access levels (admin, teacher, student)
- **Reporting System**: Comprehensive reporting features

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- IDE (Eclipse, IntelliJ IDEA, or NetBeans)
- Maven or Gradle (optional, for dependency management)

### Installation

1. **Clone the repository**
```bash
git clone https://github.com/noor848/Grading-System-.git
cd Grading-System-
```

2. **Choose a version to run**
```bash
# For Part 1
cd part1

# For Part 2
cd part2

# For Part 3 (most advanced)
cd part3
```

3. **Compile and run**
```bash
# Using command line
javac *.java
java Main

# Or using your IDE:
# - Import the project
# - Run the main class
```

## 📂 Project Structure

```
Grading-System-/
├── part1/                  # Basic grading system
│   ├── src/
│   │   ├── Main.java
│   │   ├── Student.java
│   │   ├── Grade.java
│   │   └── GradeCalculator.java
│   └── README.md
│
├── part2/                  # Enhanced grading system
│   ├── src/
│   │   ├── Main.java
│   │   ├── Student.java
│   │   ├── Course.java
│   │   ├── Grade.java
│   │   └── GradeManager.java
│   └── README.md
│
└── part3/                  # Advanced grading system
    ├── src/
    │   ├── Main.java
    │   ├── models/
    │   │   ├── Student.java
    │   │   ├── Course.java
    │   │   └── Grade.java
    │   ├── services/
    │   │   ├── GradeService.java
    │   │   └── ReportService.java
    │   ├── controllers/
    │   │   └── GradeController.java
    │   └── utils/
    │       ├── DataManager.java
    │       └── Validator.java
    └── README.md
```

## 💻 Usage

### Part 1 - Basic Usage

```java
// Create a new student
Student student = new Student("John Doe", "12345");

// Add grades
student.addGrade(85.5);
student.addGrade(90.0);
student.addGrade(78.5);

// Calculate average
double average = student.calculateAverage();
System.out.println("Average: " + average);
```

### Part 2 - Enhanced Usage

```java
// Create a course
Course course = new Course("Computer Science 101", "CS101");

// Add students to course
course.addStudent(new Student("John Doe", "12345"));

// Add grades with categories
course.addGrade("12345", "Assignment 1", 85.0, 0.2); // 20% weight
course.addGrade("12345", "Midterm", 90.0, 0.3);      // 30% weight
course.addGrade("12345", "Final", 88.0, 0.5);        // 50% weight

// Get weighted average
double weightedAvg = course.getWeightedAverage("12345");
```

### Part 3 - Advanced Usage

```java
// Initialize the grading system
GradeManager manager = new GradeManager();

// Add student and courses
manager.addStudent("John Doe", "12345");
manager.addCourse("CS101", "Computer Science");

// Enroll student in course
manager.enrollStudent("12345", "CS101");

// Add grades
manager.addGrade("12345", "CS101", "Assignment 1", 85.0);

// Generate report
Report report = manager.generateReport("12345");
report.display();

// Export data
manager.exportToFile("grades.csv");
```

## 🎓 Grading Scale

Default grading scale used:

| Percentage | Letter Grade | GPA |
|------------|--------------|-----|
| 90-100     | A            | 4.0 |
| 80-89      | B            | 3.0 |
| 70-79      | C            | 2.0 |
| 60-69      | D            | 1.0 |
| Below 60   | F            | 0.0 |


