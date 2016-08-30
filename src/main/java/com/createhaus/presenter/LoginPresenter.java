package com.createhaus.presenter;

import com.createhaus.App;
import com.createhaus.biscotti.BPresenter;
import com.createhaus.biscotti.BSession;
import com.createhaus.model.LoginModel;
import com.createhaus.service.QueryEngine;

public class LoginPresenter extends BPresenter {

    @Override
    public void display() {
        views.get("main").open();
    }

    public void login() {
        LoginModel model = (LoginModel) models.get("main");

        try {
            QueryEngine queryEngine = new QueryEngine(model.getServer(), model.getUsername(), model.getPassword());

            // Bind the queryEngine to the session
            BSession.set("queryEngine", queryEngine);

            // Close the view
            views.get("main").close();

            // Return control to the app
            App.main();
        }
        catch (Exception e) {
            // TODO: display the error message in the view
            e.printStackTrace();
        }
    }
}
