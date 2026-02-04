package oop.edu.ucalgary;

import java.util.Arrays;

public class Student {
    private String studentID;
    private String name;
    private int[] grades; // -1 means “no grade entered”

    public Student(String studentID, String name, int numCourses) {
        if (studentID == null || name == null) {
            throw new IllegalArgumentException("studentID and name cannot be null.");
        }
        if (numCourses <= 0) {
            throw new IllegalArgumentException("numCourses must be positive.");
        }

        this.studentID = studentID;
        this.name = name;

        this.grades = new int[numCourses];
        Arrays.fill(this.grades, -1);
    }

    public void addGrade(int courseIndex, int grade) {
        if (courseIndex < 0 || courseIndex >= grades.length) {
            throw new IllegalArgumentException("Invalid course index.");
        }
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }
        grades[courseIndex] = grade;
    }

    public int getGrade(int courseIndex) {
        if (courseIndex < 0 || courseIndex >= grades.length) {
            throw new IllegalArgumentException("Invalid course index.");
        }
        return grades[courseIndex];
    }

    public double calculateAverage() {
        double total = 0.0;
        int count = 0;

        for (int g : grades) {
            if (g != -1) {
                total += g;
                count++;
            }
        }

        if (count == 0) {
            throw new IllegalStateException("No grades entered.");
        }

        return total / count;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int[] getGrades() {
        return grades;
    }
}
