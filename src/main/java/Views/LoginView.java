package Views;

import Controllers.LoginController;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class LoginView extends View{


    private JPanel panel = new JPanel();
    private JLabel logoLabel = new JLabel(new ImageIcon("src/main/resources/logo.PNG"));
    private JLabel loginLabel = new JLabel("Login");
    private JTextField login = new JTextField();
    private JLabel passwordLabel = new JLabel("Password");
    private JTextField password = new JPasswordField();
    private JButton loginButton = new JButton("Login");

    JButton exitButton = new JButton("Exit");
    public LoginView() {
        super("Sign in");
        createComponents();
        Container container = getContentPane();
        container.add(panel);
        setup();
    }
    private void createComponents(){

        logoLabel.setBounds(600,50,panel.getPreferredSize().width,panel.getPreferredSize().height);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        login.setColumns(1);
        password.setColumns(1);
        password.setMaximumSize(new Dimension(500,20));
        login.setMaximumSize(new Dimension(500,20));


        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(e -> ((LoginController)Controller).Exit());

        loginButton.addActionListener(e -> ((LoginController)Controller).Login(login.getText(), password.getText()));

        loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(10,200));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(separator);
        panel.add(logoLabel);
        panel.add(loginLabel);
        panel.add(login);
        panel.add(passwordLabel);
        panel.add(password);
        panel.add(loginButton);
        panel.add(exitButton);
    }
}


