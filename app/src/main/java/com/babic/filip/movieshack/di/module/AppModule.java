package com.babic.filip.movieshack.di.module;

import android.content.Context;

import com.babic.filip.movieshack.database.DatabaseImpl;
import com.babic.filip.movieshack.database.DatabaseInterface;
import com.babic.filip.movieshack.database.dao.DaoProvider;
import com.babic.filip.movieshack.database.dao.MovieDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
@Singleton
public class AppModule {

    private final Context context;

    public AppModule(final Context context) {
        this.context = context;
    }

    @Provides
    public Context context() {
        return context;
    }

    @Provides
    public DaoProvider daoProvider(final Context context) {
        return DaoProvider.getInstance(context);
    }

    @Provides
    public MovieDao movieDao(final DaoProvider provider) {
        return provider.getMovieDao();
    }

    @Provides
    public DatabaseInterface databaseInterface(final MovieDao dao) {
        return new DatabaseImpl(dao);
    }
}
