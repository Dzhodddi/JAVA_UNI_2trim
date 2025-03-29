package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Scanner;

interface Human {
    String getName();
    String getSurname();
    String getMiddleName();
    String getFullName();

}

@Getter
@Setter
@ToString
abstract class HumanImpl implements Human {
    private String name, surname, middleName;
    private int age;
    HumanImpl(String name, String surname, String middleName, int age) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.age = age;
    }

    public String getFullName() {
        return name + " " + surname + " " + middleName;
    }

}
@Getter
@Setter
@ToString(callSuper = true)
class Student extends HumanImpl {
    private double averageGrade;
    private String address;
    Student(String name, String surname, String middleName, double averageGrade, String address) {
        super(name, surname, middleName, 18);
        this.averageGrade = averageGrade;
        this.address = address;
    }
}

@Getter
@Setter
class GroupOfStudent {
    private String groupName;
    private Student[] students;
    GroupOfStudent(String groupName, Student[] students) {
        this.groupName = groupName;
        this.students = students;
    }

    private double findMinGrade() {
        double minGrade = Double.MAX_VALUE;
        for (Student student : students) {
            if (student.getAverageGrade() < minGrade) {
                minGrade = student.getAverageGrade();
            }
        }
        return minGrade;
    }

    private double findMaxGrade() {
        double maxGrade = Double.MIN_VALUE;
        for (Student student : students) {
            if (student.getAverageGrade() > maxGrade) {
                maxGrade = student.getAverageGrade();
            }
        }
        return maxGrade;
    }

    private int amountOfStudentsWithMinGrade() {
        int amountOfStudentsWithMinGrade = 0;
        for (Student student : students) {
            if (student.getAverageGrade() == this.findMinGrade())
                amountOfStudentsWithMinGrade++;
        }
        return amountOfStudentsWithMinGrade;
    }

    private int amountOfStudentsWithMaxGrade() {
        int amountOfStudentsWithMaxGrade = 0;
        for (Student student : students) {
            if (student.getAverageGrade() == this.findMaxGrade())
                amountOfStudentsWithMaxGrade++;
        }
        return amountOfStudentsWithMaxGrade;
    }

    public Student[] getStudentsWithMinGrade() {
        int amountOfStudentsWithMinGrade = amountOfStudentsWithMinGrade();
        Student [] studentsWithMinGrade = new Student[amountOfStudentsWithMinGrade];
        int counter = 0;
        for (Student student : students) {
            if (student.getAverageGrade() == findMinGrade()) {
                studentsWithMinGrade[counter] = student;
                counter++;
            }
        }
        return studentsWithMinGrade;
    }


    public Student[] getStudentsWithMaxGrade() {
        int amountOfStudentsWithMaxGrade = amountOfStudentsWithMaxGrade();
        Student [] studentsWithMaxGrade = new Student[amountOfStudentsWithMaxGrade];
        int counter = 0;
        for (Student student : students) {
            if (student.getAverageGrade() == this.findMaxGrade()) {
                studentsWithMaxGrade[counter] = student;
                counter++;
            }
        }
        return studentsWithMaxGrade;
    }
}

class ReadInfo {
    Scanner scanner = new Scanner(System.in);
    public Student createStudent() {
        double averageGrade;
        System.out.print("Input student name: ");
        String name = scanner.next();
        System.out.print("Input student surname: ");
        String surname = scanner.next();
        System.out.print("Input student middle name: ");
        String middleName = scanner.next();
        System.out.print("Input student address: ");
        String address = scanner.next();
        System.out.print("Input student averageGrade: ");

        if (scanner.hasNextDouble()) {
            averageGrade = scanner.nextDouble();
        } else {
            averageGrade = 0;
        }
        System.out.println("~~Student created~~");
        return new Student(name, surname, middleName, averageGrade, address);
    }

    public GroupOfStudent createGroupOfStudent() {
        int amountOfStudents;
        System.out.print("Input group name: ");
        String groupName = scanner.next();
        System.out.print("Input amount of students in group: ");

        try {amountOfStudents = scanner.nextInt();
            if (amountOfStudents < 0) {throw new IllegalArgumentException("Amount of students cannot be negative");}}
        catch (Exception e) {
            throw new IllegalArgumentException("Amount of students in group must be an integer");
        }
        Student [] students = new Student[amountOfStudents];
        for (int i = 0; i < amountOfStudents; i++) {
            students[i] = createStudent();
        }
        for (Student student : students) {
            System.out.println(student);
        }
        return new GroupOfStudent(groupName, students);
    }

}

public class Main {
    public static void main(String[] args) {
        ReadInfo ri = new ReadInfo();
        System.out.println("Creating students and groups of students");
        GroupOfStudent group = ri.createGroupOfStudent();
        System.out.println("Students info: ");
        printStudents(group.getStudents());
        System.out.println("Student/s with minimal grade: ");
        printStudents(group.getStudentsWithMinGrade());
        System.out.println("Student/s with maximum grade: ");
        printStudents(group.getStudentsWithMaxGrade());
    }

    private static void printStudents(Student [] student) {
        for (Student value : student) {
            System.out.println(value);
        }
    }
}