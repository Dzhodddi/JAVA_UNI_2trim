package org.example;


import java.io.IOException;

class MyString {
    private final String str;
    private final int diff = 3000000;
    public MyString(String str) {
        this.str = str;
    }

    private String encodeString() {
        String encoded = "";
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            c = c + diff;
            encoded += (char) c;
        }
        return encoded;
    }

    public String returnEncodeString() {
        return encodeString();
    }

    private String decodeString() {
        String decoded = "";
        String encodeString = encodeString();
        for (int i = 0; i < encodeString.length(); i++) {
            int c = encodeString.charAt(i);
            c = c - diff;
            decoded += (char) c;
        }
        return decoded;
    }

    public String returnDecodeString() {
        return decodeString();
    }

    public String getString() {
        return str;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        while (true) {
            int next = DataInput.getInt("Enter -1 to stop: ");
            if (next == -1) {
                System.out.println("~~~THE END!!~~~");
                break;
            }

            String str = DataInput.getString("Input string: ");
            MyString myString = new MyString(str);
            String encoded = myString.returnEncodeString();
            String decoded = myString.returnDecodeString();
            while (true) {
                int action = DataInput.getInt("Enter 1 - to return encoded string, 2 - to return  decoded string, -1 - to stop,  else return input string: ");
                if (action == -1) {
                    break;
                }
                switch (action) {
                    case 1:
                        System.out.println("Encoded string: " + encoded);
                        break;
                    case 2:
                        System.out.println("Decoded string: " + decoded);
                        break;
                    default:
                        System.out.println("Input str: " + myString.getString());
                        break;
                }
            }

        }


    }
}