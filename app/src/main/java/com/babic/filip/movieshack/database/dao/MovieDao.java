package com.babic.filip.movieshack.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.babic.filip.movieshack.model.Movie;

import java.util.List;

@Dao
public interface MovieDao {

    @Insert
    void addMovie(Movie movie);

    @Update
    void updateMovie(Movie movie);

    @Query("SELECT * FROM movies WHERE type = :type")
    List<Movie> getMoviesByType(String type);

    @Query("SELECT * FROM movies WHERE id = :id")
    Movie getMovieById(String id);
}
