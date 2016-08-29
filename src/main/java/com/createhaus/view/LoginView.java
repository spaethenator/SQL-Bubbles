package com.createhaus.view;

import com.createhaus.biscotti.BError;
import com.createhaus.biscotti.BView;
import com.createhaus.presenter.LoginPresenter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginView extends JPanel implements BView, ActionListener {

    JTextField username;
    JPasswordField password;
    JButton submit;

    LoginPresenter presenter;
    JFrame displayFrame;

    public LoginView(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    public void open() {

        setLayout(new GridLayout(3,2));
        username = new JTextField();
        password = new JPasswordField();
        submit = new JButton("Submit");
        submit.addActionListener(this);

        add(new JLabel("Username: "));
        add(username);
        add(new JLabel("Password: "));
        add(password);
        add(submit);

        displayFrame = new JFrame("Login Form");
        displayFrame.getContentPane().add(this, BorderLayout.CENTER);
        displayFrame.setSize(new Dimension(600, 130));
        displayFrame.setVisible(true);
    }

    @Override
    public void compositeView(String s, Component component) {

    }

    public String getUsername() {
        return username.getText();
    }

    public String getPassword() {
        return new String(password.getPassword());
    }

    public void close() {
        displayFrame.setVisible(false);
    }

    @Override
    public void error(List<BError> list) {

    }

    public void actionPerformed(ActionEvent e) {
        presenter.submit();
        presenter.login();
    }

}
