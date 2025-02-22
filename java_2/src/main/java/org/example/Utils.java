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
}
