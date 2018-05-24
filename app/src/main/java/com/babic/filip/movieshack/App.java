package com.babic.filip.movieshack;

import android.app.Application;

import com.babic.filip.movieshack.interaction.MovieInteractor;
import com.babic.filip.movieshack.networking.NetworkingUtils;

public class App extends Application {

    private MovieInteractor movieInteractor;

    @Override
    public void onCreate() {
        super.onCreate();

        movieInteractor = NetworkingUtils.movieInteractor();
    }
}
