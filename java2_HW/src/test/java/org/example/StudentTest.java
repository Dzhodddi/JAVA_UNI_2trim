package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Student student;
    private Student student1;
    private Student student2;
    private Student student3;
    @BeforeEach
    void setUp() {
        student = new Student("Dima", 99);
        student1 = new Student("Dima", 99);
        student2 = new Student("Dima", 100);
        student3 = new Student("Alex", 99);
    }

    @Test
    void equalsStudents() {
        assert student.equalsStudents(student1);
        assertFalse(student.equalsStudents(student2));
        assertFalse(student1.equalsStudents(student2));
        assertFalse(student.equalsStudents(student3));
        assertFalse(student1.equalsStudents(student3));
        assertFalse(student2.equalsStudents(student3));
        assert student2.equalsStudents(student2);


    }
}