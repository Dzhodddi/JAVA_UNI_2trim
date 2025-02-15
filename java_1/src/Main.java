import java.lang.reflect.Array;

public class Main{

public static void main (String[] args){
    boolean end = true;
    while(end){
        int task = DataInput.getInt("What task do you want to test? ");
        switch(task){
            case 1:
                System.out.println(task1());
                break;
            case 2:
                System.out.println(task2());
                break;
            case 3:
                task3();
                break;
            case 4:
                int lower = DataInput.getInt("What is the lower number? ");
                int upper = DataInput.getInt("What is the upper number? ");
                task4(lower, upper);
                break;
            case 5:
                task5();
                break;
            default:
                System.out.println("Invalid task");
                end = false;
                break;
        }
    }

}


    private static double maxOfDoubleMatrix(double[][] a) {
        if (a == null || a.length == 0)
            return Double.NaN;
        double max = a[0][0];
        for (int i = 0; i < a.length;i++){
            for(int j=0;j<a[i].length;j++){
                max = (max > a[i][j]) ? max : a[i][j];
            }
        }
        return max;
    }

    private static double minOfDoubleMatrix(double[][] a) {
        if (a == null || a.length == 0)
            return Double.NaN;

        double min = a[0][0];
        for (int i = 0; i < a.length;i++){
            for(int j=0;j<a[i].length;j++){
                min = (min > a[i][j]) ? a[i][j] : min;
            }
        }
        return min;
    }

    private static void sortByDoubleMatrix(double [][] a, int lower, int upper) {
        if (a == null)
            return;
        for (int i = 0; i < a.length;i++){
            for(int j=0;j<a[i].length;j++){
                if (a[i][j] >  lower && a[i][j] <  upper){
                    System.out.print(a[i][j] + " ");
                }
            }
        }

    }

    private static double sumOfDoubleArray(double[] a){
        if (a == null || a.length == 0)
            return Double.NaN;
        double sum = 0.0;
        for (int i = 0; i < a.length; i++)
            sum += a[i];
        return sum;
    }


    private  static double getRandomDouble(){
        double min = -1000.0;
        double max = 1000.0;
        double range = max - min;
        return Math.random() * range + min;
    }


    private static int[] getSpecialSumOfEachColumn(int [][] a){
        if (a == null || a.length == 0)
            return null;
//            throw new NullPointerException("Array is null");
        int columnSums[] = new int [a[0].length];
//        printDoubleMatrix(a);
        for (int i = 0; i < a[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[j][i] < 0 && Math.abs(a[j][i]) % 2 == 1)
                    sum += Math.abs(a[j][i]);
            }
            columnSums[i] = sum;
        }
        return columnSums;
    }

    private static void swapIntElements(int [] a, int firstIdx, int secondIdx){
        int temp = a[firstIdx];
        a[firstIdx] = a[secondIdx];
        a[secondIdx] = temp;

    }

    private static int[] sortIntArray(int[] a){
        if (a == null || a.length == 0)
            return null;
        int indexes[] = new int[a.length];
        for (int i = 0; i < indexes.length; i++)
            indexes[i] = i;

        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    swapIntElements(a, i, j);
                    swapIntElements(indexes, i, j);
                }
            }
        }
        return indexes;
    }


    private static void changeColumns(int[][] a, int [] columns){
        if (a == null || columns == null)
            return;

        int [][] aDuplicate = new int[a.length][a[0].length];
        for (int i = 0; i < a[0].length; i++) {
            int newColIndex = columns[i];
            for (int j = 0; j < a.length; j++) {
                aDuplicate[j][i] = a[j][newColIndex];
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = aDuplicate[i][j];
            }
        }

    }

    private static void sumOfColumns(int[][] a) {
        if (a == null)
            return;

        for (int i = 0; i < a[0].length; i++) {
            boolean negativePresent = false;
            int sum = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[j][i] < 0)
                    negativePresent = true;
                sum += a[j][i];
            }
            if (!negativePresent)
                System.out.println("Column" + (i + 1) + " has all positive numbers");
            else
                System.out.println("Column" + (i + 1) + " has sum: " + sum);
        }
    }

    public  static double task1() {
        int length = DataInput.getNotNegativeInt("Input length: ");
        double[] a = new double[length];
        DataInput.readDoubleArray(a);
        return sumOfDoubleArray(a);
    }


    public  static double task2() {
        int length = DataInput.getNotNegativeInt("Input length: ");
        int[] a = new int[length];
        DataInput.setRandIntArray(a);
        DataInput.printIntArray(a);
        System.out.println();
        return DataInput.averageOfIntArray(a) ;
    }

    public static void task3() {
        int rows = DataInput.getNotNegativeInt("Input amount of rows: ");
        int columns = DataInput.getNotNegativeInt("Input amount of columns: ");

        double[][] a = new double[rows][columns];
        DataInput.setRandDoubleMatrix(a);
        DataInput.printDoubleMatrix(a);
        System.out.println("Max value of matrix: " + maxOfDoubleMatrix(a) + "\n" +
                "Min value of matrix: " + minOfDoubleMatrix(a));

    }

    public static void task4(int lower, int upper) {
        int rows = DataInput.getNotNegativeInt("Input amount of rows: ");
        int columns = DataInput.getNotNegativeInt("Input amount of columns: ");

        double[][] a = new double[rows][columns];

        int method = DataInput.getInt("Input 1 to define matrix by random or 0 by hand: ");

        if (method == 0) {
            DataInput.readDoubleMatrix(a);
        } else {
            DataInput.setRandDoubleMatrix(a);
        }
        System.out.println("Matrix: ");
        DataInput.printDoubleMatrix(a);
        System.out.print("Numbers: ");
        sortByDoubleMatrix(a, lower, upper);
        System.out.println();
    }


    public static void task5() {
        int rows = DataInput.getNotNegativeInt("Input amount of rows: ");
        int columns = DataInput.getNotNegativeInt("Input amount of columns: ");
        int[][] a = new int[rows][columns];
        DataInput.readIntMatrix(a);
        int [] columnSums;

        columnSums = getSpecialSumOfEachColumn(a);
        System.out.println("Matrix: ");
        DataInput.printIntMatrix(a);
        System.out.print("Needed sum of each column: ");
        DataInput.printIntArray(columnSums);
        System.out.println();
        System.out.println("Sorted matrix");
        changeColumns(a, sortIntArray(columnSums));
        DataInput.printIntMatrix(a);
        System.out.println("Sum of columns:");
        sumOfColumns(a);
        System.out.println();
    }



}