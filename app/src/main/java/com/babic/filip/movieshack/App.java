package com.babic.filip.movieshack;

import android.app.Application;

import com.babic.filip.movieshack.database.DatabaseImpl;
import com.babic.filip.movieshack.database.DatabaseInterface;
import com.babic.filip.movieshack.database.dao.DaoProvider;
import com.babic.filip.movieshack.interaction.MovieInteractor;
import com.babic.filip.movieshack.networking.NetworkingUtils;

public class App extends Application {

    private static MovieInteractor movieInteractor;
    private static DatabaseInterface databaseInterface;

    @Override
    public void onCreate() {
        super.onCreate();

        movieInteractor = NetworkingUtils.movieInteractor();
        databaseInterface = new DatabaseImpl(DaoProvider.getInstance(this).getMovieDao());
    }

    public static MovieInteractor getMovieInteractor() {
        return movieInteractor;
    }

    public static DatabaseInterface getDatabaseInterface() {
        return databaseInterface;
    }
}