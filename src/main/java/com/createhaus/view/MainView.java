package com.createhaus.view;

import com.createhaus.biscotti.BError;
import com.createhaus.biscotti.BView;
import com.createhaus.presenter.MainPresenter;

import java.awt.*;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MainView extends JPanel implements BView {

    JFrame displayFrame;
    JLabel dataLabel;
    MainPresenter presenter;

    public MainView(MainPresenter presenter) {
        this.presenter = presenter;
    }

    public void setSomeData(String data) {
        dataLabel.setText(data);
    }

    @Override
    public void open() {
        dataLabel = new JLabel();

        setLayout(new GridLayout(1,2));
        add(new JLabel("Here is the data: "));
        add(dataLabel);

        displayFrame = new JFrame("Main Pane");
        displayFrame.getContentPane().add(this, BorderLayout.CENTER);
        displayFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        displayFrame.setSize(new Dimension(600, 100));
        displayFrame.setVisible(true);
        
    }

    public void close() {
        displayFrame.setVisible(false);
    }

    @Override
    public void error(List<BError> list) {

    }

    @Override
    public void compositeView(String s, Component component) {

    }
}
