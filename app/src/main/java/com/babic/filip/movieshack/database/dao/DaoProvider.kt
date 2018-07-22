package com.babic.filip.movieshack.database.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.babic.filip.movieshack.App

import com.babic.filip.movieshack.model.Movie

@Database(entities = [(Movie::class)], version = 1)
abstract class DaoProvider : RoomDatabase() {

    companion object {

        private val NAME = "movies_database"

        val instance: DaoProvider by lazy {
            Room.databaseBuilder(App.instance, DaoProvider::class.java, NAME)
                    .allowMainThreadQueries()
                    .build()
        }
    }

    abstract fun movieDao(): MovieDao
}

