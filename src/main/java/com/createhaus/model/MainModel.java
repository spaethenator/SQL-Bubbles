package com.createhaus.model;

import com.createhaus.biscotti.BModel;

public class MainModel implements BModel {

    private String someData;

    public void setSomeData(String someData) {
        this.someData = someData;
    }

    public String getSomeData() {
        return someData;
    }

}
