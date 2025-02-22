import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String[] students = inputStudents();
        System.out.print("Students' name: ");
        outputStudents(students);
        try {
            char firstLetter = DataInput.getChar("Input first letter of the student name: ");
            outputSpecificStudents(students, firstLetter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static String [] inputStudents(){
        int len = DataInput.getNotNegativeInt("Amount of students: ");
        String []students = new String[len];
        for (int i = 0; i < len; i++) {
            try {
                students[i] = DataInput.getString("Input student name: ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return students;
    }

    private static void outputStudents(String[] students) {
        if (students == null || students.length == 0) {
            return;
        }
        for (int i = 0; i < students.length; i++) {
            System.out.print(students[i] + " ");
        }
        System.out.println();
    }

    private static void outputSpecificStudents(String[] students, char firstLetter) {
        if (students == null || students.length == 0) {
            return;
        }
        int counter = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].charAt(0) == firstLetter) {
                System.out.print(students[i] + " ");
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("No students found");
        }
    }
}