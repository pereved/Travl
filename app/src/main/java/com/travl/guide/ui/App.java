package com.travl.guide.ui;

import android.app.Application;

import com.travl.guide.di.interfaces.AppComponent;
import com.travl.guide.di.interfaces.DaggerAppComponent;
import com.travl.guide.di.modules.AppModule;

import org.jetbrains.annotations.Contract;

//Created by Pereved on 21.02.2019.
public class App extends Application {

    private static App instance;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }

    @Contract(pure = true)
    public static App getInstance() {
        return instance;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}