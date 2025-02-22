package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StudentsListTest {

    private static StudentsList studentsList;
    private static StudentsList studentsList1;
//    private Student student, student1, student2, student3, student4, student5, student6, student7;

    public static void main(String[] args) {
        StudentsList studentsList = new StudentsList();
        studentsList.setStudentsList();
        studentsListInfoTest(studentsList);
        System.out.println();
    }

    private static void  studentsListInfoTest(StudentsList studentsList) {
//      printing toStringStudents for all students
        studentsList.studentsInfo(studentsList.getStudentsList());
        System.out.println();
//      printing grades of all students
        double [] grades = studentsList.studentsGrades();
        System.out.print("All Students Grades: ");
        Utils.printDoubleArray(grades);
        System.out.println();
        System.out.println();

//      printing toStringStudents for all students sorted by names in ascending order
        Student [] studentsSortedByGradeASC = studentsList.sortStudentsByGrade(true);
        System.out.println("Students sorted by grade in ascending order: ");
        studentsList.studentsInfo(studentsSortedByGradeASC);
        System.out.println();
//      printing toStringStudents for all students sorted by names in ascending order
        Student [] studentsSortedByGradeDESC = studentsList.sortStudentsByGrade(false);
        System.out.println("Students sorted by grade in descending order: ");
        studentsList.studentsInfo(studentsSortedByGradeDESC);
        System.out.println();
//      printing toStringStudents for all students sorted by names in ascending order
        Student [] studentsSortedByNameASC = studentsList.sortStudentsByName(true);
        System.out.println("Students sorted by name in ascending order: ");
        studentsList.studentsInfo(studentsSortedByNameASC);
        System.out.println();
//      printing toStringStudents for all students sorted by names in ascending order
        Student [] studentsSortedByNameDESC = studentsList.sortStudentsByName(false);
        System.out.println("Students sorted by name in descending order: ");
        studentsList.studentsInfo(studentsSortedByNameDESC);
        System.out.println();
    }

//
//    @BeforeEach
//    public void setUp() {
//        student = new Student("Dima", 99);
//        student1 = new Student("Dima", 99);
//        student2 = new Student("Dima", 100);
//        student3 = new Student("Alex", 99);
//        student4 = new Student("Dima", 99);
//        student5 = new Student("Dima", 99);
//        student6 = new Student("Dima", 100);
//        student7 = new Student("Alex", 99);
//        Student [] list = new Student[] {student2, student3, student2, student6, student7};
//        Student [] list1 = new Student[] {student5, student1, student2, student3, student4, student7};
//        studentsList = new StudentsList(list);
//        studentsList1 = new StudentsList(list1);
//
//    }

//    @Test
//    public void testStudentsList() {
//        Student [] studentsSortedByName = studentsList.sortStudentsByName(true);
//        Student [] studentsSortedByName1 = studentsList1.sortStudentsByName(true);
//    }
}
