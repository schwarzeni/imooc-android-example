package com.example.imoocproject;

import android.app.Application;

import com.example.imooc.app.Imooc;


/**
 * @author nizhenyang
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Imooc.init(this)
                .withApiHost("http://localhost")
                .configure();

    }
}
