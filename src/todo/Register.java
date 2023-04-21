package todo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Register {

    JFrame frame;
    JTextField nameField;
    JTextField emailField;
    JPasswordField passwordField;
    JPasswordField conpassField;
    JButton btnregister;
    JButton btnback;
    JLabel label;
    JLabel nameLabel;
    JLabel emailLabel;
    JLabel passwordLabel;
    JLabel conpassLabel;


    Register()
    {
        frame = new JFrame();
        frame.setSize(1280,720);
        frame.getContentPane().setBackground(Color.WHITE);

        label = new JLabel();
        label.setText("Register");
        label.setFont(new Font("Poppins", Font.BOLD, 52));
        label.setBounds( 568 ,61,221 ,78);

        nameLabel = new JLabel();
        nameLabel.setText("Name");
        nameLabel.setFont(new Font("Poppins", Font.BOLD, 16));
        nameLabel.setBounds( 105 ,285,69 ,33);

        nameField = new JTextField();
        nameField.setBounds(301,277,300,50);
        nameField.setFont(new Font("Poppins", Font.BOLD, 16));

        passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setFont(new Font("Poppins", Font.BOLD, 16));
        passwordLabel.setBounds( 105 ,401,111 ,33);

        passwordField = new JPasswordField();
        passwordField.setBounds(301,392,300,50);
        passwordField.setFont(new Font("Poppins", Font.BOLD, 16));

        emailLabel = new JLabel();
        emailLabel.setText("Email");
        emailLabel.setFont(new Font("Poppins", Font.BOLD, 16));
        emailLabel.setBounds( 677 ,285,64 ,33);

        emailField = new JTextField();
        emailField.setBounds(873,277,300,50);
        emailField.setFont(new Font("Poppins", Font.BOLD, 16));

        conpassLabel = new JLabel();
        conpassLabel.setText("Confirm Pass");
        conpassLabel.setFont(new Font("Poppins", Font.BOLD, 16));
        conpassLabel.setBounds( 677 ,401,151 ,33);

        conpassField = new JPasswordField();
        conpassField.setBounds(873,392,300,50);
        conpassField.setFont(new Font("Poppins", Font.BOLD, 16));

        btnregister = new JButton("Register");
        btnregister.setFont(new Font("Poppins", Font.BOLD, 16));
        btnregister.setBorder(null);
        btnregister.setFocusable(false);
        btnregister.setForeground(Color.WHITE);
        btnregister.setBackground(Color.BLACK);
        btnregister.setBounds(676,517,200,55);

        btnregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String conpass = new String(conpassField.getPassword());
                boolean isValid = true;

                // Check if email is already registered
                if (DataBase.checkEmailExists(email)) {
                    JOptionPane.showMessageDialog(frame, "Email is already in use.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate the password and confirm password fields
                if (!password.equals(conpass)) {
                    JOptionPane.showMessageDialog(frame, "Password does not match", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check if all fields are filled
                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || conpass.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Register the user
                isValid = DataBase.registerUser(name, email, password, conpass);

                if (isValid) {
                    JOptionPane.showMessageDialog(frame, "Register successful!");
                    frame.dispose();
                    new Login();
                } else {
                    JOptionPane.showMessageDialog(frame, "Error registering user", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });


        btnback = new JButton("Back");
        btnback.setFont(new Font("Poppins", Font.BOLD, 16));
        btnback.setBorder(null);
        btnback.setFocusable(false);
        btnback.setForeground(Color.WHITE);
        btnback.setBackground(Color.BLACK);
        btnback.setBounds(404,517,200,55);

        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new welcomeScreen();
            }
        });

        frame.add(label);
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(conpassLabel);
        frame.add(conpassField);
        frame.add(btnregister);
        frame.add(btnback);

        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Register();
    }
}
