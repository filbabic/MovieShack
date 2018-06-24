package com.babic.filip.movieshack;

import android.app.Application;

import com.babic.filip.movieshack.database.DatabaseImpl;
import com.babic.filip.movieshack.database.DatabaseInterface;
import com.babic.filip.movieshack.database.dao.DaoProvider;
import com.babic.filip.movieshack.di.AppComponent;
import com.babic.filip.movieshack.di.DaggerAppComponent;
import com.babic.filip.movieshack.di.module.AppModule;
import com.babic.filip.movieshack.interaction.MovieInteractor;
import com.babic.filip.movieshack.networking.NetworkingUtils;

public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }

    public static AppComponent component() {
        return appComponent;
    }
}