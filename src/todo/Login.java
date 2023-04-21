package todo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame{

    JFrame frame;
    JTextField emailField;
    JPasswordField passwordField;
    JButton btnlogin;
    JButton btnback;
    JLabel label;
    JLabel emailLabel;
    JLabel passwordLabel;


    Login()
    {
        frame = new JFrame();
        frame.setSize(422,600);
        frame.getContentPane().setBackground(Color.WHITE);

        JButton btnClose = new JButton("X");
        btnClose.setFont(new Font("Poppins", Font.BOLD,14));
        btnClose.setFocusable(false);
        btnClose.setBorder(null);
        btnClose.setBackground(Color.WHITE);
        btnClose.setForeground(Color.decode("#568564"));
        btnClose.setBounds(382,0,45,25);

        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        label =new JLabel();
        label.setFont(new Font("Poppins", Font.BOLD, 36));
        label.setForeground(Color.decode("#568564"));
        label.setBounds(160,85,103,54);
        label.setText("Login");

        emailLabel =new JLabel();
        emailLabel.setFont(new Font("Poppins", Font.BOLD, 16));
        emailLabel.setForeground(Color.decode("#568564"));
        emailLabel.setBounds(40, 209,48, 24);
        emailLabel.setText("Email");

        emailField= new JTextField();
        emailField.setBounds(40,245,342,35);
        emailField.setFont(new Font("Poppins", Font.PLAIN, 16));

        passwordLabel =new JLabel();
        passwordLabel.setFont(new Font("Poppins", Font.BOLD, 16));
        passwordLabel.setBounds(40, 302,83, 24);
        passwordLabel.setForeground(Color.decode("#568564"));
        passwordLabel.setText("Password");

        passwordField =new JPasswordField();
        passwordField.setBounds(40,338,342,35);
        passwordField.setFont(new Font("Poppins", Font.PLAIN, 16));

        btnlogin = new JButton("Login");
        btnlogin.setFont(new Font("Poppins", Font.BOLD, 16));
        btnlogin.setBorder(null);
        btnlogin.setFocusable(false);
        btnlogin.setBackground(Color.decode("#568564"));
        btnlogin.setForeground(Color.decode("#FFF3A7"));
        btnlogin.setBounds(236,432,146,35);

        btnlogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = emailField.getText();
                String password = new String(passwordField.getPassword());
                boolean isValid = DataBase.validateUser(username, password);
                if (isValid) {
                    JOptionPane.showMessageDialog(frame, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid email or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnback = new JButton("Back");
        btnback.setFont(new Font("Poppins", Font.BOLD, 16));
        btnback.setBorder(null);
        btnback.setFocusable(false);
        btnback.setBackground(Color.decode("#568564"));
        btnback.setForeground(Color.decode("#FFF3A7"));
        btnback.setBounds(40,432,147,35);

        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new welcomeScreen();
            }
        });

        JButton haveAcc = new JButton("Don’t have an account? Sign up");
        haveAcc.setFont(new Font("Poppins", Font.PLAIN, 16));
        haveAcc.setBorder(null);
        haveAcc.setFocusable(false);
        haveAcc.setBackground(Color.decode("#ffffff"));
        haveAcc.setForeground(Color.decode("#568564"));
        haveAcc.setBounds(87,479,255,24);
        haveAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Register();
            }
        });

        frame.add(btnClose);
        frame.add(label);
        frame.add(passwordLabel);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(passwordField);
        frame.add(btnlogin);
        frame.add(btnback);
        frame.add(haveAcc);

        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Login();
    }
}