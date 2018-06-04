package com.babic.filip.movieshack.api;

import com.babic.filip.movieshack.model.MovieList;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface MovieApiService {

    @GET("/3/movie/top_rated")
    Call<MovieList> getTopRatedMovies(@QueryMap Map<String, String> query);

    @GET("/3/movie/upcoming")
    Call<MovieList> getUpcomingMovies(@QueryMap Map<String, String> query);

    @GET("/3/movie/popular")
    Call<MovieList> getPopularMovies(@QueryMap Map<String, String> query);
}
