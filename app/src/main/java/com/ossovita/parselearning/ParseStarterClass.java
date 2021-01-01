package com.ossovita.parselearning;

import android.app.Application;

import com.parse.Parse;

public class ParseStarterClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
            .applicationId("")
            .clientKey("")
            .server("")
            .build()
        );
    }
}
