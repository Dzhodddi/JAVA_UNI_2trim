package org.example;

import java.io.IOException;

public class StudentsList {
    private Student[] students;

    public StudentsList(Student[] students) {
        this.students = students;
    }

    public StudentsList() {
    }

    public void setStudentsList() {
        int numberOfStudents = DataInput.getNotNegativeInt("Students count: ");
        Student[] students = new Student[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            Student student = getStudent();
            students[i] = student;
        }
        this.students = students;
    }

    public Student[] getStudentsList() {
        return this.students;
    }

    private Student getStudent(){
        try {
            String name = DataInput.getString("Input student's name: ");
            int grade = DataInput.getInt("Input student's grade: ");
            return new Student(name, grade);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void studentsInfo(Student [] students) {
        for (Student student : students) {
            System.out.println(student.toStringStudent());
        }
    }

    public double[] studentsGrades() {
        double[] grades = new double[students.length];
        for (int i = 0; i < students.length; i++) {
            grades[i] = students[i].grade;
        }
        return grades;
    }

    public String[] studentsName() {
        String[] names = new String[students.length];
        for (int i = 0; i < students.length; i++) {
            names[i] = students[i].name;
        }
        return names;
    }

    //    true for ASC, false for DESC
    public Student[] sortStudentsByGrade(boolean ascending) {
        Student[] sortedStudentByGrade = Utils.quickSortByGrade(students, 0, students.length - 1);
        if (!ascending) {
            sortedStudentByGrade = Utils.reverseArrayOfStudents(sortedStudentByGrade);
        }
        return sortedStudentByGrade;
    }

    //    true for ASC, false for DESC
    public Student[] sortStudentsByName(boolean ascending) {
        Student[] sortedStudentByName = Utils.quickSortByName(students, 0, students.length - 1);
        if (!ascending) {
            sortedStudentByName = Utils.reverseArrayOfStudents(sortedStudentByName);
        }
        return sortedStudentByName;
    }

}
