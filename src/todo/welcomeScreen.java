package todo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class welcomeScreen extends JFrame{

    welcomeScreen()
    {
        JFrame frame = new JFrame();
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

        JLabel title = new JLabel();
        title.setText("TO-DO");
        title.setFont(new Font("Poppins", Font.BOLD,48));
        title.setBounds(128,41,169,72);
        title.setForeground(Color.decode("#568564"));

        JLabel hero = new JLabel();
        hero.setIcon(new ImageIcon("D:\\JAVA\\TO-DO\\src\\todo\\hero.png"));
        hero.setBounds(60,148,301,224);


        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Poppins", Font.BOLD,16));
        btnLogin.setFocusable(false);
        btnLogin.setBorder(null);
        btnLogin.setBackground(Color.decode("#568564"));
        btnLogin.setForeground(Color.decode("#FFF3A7"));
        btnLogin.setBounds(111,454,200,35);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Login();
            }
        });

        JButton btnSignup = new JButton("Sign up");
        btnSignup.setFont(new Font("Poppins", Font.BOLD,16));
        btnSignup.setFocusable(false);
        btnSignup.setBorder(null);
        btnSignup.setBackground(Color.decode("#568564"));
        btnSignup.setForeground(Color.decode("#FFF3A7"));
        btnSignup.setBounds(111,514,200,35);

        btnSignup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Register();
            }
        });

        frame.add(btnClose);
        frame.add(title);
        frame.add(hero);
        frame.add(btnLogin);
        frame.add(btnSignup);

        frame.setLayout(null);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        new welcomeScreen();
    }
}
