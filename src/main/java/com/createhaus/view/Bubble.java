package com.createhaus.view;

import com.createhaus.model.MainModel;
import com.createhaus.presenter.MainPresenter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

public class Bubble extends JInternalFrame implements ActionListener {
    static int openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;

    private JTable table;
    private JTextField name;
    private JTextArea sql;
    private MainPresenter presenter;
    JComboBox databases;

    public Bubble(MainPresenter presenter) {
        super("Query" + (++openFrameCount),
                true, //resizable
                true, //closable
                true, //maximizable
                true);//iconifiable

        this.presenter = presenter;
        name = new JTextField(20);
        name.setText("Query" + openFrameCount);

        databases = new JComboBox();
        for (String database : ((MainModel)presenter.getModel("main")).getDatabases()) {
            databases.addItem(database);
        }

        JButton runButton = new JButton("Run");
        runButton.addActionListener(this);

        JPanel namePanel = new JPanel(new BorderLayout());

        namePanel.add(name, BorderLayout.WEST);
        namePanel.add(databases, BorderLayout.CENTER);
        namePanel.add(runButton, BorderLayout.EAST);

        sql = new JTextArea(6, 20);
        table = new JTable();
        JScrollPane scrollTable = new JScrollPane(table);

        JPanel internal = new JPanel();
        internal.setBorder(new EmptyBorder(5, 5, 5, 5));
        internal.setLayout(new BorderLayout(2, 2));
        internal.add(namePanel, BorderLayout.NORTH);
        internal.add(sql, BorderLayout.CENTER);
        internal.add(scrollTable, BorderLayout.SOUTH);

        setLayout(new BorderLayout());
        add(internal, BorderLayout.CENTER);

        pack();

        //Set the window's location.
        setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        presenter.performQuery(this, (String)databases.getSelectedItem(), sql.getText());
    }

    public void setOutput(ResultSet rs) {
        try {

            ResultSetMetaData metaData = rs.getMetaData();

            // names of columns
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(metaData.getColumnName(column));
            }

            // data of the table
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);
            }

            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            table.setModel(model);

            invalidate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}