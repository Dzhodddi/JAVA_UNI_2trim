package org.example;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

class PasswordMatch {
    private String username;
    private String password;
    PasswordMatch(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean matches(String  givenUsername, char [] givenPassword) {
        return username.equals(givenUsername) && password.equals(new String(givenPassword)) ;
    }

}

class Frame extends JFrame {
    private JPanel usernamePanel;
    private JPanel passwordPanel;
    private JPasswordField passwordInput;
    private JTextArea usernameInput;
    private PasswordMatch passwordMatch;
    private JButton sendButton;
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 28));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setVerticalAlignment(SwingConstants.TOP);
        return label;
    }
    public Frame(PasswordMatch password) {
        super();
        this.passwordMatch = password;
        this.setTitle("Authorization");
        usernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel usernameLabel = createLabel("Username:");
        JLabel passwordLabel = createLabel("Password: ");
        usernameInput = new JTextArea(1, 12);
        usernameInput.setFont(new Font("Arial", Font.PLAIN, 28));
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameInput);
        usernamePanel.setBorder(new TitledBorder("Username"));
        passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordPanel.setBorder(new TitledBorder("Password"));

        passwordInput = new JPasswordField(12);
        passwordInput.setEchoChar('●');
        passwordInput.setFont(new Font("Arial", Font.PLAIN, 28));
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordInput);

        sendButton = new JButton("Send");
        sendButton.setFont(new Font("Arial", Font.PLAIN, 28));
        sendButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        sendButton.addActionListener(e -> {
            if (passwordMatch.matches(usernameInput.getText(), passwordInput.getPassword())) {
                this.setVisible(false);
                JFrame parent = new JFrame("Authorization Success");
                JOptionPane.showMessageDialog(parent, "~~~фІ мОМеНТ~~~");
                parent.dispose();
            }
            else {
                this.setVisible(false);
                JFrame parent = new JFrame("Authorization Failed");
                JOptionPane.showMessageDialog(parent, "~~~WrOnG PAsSWoRD~~~");
                parent.dispose();
            }
            this.setVisible(true);
        });
        this.setLayout(new GridLayout(3, 1));
        this.setSize(500, 200);
        this.add(usernamePanel);
        this.add(passwordPanel);
        this.add(sendButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

public class Main {
   private static final String USERNAME = "admin";
   private static final String PASSWORD = "admin";
   public static void main(String[] args) {
       Frame frame = new Frame(new PasswordMatch(USERNAME, PASSWORD));
       frame.setVisible(true);
   }
}