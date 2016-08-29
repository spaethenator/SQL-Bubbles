package com.createhaus.presenter;

import com.createhaus.biscotti.BPresenter;
import com.createhaus.biscotti.BSession;
import com.createhaus.model.Connection;
import com.createhaus.model.MainModel;


public class MainPresenter extends BPresenter {

    public void init() {
        views.get("main").open();
    }

    public void display() {
        // Populate our model with the data from the bound connection
        Connection connection = (Connection) BSession.get("connection");
        MainModel model = (MainModel)models.get("main");
        model.setSomeData(connection.getSomeData());

        super.display();
    }
}