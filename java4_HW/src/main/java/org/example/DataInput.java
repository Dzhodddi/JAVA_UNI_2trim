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

    public static Integer getInt(String wr){
        writeText(wr);
        String s = "";
        try {
            s = getString("");
        } catch (IOException e) {
            System.out.println("Wrong input");
            return getInt(wr);
        }
        try {
            return Integer.valueOf(s);
        } catch (NumberFormatException e) {
            System.out.println("Wrong input");
            return getInt(wr);
        }

    }

    public static Integer getNotNegativeInt(String wr){
        int value = getInt(wr);
        if (value < 0) {
            System.out.println("Wrong input");
            return getNotNegativeInt(wr);
        }
        return value;
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
            System.out.println("Wrong input");
            return getDouble(wr);
        }
        try {
            return Double.valueOf(s);
        } catch (NumberFormatException e) {
            System.out.println("Wrong input");
            return getDouble(wr);
        }

    }


}
