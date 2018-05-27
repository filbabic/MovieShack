package com.babic.filip.movieshack.model;

import java.util.ArrayList;
import java.util.List;

public class MovieList {

    private List<Movie> movies = new ArrayList<>();

    public MovieList(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
