package com.createhaus.model;

import com.createhaus.biscotti.BModel;

public class LoginModel implements BModel {

    private String username;
    private String password;
    private String server;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
