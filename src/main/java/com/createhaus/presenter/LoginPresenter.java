package com.createhaus.presenter;

import com.createhaus.App;
import com.createhaus.biscotti.BPresenter;
import com.createhaus.biscotti.BSession;
import com.createhaus.model.Connection;
import com.createhaus.model.LoginModel;

public class LoginPresenter extends BPresenter {

    Connection connection;

    public void doConnection() {
        views.get("main").open();
    }

    public void login() {
        LoginModel model = (LoginModel) models.get("main");


            if(connection == null) {
                connection = new Connection();
            }

            connection.setUsername(model.getUsername());
            connection.setPassword(model.getPassword());

            if(connection.isValid()) {
                // Bind the connection
                BSession.set("connection", connection);

                // Close the view
                views.get("main").close();

                // Return control to the app
                App.main();
            }
            else {
                // TODO: display the error message in the view
            }
    }
}
