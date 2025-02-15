import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;

public final class DataInput {
    public static int MAX_VAL = 10000;
    public static int MIN_VAL = -10000;

    private static void writeText(String wr){
        if (wr == null)
            System.out.print("Введіть дані: ");
        else
            System.out.print(wr);
    }

    public static Long getLong() throws IOException {
        String s = getString();
        Long value = Long.valueOf(s);
        return value;
    }


    public static char getChar() throws IOException{
        String s = getString();
        return s.charAt(0);
    }


    public static Integer getInt(String wr){
        writeText(wr);
        String s = "";
        try {
            s = getString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Wrong input");
            return 0;
        }
        try {
            Integer value = Integer.valueOf(s);
            return value;
        } catch (NumberFormatException e) {
            System.out.println("Wrong input");
            return 0;
        }
    }

    public static Integer getNotNegativeInt(String wr){
        writeText(wr);
        String s = "";
        try {
            s = getString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Wrong input");
            return 0;
        }
        try {
            Integer value = Integer.valueOf(s);
            if (value >= 0)
                return value;
            else {
                System.out.println("Wrong input");
                return 0;
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong input");
            return 0;
        }

    }


    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }


    public static Double getDouble(String wr){
        writeText(wr);
        String s = "";
        try {
            s = getString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Wrong input");
            return 0.0;
        }
        try {
            return Double.valueOf(s);
        } catch (NumberFormatException e) {
            System.out.println("Wrong input");
            return 0.0;
        }

    }

    public static Boolean getBool(String wr){
        writeText(wr);
        String s = "";
        try {
            s = getString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Boolean value = Boolean.valueOf(s);
        return value;

    }

    public static void readIntArray(int[] a) {
        for (int i = 0; i<a.length;i++){
            a[i]=DataInput.getInt("Input element: ");
        }
    }


    public static void printIntArray(int[] a) {
        if (a == null)
            return;
        for (int i = 0; i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

    public  static void readDoubleArray(double[] a) {
        for (int i = 0; i < a.length;i++){

            a[i] = DataInput.getDouble("Get element: ");
        }
    }

    public static void readDoubleMatrix(double[][] a) {
        for (int i = 0; i < a.length;i++){
            for(int j=0;j<a[i].length;j++){
                a[i][j]=DataInput.getDouble("Get element: ");
            }
        }
    }

    public static void readIntMatrix(int[][] a) {
        for (int i = 0; i < a.length;i++){
            for(int j=0;j<a[i].length;j++){
                a[i][j]=DataInput.getInt("Get element: ");
            }
        }
    }


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

    public  static double getRandomDouble(){
        double min = -1000.0;
        double max = 1000.0;
        double range = max - min;
        return Math.random() * range + min;
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

    public static int maxOfIntArray(int[] a){
        if (a == null || a.length  == 0 )
            return -1;
        int max = a[0];

        for (int i = 0; i < a.length; i++)
            max = (max > a[i]) ? max : a[i];

        return max;
    }

}
