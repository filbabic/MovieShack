package com.babic.filip.movieshack.database;

import com.babic.filip.movieshack.model.Movie;

import java.util.List;

public interface DatabaseInterface {

    List<Movie> getMoviesByType(String type);

    void addMovies(List<Movie> movies);

    void updateMovie(Movie movie);

    Movie getMovieById(String id);

    void clearMoviesByType(String type);
}
