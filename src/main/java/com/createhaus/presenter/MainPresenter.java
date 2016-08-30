package com.createhaus.presenter;

import com.createhaus.biscotti.BPresenter;
import com.createhaus.biscotti.BSession;
import com.createhaus.model.MainModel;
import com.createhaus.service.QueryEngine;
import com.createhaus.view.Bubble;

import java.sql.ResultSet;


public class MainPresenter extends BPresenter {

    public void init() {
        views.get("main").open();
    }

    public void display() {

        QueryEngine queryEngine = (QueryEngine)BSession.get("queryEngine");

        MainModel model = (MainModel)models.get("main");
        model.setDatabases(queryEngine.listDatabases());

        views.get("main").update(model);
    }

    public void performQuery(Bubble bubble, String database, String sql) {
        QueryEngine queryEngine = (QueryEngine)BSession.get("queryEngine");
        ResultSet rs = queryEngine.query(database, sql);

        bubble.setOutput(rs);
    }
}