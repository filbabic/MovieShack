package com.babic.filip.movieshack.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update

import com.babic.filip.movieshack.model.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = REPLACE)
    fun addMovie(movie: Movie)

    @Update
    fun updateMovie(movie: Movie)

    @Query("SELECT * FROM movies WHERE type = :type")
    fun getMoviesByType(type: String): List<Movie>

    @Query("SELECT * FROM movies WHERE id = :id")
    fun getMovieById(id: String): Movie

    @Query("DELETE FROM movies WHERE type =:type")
    fun deleteMoviesByType(type: String)
}
