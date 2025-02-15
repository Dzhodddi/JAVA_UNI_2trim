import java.io.IOException;

public class TestGrades {

    public static void main(String[] args) throws IOException {
        StudentsGrades studentsGrades = new StudentsGrades();
        docs();
        while (true) {
            String act = DataInput.getString();
            if (act == null)
                continue;
            if (act.equals("-h") || act.equals("--help")) {
                docs();
            }

            if (act.equals("Info") || act.equals("info")) {
                testAllMethods(studentsGrades);
            }

            if (act.equals("exit") || act.equals("Exit")) {
                break;
            }


            if (act.equals("set") || act.equals("Set")) {
                int amountOfGrades = DataInput.getNotNegativeInt("AmountOfGrades: ");
                int [] grades = new int[amountOfGrades];
                DataInput.readIntArray(grades);
                studentsGrades.setGrades(grades);
            }

            if (act.equals("add") || act.equals("Add")) {
                int amountOfGrades = DataInput.getNotNegativeInt("AmountOfGrades: ");
                int [] grades = new int[amountOfGrades];
                DataInput.readIntArray(grades);
                studentsGrades.addGrades(grades);
            }

        }
    }

    private static void testAllMethods(StudentsGrades studentsGrades) {
        System.out.println("Min Grade: " + studentsGrades.minGrade());
        System.out.println("Max Grade: " + studentsGrades.maxGrade());
        System.out.println("AVG Grade: " + studentsGrades.getAverageGrades());
        System.out.println("Amount of nezarah: " + studentsGrades.amountOfNezarahGrades());
        System.out.println("Amount of decent grades: " + studentsGrades.amountOfDecentGrades());
        System.out.println("Amount of good grades: " + studentsGrades.amountOfGoodGrades());
        System.out.println("Amount of excellent grades: " + studentsGrades.amountOfExcellentGrades());
        System.out.println("Amount of student with grade below avg: " + studentsGrades.amountOfStudentsBelowAvgGrade());
        System.out.println("Amount of student with grade above avg: " +studentsGrades.amountOfStudentsAboveAvgGrade());
        System.out.print("Grades: ");
        studentsGrades.toStringGrades();
        System.out.println("\n");
    }

    private static void docs() {
        System.out.println("Write \"add \" or \"Add \" to add grades and then input amount of added grades \n" +
                "Write \"set \" or \"Set \" to set grades and then input amount of added grades \n" +
                "Write \"info \" or \"Info \" to see all result of methods and grades \n" +
                "Write \"-h \" or \"--help \" for documentation \n" +
                "\"Write \"exit \" or \"Exit\" for end testing \n"
        );
    }
}
