package com.lee.lugank;

import android.app.Application;

/**
 * Created by lihe6 on 2016/6/3.
 */
public class App extends Application {

    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
