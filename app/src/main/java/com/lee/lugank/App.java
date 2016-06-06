package com.lee.lugank;

import android.app.Activity;
import android.app.Application;

import java.lang.ref.WeakReference;
import java.util.Stack;

/**
 * Created by lihe6 on 2016/6/3.
 */
public class App extends Application {

    private static App app;
    private static Stack<WeakReference<Activity>> weakReferenceStack;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        weakReferenceStack = new Stack<>();
        //// TODO: 2016/6/4 初始化各种 
    }

    public static App getInstance() {
        return app;
    }

    public static void pushStack(Activity activity) {
        weakReferenceStack.add(new WeakReference<>(activity));
    }

    public static void exit() {
        for (WeakReference<Activity> weakReference : weakReferenceStack) {
            Activity activity = weakReference.get();
            if (activity != null) {
                activity.finish();
            }
        }
    }
}
