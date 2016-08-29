package com.createhaus.model;
/**
 *
 * @author Kevin
 */
public class Connection {

    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getSomeData() {
        return "Congratulations!  You retrieved some data from this stub!";
    }

    public boolean isValid() {
        if (username != null) {
            return true;
        } else {
            return false;
        }
    }
}
