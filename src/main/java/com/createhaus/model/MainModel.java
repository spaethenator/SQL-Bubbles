package com.createhaus.model;

import com.createhaus.biscotti.BModel;

import java.util.ArrayList;
import java.util.List;

public class MainModel implements BModel {

    private List<String> databases;

    public List<String> getDatabases() {
        if (databases == null) {
            return new ArrayList<>();
        }
        return databases;
    }

    public void setDatabases(List<String> databases) {
        this.databases = databases;
    }
}
