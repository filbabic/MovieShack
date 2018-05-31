package com.babic.filip.movieshack.database.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {MovieDao.class}, version = 1)
public abstract class DaoProvider extends RoomDatabase {

    public abstract MovieDao getMovieDao();

    private static DaoProvider instance;

    public static DaoProvider getInstance(Context context) {
        if (instance == null) {
            synchronized (DaoProvider.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context, DaoProvider.class, "movies_database")
                                   .allowMainThreadQueries()
                                   .build();
                }
            }
        }

        return instance;
    }
}
