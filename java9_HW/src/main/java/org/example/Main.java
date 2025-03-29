package org.example;

import lombok.Getter;

import java.io.*;
import java.util.Arrays;

class FromFileToStr {
    String contentOfFile(String fileFrom) throws IOException {
        String contentOfFile = "";
        BufferedReader bf = new BufferedReader(new FileReader(fileFrom));
        while (true) {
            String line = bf.readLine();
            if (line == null) break;
            contentOfFile += line + "\n";
        }
        return contentOfFile;
    }
}

class StringTokenizer {
    private char [] tokens = new char[]{'\n', '!', '.', ',', ' ', '\t', '\r'} ;

    StringTokenizer() {

    }

    StringTokenizer(char [] givenTokens) {
        this.tokens = givenTokens;
    }

    private boolean nextToken(char ch) {
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ch) return true;
        }
        return false;
    }

    public String tokenizeWithSpaces(String input) {
        String tokenized = "";
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            if (nextToken(input.charAt(i))) {
                if (counter == 0)
                    tokenized += " ";
                counter ++;
            }
            if (!nextToken(input.charAt(i))) {
                counter = 0;
                tokenized += input.charAt(i);
            }
        }
        return tokenized;
    }

    public String [] splitString(String input) {
        return tokenizeWithSpaces(input).split(" ");
    }

}

@Getter
class MyStringArray {
    private String[] tokens;
    MyStringArray(String [] tokens) {
        this.tokens = tokens;
    }

    public int amountOfTokens() {
        return tokens.length;
    }

    private String [] sortedStringArray() {
        String [] copyTokens = tokens.clone();
        Arrays.sort(copyTokens);
        return copyTokens;
    }

    public int amountOfUniqueTokens() {
        String [] sortedTokens = sortedStringArray();
        int uniqueTokens = 1;
        System.out.println();
        for (int i = 1; i < sortedTokens.length; i++) {
            if (!sortedTokens[i].equals(sortedTokens[i-1])) {
                uniqueTokens++;
            }
        }
        return uniqueTokens;
    }

    public String [] uniqueTokens() {
        String [] sortedTokens = sortedStringArray();
        int amountOfUniqueTokens = amountOfUniqueTokens();
        String [] uniqueTokens = new String[amountOfUniqueTokens];
        int index = 1;
        uniqueTokens[0] = sortedTokens[0];
        for (int i = 1; i < sortedTokens.length; i++) {
            if (!sortedTokens[i].equals(sortedTokens[i-1])) {
                uniqueTokens[index++] = sortedTokens[i];
            }
        }
        return uniqueTokens;
    }

    private int amountOfTokenInArray(String token, String[] tokens) {
        int count = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (token.equals(tokens[i])) {
                count++;
            }
        }
        return count;
    }

    public void amountOfEachToken() {
        for (String uniqueToken : uniqueTokens()) {
            System.out.println(uniqueToken + " " + amountOfTokenInArray(uniqueToken, tokens));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        FromFileToStr c = new FromFileToStr();
        StringTokenizer stringTokenizer = new StringTokenizer();

        try {
            String str = c.contentOfFile("input.txt");
            String tokanizedStr = (stringTokenizer.tokenizeWithSpaces(str));
            MyStringArray stringArray = new MyStringArray(stringTokenizer.splitString(tokanizedStr));
            System.out.print("Amount of strings: " + stringArray.amountOfTokens());
            System.out.println("Amount of unique strings: " + stringArray.amountOfUniqueTokens());
            System.out.print("Unique strings: ");
            for (String token: stringArray.uniqueTokens())
                System.out.print(token + " ");
            System.out.println();
            System.out.print("Amount of each strings: ");
            stringArray.amountOfEachToken();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}