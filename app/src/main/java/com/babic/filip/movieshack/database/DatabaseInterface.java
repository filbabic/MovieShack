package com.babic.filip.movieshack.database;

import com.babic.filip.movieshack.model.Movie;

import java.util.List;

public interface DatabaseInterface {

    List<Movie> getMoviesByType(String type);

    void addMovie(Movie movie);

    void updateMovie(Movie movie);

    Movie getMovieById(String id);
}
