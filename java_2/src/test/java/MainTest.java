import org.example.Student;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

public class MainTest {

    @Test
    public void TestStudent() {
        Student students = new Student();
        students.setGrades(new int[] {50, 10, 20, 80, 90});
        assert students.maxGrade() == 90;
        assert students.minGrade() == 10;
        assert Arrays.equals(students.printGradesDESC(), new int[]{90, 80, 50, 20, 10});
        assert Arrays.equals(students.printGradesASC(), new int[]{10, 20, 50, 80, 90});
        students.addGrades(new int[] {99, 40, 9, 59, 100});
        assert students.maxGrade() == 100;
        assert students.minGrade() == 9;
        assert Arrays.equals(students.printGradesDESC(),
                new int[]{100, 99, 90, 80, 59, 40, 50, 20, 10, 9});
        assert Arrays.equals(students.printGradesASC(),
                new int[]{9, 10, 20, 40, 50, 59, 80, 90, 99, 100});
        assert students.isSortedGrades();
    }

}
