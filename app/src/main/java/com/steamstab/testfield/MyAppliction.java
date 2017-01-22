package com.steamstab.testfield;

import android.app.Application;

/**
 * Created by Steam on 2017/1/16.
 */

public class MyAppliction extends Application {

    public static MyAppliction appliction;

    @Override
    public void onCreate() {
        super.onCreate();
        appliction = this;
    }

}
