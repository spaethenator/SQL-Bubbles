package com.createhaus.view;

import com.createhaus.biscotti.BError;
import com.createhaus.biscotti.BModel;
import com.createhaus.biscotti.BView;
import com.createhaus.presenter.MainPresenter;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import java.awt.event.*;
import java.awt.*;
import java.util.List;

/*
 * MainView.java requires:
 *   Bubble.java
 */
public class MainView extends JFrame
        implements ActionListener, BView {
    JDesktopPane desktop;

    MainPresenter presenter;

    public MainView(MainPresenter presenter) {
        super("SQL Bubbles");

        this.presenter = presenter;

        //Make the big window be indented 50 pixels from each edge
        //of the screen.
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                screenSize.width  - inset*2,
                screenSize.height - inset*2);

        //Set up the GUI.
        desktop = new JDesktopPane(); //a specialized layered pane

        setContentPane(desktop);
        setJMenuBar(createMenuBar());

        //Make dragging a little faster but perhaps uglier.
        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        //Set up the lone menu.
        JMenu menu = new JMenu("Document");
        menu.setMnemonic(KeyEvent.VK_D);
        menuBar.add(menu);

        //Set up the first menu item.
        JMenuItem menuItem = new JMenuItem("New");
        menuItem.setMnemonic(KeyEvent.VK_N);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("new");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        //Set up the second menu item.
        menuItem = new JMenuItem("Quit");
        menuItem.setMnemonic(KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_Q, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("quit");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        return menuBar;
    }

    //React to menu selections.
    public void actionPerformed(ActionEvent e) {
        if ("new".equals(e.getActionCommand())) { //new
            createFrame();
        } else { //quit
            quit();
        }
    }

    //Create a new internal frame.
    protected void createFrame() {
        Bubble frame = new Bubble(presenter);
        frame.setVisible(true); //necessary as of 1.3
        desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }

    //Quit the application.
    protected void quit() {
        System.exit(0);
    }


    @Override
    public void close() {

    }

    @Override
    public void error(List<BError> list) {

    }

    @Override
    public void open() {

        MainView frame = this;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Display the window.
        frame.setVisible(true);
    }

    @Override
    public void compositeView(String s, Component component) {

    }

    @Override
    public void update(BModel bModel) {
        createFrame(); //create first "window"
    }
}