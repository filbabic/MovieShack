package com.babic.filip.movieshack.interaction;

import com.babic.filip.movieshack.model.MovieList;

import retrofit2.Callback;

public interface MovieInteractor {

    void getMovies(int page, final String movieType, Callback<MovieList> callback);
}
