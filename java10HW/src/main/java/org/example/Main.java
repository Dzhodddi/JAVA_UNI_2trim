package org.example;

import lombok.Getter;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

@Getter
class Example {
    private String example;
    private int result;
    Example(String example, int result) {
        this.example = example;
        this.result = result;
    }
}

class GenerateExamples {
    public Example generateExample(int maxNumber) {
        int amountOfSigns = ThreadLocalRandom.current().nextInt(2, 4);
        int sum;
        char signs [] = generateChars(amountOfSigns);
        int numbers [] = generateInts(amountOfSigns + 1, maxNumber + 1);

        sum = numbers[0];
        for (int i = 0; i < amountOfSigns; i++) {
            if ('+' == signs[i]) {
                sum += numbers[i + 1];
            } else {
                sum -= numbers[i + 1];
            }
        }
        String example = "";
        for (int i = 0; i < amountOfSigns; i++) {
            example += numbers[i];
            example += signs[i];
        }
        example += numbers[numbers.length - 1];
        if (sum > maxNumber || sum < 0) {
            return generateExample(maxNumber);
        } else {
            return new Example(example, sum);
        }

    }

    private char [] generateChars(int amountOfSigns) {
        char signs [] = new char[amountOfSigns];
        for (int i = 0; i < amountOfSigns; i++) {
            int sign = ThreadLocalRandom.current().nextInt(0, 2);
            switch (sign) {
                case 0:
                    signs[i] = '+';
                    break;
                case 1:
                    signs[i] = '-';
                    break;
            }
        }
        return signs;
    }

    private int [] generateInts(int amountOfNumbers, int maxNumber) {
        int numbers [] = new int[amountOfNumbers];
        for (int i = 0; i < amountOfNumbers; i++) {
            numbers[i] = ThreadLocalRandom.current().nextInt(0, maxNumber);
        }
        return numbers;
    }
}

class MessageDialogWithStringArray {
    public static void showMessage(String message) {
        JFrame parent = new JFrame();
        JOptionPane.showMessageDialog(parent, message, message, JOptionPane.INFORMATION_MESSAGE);
    }
}

class Frame extends JFrame {
    private JPanel maxNumberPanel;
    private JPanel amountOfExamplePanel;
    private JTextArea maxNumberInput, amountOfExampleInput;
    private JButton sendButton;
    private int page = 1;
    private int correctCounter = 0;
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 28));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setVerticalAlignment(SwingConstants.TOP);
        return label;
    }
    public Frame() {
        super();
        this.setTitle("Examples");
        maxNumberPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        amountOfExamplePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel maxNumber = createLabel("Input the max number: ");
        JLabel amountOfExamples = createLabel("Input the amount of examples: ");

        maxNumberInput = new JTextArea(1, 12);
        maxNumberInput.setFont(new Font("Arial", Font.PLAIN, 28));

        amountOfExampleInput = new JTextArea(1, 12);
        amountOfExampleInput.setFont(new Font("Arial", Font.PLAIN, 28));

        amountOfExamplePanel.add(maxNumber);
        amountOfExamplePanel.add(maxNumberInput);

        maxNumberPanel.add(amountOfExamples);
        maxNumberPanel.add(amountOfExampleInput);

        sendButton = new JButton("Generate");
        sendButton.setFont(new Font("Arial", Font.PLAIN, 28));
        sendButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        sendButton.addActionListener(e -> {
            System.out.println(page);
            if (validateInput(maxNumberInput.getText(), amountOfExampleInput.getText())) {
                remove(sendButton);
                remove(maxNumberPanel);
                remove(amountOfExamplePanel);
                int length = Integer.parseInt(amountOfExampleInput.getText());
                JPanel examplePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                examplePanel.setBorder(new TitledBorder(page + "/" + length));
                GenerateExamples ge = new GenerateExamples();
                Example [] examples = new Example [length];
                for (int i = 0; i < length; i++) {
                    examples[i] = ge.generateExample(Integer.parseInt(maxNumberInput.getText()));
                }
                JLabel label = createLabel(examples[page - 1].getExample() + "= ?");
                JTextField textField = new JTextField();
                JButton button = new JButton("Next");
                button.addActionListener(event -> {

                        try {
                            Integer.parseInt(textField.getText());
                        } catch (NumberFormatException ex) {
                            textField.setText("");
                        }
                        if (textField.getText().equals("")) {
                            MessageDialogWithStringArray.showMessage("Incorrect");
                        } else if (examples[page - 1].getResult() == Integer.parseInt(textField.getText())) {
                            MessageDialogWithStringArray.showMessage("Correct!");
                            correctCounter++;
                            System.out.println(correctCounter);
                        } else {
                            MessageDialogWithStringArray.showMessage("Incorrect");
                        }
                        textField.setText("");
                        incPage();
                        if (page == length + 1) {
                            button.setEnabled(false);
                            button.setText("Finish");
                            MessageDialogWithStringArray.showMessage("Result: " + correctCounter + " / " + length);
                            textField.setEnabled(false);
                            examplePanel.setVisible(false);
                            examplePanel.removeAll();
                            remove(examplePanel);

                            this.add(maxNumberPanel);
                            this.add(amountOfExamplePanel);
                            this.add(sendButton);
                            maxNumberInput.setText("");
                            amountOfExampleInput.setText("");
                            this.setLayout(new GridLayout(3, 1));
                            page = 1;
                            correctCounter = 0;
                            return;
                        }
                        examplePanel.setBorder(new TitledBorder(page + "/" + length));
                        label.setText(examples[page - 1].getExample() + "= ?");
                    }
                );
                textField.setFont(new Font("Arial", Font.PLAIN, 28));
                textField.setHorizontalAlignment(JTextField.LEFT);
                examplePanel.setLayout(new BoxLayout(examplePanel, BoxLayout.Y_AXIS));
                examplePanel.add(label);
                examplePanel.add(textField);
                examplePanel.add(button);

                this.setLayout(new GridLayout(1, 1));
                add(examplePanel);

            }
            else {
                this.setVisible(false);
                maxNumberInput.setText("");
                amountOfExampleInput.setText("");
                JFrame parent = new JFrame();
                parent.setTitle("Examples");
                JOptionPane.showMessageDialog(parent, "Incorrect input. Try again.", "Incorrect input", JOptionPane.ERROR_MESSAGE);
                parent.dispose();
            }
            this.setVisible(true);
        });
        this.setLayout(new GridLayout(3, 1));
        this.setSize(800, 400);
        this.add(maxNumberPanel);
        this.add(amountOfExamplePanel);
        this.add(sendButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void incPage() {
        page++;
    }

    private static boolean validateInput(String maxNumber, String amountOfExamples) {
        int intAmountOfExamples;
        try {
            Integer.parseInt(maxNumber);
        } catch (NumberFormatException e) {
            return false;
        }
        try {
            intAmountOfExamples = Integer.parseInt(amountOfExamples);
        } catch (NumberFormatException e) {
            return false;
        }
        return intAmountOfExamples > 0;
    }

}

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setVisible(true);

    }
}