package com.createhaus.view;

import com.createhaus.biscotti.BError;
import com.createhaus.biscotti.BModel;
import com.createhaus.biscotti.BView;
import com.createhaus.presenter.LoginPresenter;
import layout.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class LoginView extends JPanel implements BView, ActionListener {

    JTextField server;
    JTextField username;
    JPasswordField password;
    JButton submit;

    LoginPresenter presenter;
    JFrame displayFrame;

    public LoginView(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    public void open() {

        setLayout(new SpringLayout());

        server = new JTextField(20);
        username = new JTextField(20);
        password = new JPasswordField(20);
        submit = new JButton("Submit");
        submit.addActionListener(this);

        add(new JLabel("Server: "));
        add(server);
        add(new JLabel("Username: "));
        add(username);
        add(new JLabel("Password: "));
        add(password);

        SpringUtilities.makeCompactGrid(this,
                3, 2,
                6, 6,
                6, 6);

        displayFrame = new JFrame("Login");
        displayFrame.getContentPane().setLayout(new BorderLayout());
        displayFrame.getContentPane().add(this, BorderLayout.CENTER);
        displayFrame.getContentPane().add(submit, BorderLayout.SOUTH);

        displayFrame.pack();
        displayFrame.setVisible(true);
    }

    @Override
    public void compositeView(String s, Component component) {}

    @Override
    public void update(BModel bModel) {

    }

    public String getUsername() {
        return username.getText();
    }

    public String getPassword() {
        return new String(password.getPassword());
    }

    public String getServer() { return server.getText(); }

    public void close() {
        displayFrame.setVisible(false);
    }

    @Override
    public void error(List<BError> list) {}

    public void actionPerformed(ActionEvent e) {
        presenter.submit();
        presenter.login();
    }
}
