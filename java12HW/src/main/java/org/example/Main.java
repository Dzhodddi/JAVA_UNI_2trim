package org.example;

import lombok.Getter;

import java.io.*;
import java.util.*;

class CustomException extends Exception {
    CustomException(String message) {
        super("Wrong file input, got error: " + message);
    }
}

class FileInput {

    public ArrayList<File> validateString(String input, int minLength, int amountOfFile) throws CustomException {
        ArrayList<File> files = new ArrayList<>();
        for (String file: input.split(" ")) {
            File f;
            try {
                f = validateFile(file, minLength);
            } catch (FileNotFoundException e) {
                throw new CustomException("File not found");
            }
            files.add(f);
        }
        if (files.size() != amountOfFile) {
            throw new CustomException("Wrong amount of files");
        }
        return files;
    }

    private File validateFile(String file, int fileSize) throws FileNotFoundException, CustomException {
        File f;
        f = new File(file);
        if (!f.exists()) {
            throw new CustomException("File not found");
        }
        if (f.length() < fileSize) {
            throw new CustomException("File too short");
        }
        return f;
    }
}

//class ContentFileMap {
//
//
//    public static HashSet<String> getUniqueWords(File file) throws IOException {
//        return new HashSet <>(tokens(file));
//    }
//
//    private static String contentOfFile(File file) throws IOException {
//        String contentOfFile = "";
//        BufferedReader bf = new BufferedReader(new FileReader(file));
//        while (true) {
//            String line = bf.readLine();
//            if (line == null) break;
//            contentOfFile += line + "\n";
//        }
//        return contentOfFile;
//    }
//
//    static ArrayList<String> tokens(File file) throws IOException {
//        StringTokenizer st = new StringTokenizer();
//        ArrayList<String> tokens;
//        tokens = st.splitString(contentOfFile(file));
//        return tokens;
//    }
//
//    static Integer getAmountOfToken(String token, File file) throws IOException {
//        Integer counter = 0;
//        for (String words: tokens(file)) {
//            if (words.equals(token)) {
//                counter++;
//            }
//        }
//        return counter;
//    }
//
//}
//
//class ContentOfArrayListFiles {
//    private ArrayList<File> files;
//    private ArrayList<String> tokens = new ArrayList<String>();
//    ContentOfArrayListFiles(ArrayList<File> files) throws IOException {
//        this.files = files;
//        this.tokens = setTokens();
//    }
//
//    private ArrayList<String> setTokens() throws IOException {
//        for (File file: files) {
//            ArrayList<String> tokensFromFile = ContentFileMap.tokens(file);
//            tokens.addAll(tokensFromFile);
//        }
//        return tokens;
//    }
//
//    private HashSet<String> getUniqueTokens() throws IOException {
//        HashSet<String> set = new HashSet<>();
//        for (File file: files) {
//            ArrayList<String> tokensFromFile = ContentFileMap.tokens(file);
//            set.addAll(tokensFromFile);
//        }
//        return set;
//    }
//
//    private HashMap<String, Integer> countAllWords() throws IOException {
//        HashMap<String, Integer> map = new HashMap<>();
//        for (String token: getUniqueTokens()) {
//            map.put(token,getAmountOfToken(token));
//        }
//        return map;
//    }
//
//    private Integer getAmountOfToken(String token) throws IOException {
//        Integer counter = 0;
//        for (String words: tokens) {
//            if (words.equals(token)) {
//                counter++;
//            }
//        }
//        return counter;
//    }
//
//    public void customMapToString() throws IOException {
//        HashMap<String, Integer> map = countAllWords();
//        for (String word: map.keySet()) {
//            System.out.println(word + ":" + map.get(word) + " (" + amountOfTokensInAllFiles(word) + ")");
//        }
//    }
//
//    private String amountOfTokensInAllFiles(String token) throws IOException {
//        String result = "";
//        for (File file: files) {
//            if (ContentFileMap.getAmountOfToken(token, file) > 0)
//                result += file.getName() + " - " + ContentFileMap.getAmountOfToken(token, file) + ",";
//        }
//        return result;
//    }
//
//}

class StringTokenizer {
    private char [] tokens = new char[]{'\n', '!', '.', ',', ' ', '\t', '\r', ':', '"', ';', '!', '?'} ;

    StringTokenizer() {

    }

    StringTokenizer(char [] givenTokens) {
        tokens = givenTokens;
    }

    private boolean nextToken(char ch) {
        for (char token : tokens) {
            if (token == ch) return true;
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

    public ArrayList<String> splitString(String input) {
        ArrayList<String> tokens = new ArrayList<>();
        for (String token: tokenizeWithSpaces(input).split(" "))
            tokens.add(token);
        return tokens;
    }

}
@Getter
class WordMapProcessor {
    private final Map<File, Map<String, Integer>> wordCountsPerFile = new HashMap<>();
    private final Set<String> allUniqueWords = new HashSet<>();
    private int amountOfWords = 0;
    WordMapProcessor(List<File> files) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer();
        for (File file : files) {
            Map<String, Integer> wordCount = new HashMap<>();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                for (String token : tokenizer.splitString(line)) {
                    wordCount.merge(token, 1, Integer::sum);
                    allUniqueWords.add(token);
                    amountOfWords ++;
                }
            }
            reader.close();
            wordCountsPerFile.put(file, wordCount);
        }
    }

    public String customMapToString() {
        String result = "";
        for (String word : allUniqueWords) {
            int total = 0;
            String stat = "";

            for (File file : wordCountsPerFile.keySet()) {
                int count = wordCountsPerFile.get(file).getOrDefault(word, 0);
                if (count > 0) {
                    total += count;
                    stat += file.getName() + " - "  + count + ", ";
                }
            }

            result += (word + ": " + total + " (" + stat + ")") + "\n";
        }
        return result;
    }

    public int amountOfUniqueWords() {
        return allUniqueWords.size();
    }

    public int amountOfWords() {
        return amountOfWords;
    }
}

public class Main {
    public static void main(String[] args) throws IOException, CustomException {
        while (true) {
            System.out.print("Input file: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            FileInput fileInput = new FileInput();
            ArrayList<File> files = new ArrayList<>();
            try {
                files = fileInput.validateString(line, 150 * 1000, 10);
            } catch (CustomException e) {
                System.out.println(e.getMessage());
                Scanner scanner = new Scanner(System.in);
                System.out.print("Please enter 1 to continue or -1 to exit: ");
                String input = scanner.nextLine();
                try {
                    int action = Integer.parseInt(input);
                    if (action == 1) {
                        continue;
                    }
                    if (action == -1) {
                        System.out.println("~~END~~");
                        break;
                    }
                } catch (NumberFormatException e1) {
                    throw new CustomException("Wrong input");
                }
            }
            WordMapProcessor processor = new WordMapProcessor(files);
            System.out.println(processor.customMapToString());
            rewriteFileContent(processor.customMapToString() +
                            "Amount of unique words: " + processor.amountOfUniqueWords() +
                            "\nAmount of words: " + processor.amountOfWords(),
                    new File("dict.txt"));
        }

    }
    private static void rewriteFileContent(String fileContent, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file, false);
        fileOutputStream.write(fileContent.getBytes());
        fileOutputStream.write("\n".getBytes());
        fileOutputStream.close();
        fileOutputStream = new FileOutputStream(file, true);
        fileOutputStream.write(("Size: " + file.length() / 1000 + " KB").getBytes());
        fileOutputStream.close();
    }
}