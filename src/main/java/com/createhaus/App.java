package com.createhaus;

import com.createhaus.model.LoginModel;
import com.createhaus.model.MainModel;
import com.createhaus.presenter.LoginPresenter;
import com.createhaus.presenter.MainPresenter;
import com.createhaus.view.LoginView;
import com.createhaus.view.MainView;

/**
 * Created by kevin on 8/29/16.
 */
public class App {

    static MainPresenter main;
    static LoginPresenter login;

    public static void main(String[] args) {
        initViewsAndPresenters();

        main.init();
        login.doConnection();
    }

    public static void main() {
        main.display();
    }

    static void initViewsAndPresenters() {

        main = new MainPresenter();
        main.addView("main", new MainView(main));
        main.addModel("main", new MainModel());

        login = new LoginPresenter();
        login.addView("main", new LoginView(login));
        login.addModel("main", new LoginModel());
    }
}
