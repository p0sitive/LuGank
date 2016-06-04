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
        //// TODO: 2016/6/4 初始化各种 
    }
}
