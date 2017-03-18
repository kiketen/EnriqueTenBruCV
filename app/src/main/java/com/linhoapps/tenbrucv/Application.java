package com.linhoapps.tenbrucv;

import android.app.Activity;
import android.content.Context;

public class Application extends android.app.Application {
    private static Activity currentActivity = null;
    private static Context currentContext = null;

    public static Context getCurrentContext() {
        return Application.currentContext;
    }

    public static Activity getCurrentActivity() {
        return Application.currentActivity;
    }

    public static void setCurrentActivity(Activity activity) {
        Application.currentActivity = activity;
    }

    public static void setCurrentContext(Context context) {
        Application.currentContext = context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        currentContext = this.getApplicationContext();
    }


}