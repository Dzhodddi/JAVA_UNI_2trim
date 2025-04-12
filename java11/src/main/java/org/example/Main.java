package org.example;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        JFileChooser fileOpen = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter(null, ".txt");
        fileOpen.addChoosableFileFilter(filter);

        int ret = fileOpen.showDialog(null, "Open file");

        if (ret == JFileChooser.APPROVE_OPTION) {
            JFrame frame = getJFrame(fileOpen);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    }

    private static JFrame getJFrame(JFileChooser filOpen) throws FileNotFoundException {
        File file = filOpen.getSelectedFile();
        Scanner scanner = new Scanner(file);
        String text = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            text += line + "\n";
        }
        JTextArea textArea = new JTextArea(text);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setCaretPosition(0);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.add(scrollPane);
        return frame;
    }
}