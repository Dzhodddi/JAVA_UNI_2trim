package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class DataInput {

    private static void writeText(String wr){
        if (wr == null)
            System.out.print("Введіть дані: ");
        else
            System.out.print(wr);
    }

    public static Long getLong() throws IOException {
        String s = getString("");
        Long value = Long.valueOf(s);
        return value;
    }


    public static char getChar(String wr) throws IOException{
        writeText(wr);
        String s = getString("");
        return s.charAt(0);
    }


    public static Integer getInt(String wr){
        writeText(wr);
        String s = "";
        try {
            s = getString("");
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
            s = getString("");
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


    public static String getString(String wr) throws IOException{
        writeText(wr);
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }


    public static Double getDouble(String wr){
        writeText(wr);
        String s = "";
        try {
            s = getString("");
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
            s = getString("");
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










}
