package com.babic.filip.movieshack.api;

import com.babic.filip.movieshack.model.MovieList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApiService {

    // TODO: 27/05/2018 add proper parameters for each request
    @GET("/movies")
    Call<MovieList> getTopRatedMovies();

    @GET("/movies")
    Call<MovieList> getUpcomingMovies();


    @GET("/movies")
    Call<MovieList> getPopularMovies();
}
