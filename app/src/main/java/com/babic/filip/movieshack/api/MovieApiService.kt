package com.babic.filip.movieshack.api

import com.babic.filip.movieshack.model.MovieList

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface MovieApiService {

    @GET("/3/movie/top_rated")
    fun getTopRatedMovies(@QueryMap query: Map<String, String>): Call<MovieList>

    @GET("/3/movie/upcoming")
    fun getUpcomingMovies(@QueryMap query: Map<String, String>): Call<MovieList>

    @GET("/3/movie/popular")
    fun getPopularMovies(@QueryMap query: Map<String, String>): Call<MovieList>
}
