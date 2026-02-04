package oop.edu.ucalgary;

/**
 * GradeManager class handles operations related to managing a list of students,
 * including adding students, retrieving them by ID, and calculating the class average.
 */
public class GradeManager {
    private Student[] students; // Fixed-size array to store student objects
    private int currentSize;    // Tracks the number of students currently added

    // Constructor to initialize the student list.
    public GradeManager(int maxStudents) {
        if (maxStudents <= 0) {
            throw new IllegalArgumentException("maxStudents must be positive.");
        }
        students = new Student[maxStudents];
        currentSize = 0;
    }

    /**
     * Adds a new student to the list if the student ID is unique.
     */
    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("student cannot be null.");
        }
        if (currentSize >= students.length) {
            throw new IllegalStateException("Cannot add more students. The list is full.");
        }

        for (int i = 0; i < currentSize; i++) {
            if (students[i].getStudentID().equals(student.getStudentID())) {
                throw new IllegalArgumentException("Student with this ID already exists.");
            }
        }

        students[currentSize] = student;
        currentSize++;
    }

    /**
     * Retrieves a student by their unique student ID.
     */
    public Student getStudentByID(String studentID) {
        for (int i = 0; i < currentSize; i++) {
            if (students[i].getStudentID().equals(studentID)) {
                return students[i];
            }
        }
        return null;
    }

    /**
     * Calculates the average grade of all students in the class.
     * Skips students with no grades.
     */
    public double calculateClassAverage() {
        double total = 0.0;
        int count = 0;

        for (int i = 0; i < currentSize; i++) {
            try {
                total += students[i].calculateAverage();
                count++;
            } catch (IllegalStateException e) {
                // skip ungraded students
            }
        }

        if (count == 0) {
            throw new IllegalStateException("No valid grades available for calculation.");
        }

        return total / count;
    }

    /**
     * Returns the total number of students currently managed by the system.
     */
    public int getTotalStudents() {
        return currentSize;
    }
}
