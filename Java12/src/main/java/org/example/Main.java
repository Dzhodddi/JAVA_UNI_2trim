package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

@Getter
@Setter
@ToString
class Student {
   private String name;
   private int age;
   private ArrayList<Double> scores = new ArrayList<>();
   private int courseYear;
   Student(String name, int age, ArrayList<Double> scores, int courseYear) {
       this.name = name;
       this.age = age;
       this.scores = scores;
       this.courseYear = courseYear;
   }

   public double calculateAverage() {
       double sum = calculateSum();
       if (scores.isEmpty())
           return 0;
       return sum / scores.size();
   }

   public double calculateSum() {
       double sum = 0;
       for (Double score : scores) {
           sum += score;
       }
       return sum;
   }

   public void addScore(double score) {
       scores.add(score);
   }

   public void addCourseYear() {
       courseYear++;
       if (courseYear == 4)
           System.out.println("This is " + name + "  final course year");
       if (courseYear >= 5)
           System.out.println(name +  " ended bachelor's degree");
   }


}


@Getter
@Setter
class StudentGroup {
    private String name;
    private ArrayList<Student> students = new ArrayList<>();
    StudentGroup(String name, ArrayList<Student> students) {
        this.name = name;
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudent(String name) {
        int studentIndex = findStudent(name);
        if (studentIndex == -1)
            return;
        students.remove(studentIndex);
    }

    public void editStudent(String name, String newName) {
        int studentIndex = findStudent(name);
        if (studentIndex == -1)
            return;
        System.out.println(studentIndex);
        students.get(studentIndex).setName(newName);
    }

    public int findStudent(String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name))
                return i;
        }
        return -1;
    }

    public double calculateSum() {
        double sum = 0;
        for (Student student : students) {
            sum += student.calculateSum();
        }
        return sum;
    }

    public int countScores() {
        int count = 0;
        for (Student student : students) {
            count += student.getScores().size();
        }
        return count;
    }

    public double calculateAverage() {
        double sum = calculateSum();
        if (countScores() == 0)
            return 0;
        return sum / countScores();
    }

    public ArrayList<Student> getStudentsAboveAverage() {
        ArrayList<Student> studentsAboveAverage = new ArrayList<>();
        for (Student student : students) {
            if (student.calculateAverage() >= this.calculateAverage())
                studentsAboveAverage.add(student);
        }
        return studentsAboveAverage;
    }

    public ArrayList<Student> getStudentsBelowAverage() {
        ArrayList<Student> studentsBelowAverage = new ArrayList<>();
        for (Student student : students) {
            if (student.calculateAverage() <= this.calculateAverage())
                studentsBelowAverage.add(student);
        }
        return studentsBelowAverage;
    }

    public HashSet<Student> getUniqueNameStudents() {
        return new HashSet<>(students);
    }

    public void addCourseYearOfGroup() {
        for (Student student : students) {
            student.addCourseYear();
        }
    }

    public void studentsInfo() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        StudentGroup studentGroup = new StudentGroup("SE-1", new ArrayList<>());
        while (true) {
            System.out.print("Enter action: 1 - to add, 2 - to edit, 3 - to delete, 4 - to add score, 5 - to add Year, -1 - to exit: ");
            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine();
            int actionInt;
            try {
                actionInt = Integer.parseInt(action);
            } catch (NumberFormatException e) {
                scanner.close();
                studentGroupInfo(studentGroup);
                break;
            }
            switch (actionInt) {
                case 1:
                    Student newStudent = createStudent();
                    studentGroup.addStudent(newStudent);
                    break;
                case 2:
                    {
                        String name = DataInput.getString("Enter name: ");
                        String newName = DataInput.getString("Enter new name: ");
                        studentGroup.editStudent(name, newName);
                        break;
                    }

                case 3:
                    {
                        String name = DataInput.getString("Enter name: ");
                        studentGroup.deleteStudent(name);
                        break;
                    }
                case 4:
                    {
                        String name = DataInput.getString("Enter name: ");
                        double newScore = DataInput.validateNumber("Enter new score: ", 0, 100);
                        int index = studentGroup.findStudent(name);
                        if (index == -1)
                            break;
                        studentGroup.getStudents().get(index).addScore(newScore);
                    }
                    break;
                case 5:
                    {
                        studentGroup.addCourseYearOfGroup();
                    }
                    break;
                case -1:
                    studentGroupInfo(studentGroup);
                    System.exit(0);
                default:
                    System.out.println("Invalid action");
                    break;
            }
            studentGroupInfo(studentGroup);
        }
    }

    private static void studentGroupInfo(StudentGroup studentGroup) {
        System.out.println("Students: " + studentGroup.getStudents());
        System.out.println("Student's with above average score: " + studentGroup.getStudentsAboveAverage());
        System.out.println("Student's with below average score: " + studentGroup.getStudentsBelowAverage());
        System.out.println("Student's average score: " + studentGroup.calculateAverage());
        System.out.println("Unique students: " + studentGroup.getUniqueNameStudents());
        studentGroup.studentsInfo();
    }

    private static Student createStudent() throws IOException {
        String name = DataInput.validateString("Input name: ", 3);
        int age = DataInput.validateNumber("Input age: ", 18, 60);
        int courseYear = DataInput.validateNumber("Input course year: ", 1, 4);
        return new Student(name, age, new ArrayList<Double>() , courseYear);
    }
}