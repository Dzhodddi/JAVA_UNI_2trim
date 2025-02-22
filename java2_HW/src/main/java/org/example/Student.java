package org.example;

public class Student {
    public String name;
    public double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = fixGrade(grade);
    }

    public String toStringStudent() {
        return "Student name: " + name + ", with grade: " + grade;
    }

    private double fixGrade(double grade) {
        if (grade < 0) {
            System.out.println("Grade must be positive!! Your score now is 0");
            return 0;
        }

        if (grade > 100) {
            System.out.println("Grade can't be higher than 100!! Your score now is 100");
            return 100;
        }
        return grade;
    }

    public boolean equalsStudents(Student student) {
        return student.name.equals(this.name) && student.grade == this.grade;
    }

}