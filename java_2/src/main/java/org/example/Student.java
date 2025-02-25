package org.example;

public class Student {

    private int[] grades;

    private int overWriteGrade(int grade) {
        if (grade < 0)
            return 0;
        if (grade > 100)
            return 100;
        return grade;
    }

    public void setGrades(int[] grades) {
        for (int i = 0; i < grades.length; i++) {
            grades[i] = overWriteGrade(grades[i]);
        }
        this.grades = grades;
    }

    public int[] getGrades() {
        return this.grades;
    }

    public void addGrades(int [] grades) {
        if (this.grades == null || this.grades.length == 0) {
            setGrades(grades);
            return;
        }
        int len = grades.length + this.grades.length;
        int [] newGrades = new int[len];
        for (int i = 0; i < this.grades.length; i++) {
            newGrades[i] = this.grades[i];
        }
        for (int i = this.grades.length; i < len; i++) {
            grades[i - this.grades.length] = overWriteGrade(grades[i - this.grades.length]);
            newGrades[i] = grades[i - this.grades.length];
        }
        setGrades(newGrades);
    }


    public void toStringGrades() {
        if (this.grades == null)
            return;
        System.out.print("Grades: ");
        for (int i = 0; i < this.grades.length; i++) {
            System.out.print(this.grades[i] + " ");
        }
    }

    public double getAverageGrades() {
        return Utils.averageOfIntArray(this.grades);
    }

    public int maxGrade() {
        return Utils.maxOfIntArray(this.grades);
    }

    public int minGrade() {
        return Utils.minOfIntArray(this.grades);
    }

    public int amountOfStudentsAboveAvgGrade() {
        if (this.grades == null || this.grades.length == 0)
            return -1;
        int count = 0;
        for (int i = 0; i < this.grades.length; i++) {
            if (this.grades[i] > getAverageGrades())
                count++;
        }
        return count;
    }


    public int amountOfStudentsBelowAvgGrade() {
        if (this.grades == null || this.grades.length == 0)
            return -1;
        int counter = 0;
        for (int i = 0; i < this.grades.length; i++) {
            if (this.grades[i] < getAverageGrades())
                counter++;
        }
        return counter;
    }

    public int amountOfExcellentGrades() {
        if (this.grades == null || this.grades.length == 0)
            return -1;
        int counter = 0;
        for (int i = 0; i < this.grades.length; i++) {
            if (this.grades[i] >= 91)
                counter++;
        }
        return counter;
    }

    public int amountOfGoodGrades() {
        if (this.grades == null || this.grades.length == 0)
            return -1;
        int counter = 0;
        for (int i = 0; i < this.grades.length; i++) {
            if (this.grades[i] >= 71 && this.grades[i] <= 90)
                counter++;
        }
        return counter;
    }

    public int amountOfDecentGrades() {
        if (this.grades == null || this.grades.length == 0)
            return -1;
        int counter = 0;
        for (int i = 0; i < this.grades.length; i++) {
            if (this.grades[i] >= 60 && this.grades[i] <= 70)
                counter++;
        }
        return counter;
    }


    public int amountOfNezarahGrades() {
        if (this.grades == null || this.grades.length == 0)
            return -1;
        int counter = 0;
        for (int i = 0; i < this.grades.length; i++) {
            if (this.grades[i] <= 59)
                counter++;
        }
        return counter;
    }

    public int[] printGradesDESC() {
        Utils.sortIntArrayDESC(this.grades);
        System.out.print("Sorted grades in DESC: ");
        DataInput.printIntArray(this.grades);
        return this.grades;
    }


    public int[] printGradesASC() {
        Utils.sortIntArrayASC(this.grades);
        System.out.print("Sorted grades in ASC: ");
        DataInput.printIntArray(this.grades);
        return this.grades;
    }

    public boolean isSortedGrades(){
        return Utils.isSorted(this.grades);
    }

    public static void main(String [] args) {
        int students = DataInput.getNotNegativeInt("Amount of students: ");
        int [] array = new int [students];
        for (int i = 0; i < students; i++) {
            array[i] = DataInput.getNotNegativeInt("Grade: ");
        }
        Student student = new Student();
        student.setGrades(array);
        System.out.println("Desc grades:" + student.printGradesDESC());
        System.out.println("ASc grades:" + student.printGradesASC());
    }
}
