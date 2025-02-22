package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public static int MAX_VAL = 10000;
    public static int MIN_VAL = -10000;

    public  static void setRandDoubleMatrix(double[][] a) {
        for (int i = 0; i < a.length;i++){
            for(int j=0;j<a[i].length;j++){
                a[i][j]= ThreadLocalRandom.current().nextDouble((double) MIN_VAL,(double) MAX_VAL);
            }
        }
    }

    public  static void setRandIntArray(int[] a) {
        for (int i = 0; i < a.length;i++){
            a[i]=  ThreadLocalRandom.current().nextInt(MIN_VAL, MAX_VAL);;
        }
    }

    public static void printDoubleMatrix(double[][] a) {
        for (int i = 0; i < a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printDoubleArray(double[] a) {
        for (int i = 0; i < a.length;i++)
            System.out.print(a[i] + " ");
    }


    public static void printIntMatrix(int[][] a) {
        for (int i = 0; i < a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int sumOfIntArray(int[] a){
        int sum = 0;

        for (int i = 0; i < a.length; i++)
            sum += a[i];
        return sum;
    }

    public static double averageOfIntArray(int[] a){
        if (a == null || a.length == 0)
            return Double.NaN;
        try {
            return (double) sumOfIntArray(a) / a.length;
        } catch (ArithmeticException e){
            System.out.println("Can not get average value of empty array");
            return Double.NaN;
        }

    }

    public static int minOfIntArray(int[] a){
        if (a == null || a.length  == 0 )
            return -1;
        int min = a[0];

        for (int i = 0; i < a.length; i++)
            min = (min < a[i]) ? min : a[i];

        return min;

    }

    public static double minOfDoubleArray(double[] a){
        if (a == null || a.length  == 0 )
            return -1;
        double min = a[0];

        for (int i = 0; i < a.length; i++)
            min = (min < a[i]) ? min : a[i];

        return min;

    }

    public static int maxOfIntArray(int[] a){
        if (a == null || a.length  == 0 )
            return -1;
        int max = a[0];

        for (int i = 0; i < a.length; i++)
            max = (max > a[i]) ? max : a[i];

        return max;
    }


    public static double maxOfDoubleArray(double[] a){
        if (a == null || a.length  == 0 )
            return -1;
        double max = a[0];

        for (int i = 0; i < a.length; i++)
            max = (max > a[i]) ? max : a[i];

        return max;
    }

    public static void swapIntElements(int [] a, int firstIdx, int secondIdx){
        int temp = a[firstIdx];
        a[firstIdx] = a[secondIdx];
        a[secondIdx] = temp;

    }


    public static void sortIntArrayDESC(int[] a){
        if (a == null || a.length == 0)
            return;

        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    swapIntElements(a, i, j);
                }
            }
        }
    }


    public static void sortIntArrayASC(int[] a){
        if (a == null || a.length == 0)
            return;

        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    swapIntElements(a, i, j);
                }
            }
        }
    }


    public static boolean isSorted(int[] a){
        if (a == null || a.length == 0)
            return false;

        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] > a[i + 1])
                return false;
        }

        return true;
    }

    public static Student[] reverseArrayOfStudents(Student [] a) {
        Student [] reverseStudents = new Student[a.length];
        for (int i = 0; i < a.length; i++)
            reverseStudents[i] = a[a.length - i - 1];
        return reverseStudents;
    }

    public static Student[] quickSortByGrade(Student [] a, int beginIndex, int endIndex ){
        if (beginIndex < endIndex) {
            int dividingIndex = getDividingIndexGrade(a, beginIndex, endIndex);
            quickSortByGrade(a, beginIndex, dividingIndex - 1);
            quickSortByGrade(a, dividingIndex + 1, endIndex);
        }
        return a;
    }

    public static int getDividingIndexGrade(Student[] a, int beginIndex, int endIndex) {
        double key = a[endIndex].grade;
        int i = beginIndex - 1;
        for (int j = beginIndex; j < endIndex; j++) {
            if (a[j].grade <= key) {
                i++;
                swapStudents(a, i, j);
            }
        }
        swapStudents(a, i + 1, endIndex);
        return i + 1;
    }

    public static double[] quickSortForDouble(double [] a, int beginIndex, int endIndex ){
        if (beginIndex < endIndex) {
            int dividingIndex = getDividingIndexDouble(a, beginIndex, endIndex);
            quickSortForDouble(a, beginIndex, dividingIndex - 1);
            quickSortForDouble(a, dividingIndex + 1, endIndex);
        }
        return a;
    }


    public static int getDividingIndexDouble(double [] a, int beginIndex, int endIndex) {
        double key = a[endIndex];
        int i = beginIndex - 1;
        for (int j = beginIndex; j < endIndex; j++) {
            if (a[j] <= key) {
                i++;
                swapDoubles(a, i, j);
            }
        }
        swapDoubles(a, i + 1, endIndex);
        return i + 1;
    }

    public static void swapStudents(Student [] a , int i , int j) {
        Student temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void swapIntegers(int [] a , int i , int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void swapDoubles(double [] a , int i , int j) {
        double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    //    returns 0 if strings are equal, return -1 if str2 is bigger lexicographically than str1,
//    return 1 if str1 is bigger lexicographically than str2
    public static int compareTwoStrings (String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();



        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            char charFromStr1 = str1.charAt(i);
            char charFromStr2 = str2.charAt(i);

            if (charFromStr1 < charFromStr2)
                return -1;
            if (charFromStr1 > charFromStr2)
                return 1;
        }

        if (str1.length() == str2.length())
            return 0;
        if (str1.length() < str2.length())
            return -1;
        return 1;
    }

    public static Student[] quickSortByName(Student [] a, int beginIndex, int endIndex ){
        if (beginIndex < endIndex) {
            int dividingIndex = getDividingIndexString(a, beginIndex, endIndex);
            quickSortByName(a, beginIndex, dividingIndex - 1);
            quickSortByName(a, dividingIndex + 1, endIndex);
        }
        return a;
    }

    private static int getDividingIndexString(Student[] a, int beginIndex, int endIndex) {
        String key = a[endIndex].name;
        int i = beginIndex - 1;
        for (int j = beginIndex; j < endIndex; j++) {
            if (compareTwoStrings(a[j].name, key) < 0) {
                i++;
                swapStudents(a, i, j);
            }
        }
        swapStudents(a, i + 1, endIndex);
        return i + 1;
    }

    public static void swapStrings(String [] a , int i , int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
