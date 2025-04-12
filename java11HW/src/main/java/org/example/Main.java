package org.example;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class Main {
    public static JTextArea textArea;
    public static void main(String[] args) {
        JFrame frame = new JFrame("File Manager");
        textArea = new JTextArea();
        textArea.setBorder(new TitledBorder("Text Area"));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JPanel treeFilePanel = FileManagerTree.fileTreePanel();
        treeFilePanel.setBorder(new TitledBorder("Tree File"));
        treeFilePanel.setLayout(new BoxLayout(treeFilePanel, BoxLayout.Y_AXIS));

        frame.setVisible(true);
        frame.add(treeFilePanel);
        frame.add(scrollPane);
        frame.setSize(800, 600);
        frame.setLayout(new GridLayout(1, 2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

     public static void setTextArea(String text) {
        textArea.setText(text);
     }

}

class FileManagerTree extends JPanel{
    FileManagerTree(File directory) {
        JTree tree = new JTree(addNodes(null, directory));

        tree.addTreeSelectionListener(e -> {
            TreePath nodes = e.getPath();
            String path = "";
            if (nodes.getLastPathComponent().toString().contains("home/")) {
                Main.setTextArea("");
            }
            else {
                path = nodes.getParentPath().getLastPathComponent() + "/" + nodes.getLastPathComponent().toString();
            }

            try {
                File file = new File(path);
                String content = getFileContent(file);
                Main.setTextArea(content);
            } catch (FileNotFoundException err) {

            }
        });

        JScrollPane scrollPane = new JScrollPane(tree);
        add(scrollPane);
    }

    private static String getFileContent(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);
        String text = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            text += line + "\n";
        }
        return text;
    }

    public static JPanel fileTreePanel() {
        return new FileManagerTree(new File("/home"));
    }

    DefaultMutableTreeNode addNodes(DefaultMutableTreeNode parent, File directory) {
        String path = directory.getPath();
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(path);
        if (parent != null) {
            parent.add(newNode);
        }
        String[] allFiles = directory.list();
        String[] directories = new String[allFiles.length];
        String[] files = new String[allFiles.length];
        for (int i = 0; i < allFiles.length; i++)
            directories[i] = allFiles[i];

        for (int i = 0; i < allFiles.length; i++) {
            String newPath;
            if (path.equals("."))
                newPath = directories[i];
            else
                newPath = path + File.separator + directories[i];
            File f = new File(newPath);
            if (f.isDirectory())
                addNodes(newNode, f);
            else
                files[i] = directories[i];
        }

        for (String file : files) {
            if (file != null) {
                newNode.add(new DefaultMutableTreeNode(file));
            }
        }
        return newNode;
    }
}
