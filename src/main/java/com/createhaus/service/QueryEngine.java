package com.createhaus.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by kevin on 8/29/16.
 */
public class QueryEngine {

    private String server;
    private String user;
    private String password;

    public QueryEngine(String server, String user, String password) throws Exception {
        this.server = server;
        this.user = user;
        this.password = password;

        connect();
    }

    private Connection connect() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://" + server, user, password);
        return conn;
    }

    public List<String> listDatabases() {
        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("show databases");


            List<String> results = new ArrayList<String>();

            // data of the table
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                results.add(rs.getString(1));
            }

            return results;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet query(String database, String sql) {
        try {
            Connection conn = connect();
            conn.setCatalog(database);
            Statement stmt = conn.createStatement();

            return stmt.executeQuery(sql);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
