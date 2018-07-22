package com.babic.filip.movieshack.database

import com.babic.filip.movieshack.model.Movie

interface DatabaseInterface {

    fun getMoviesByType(type: String): List<Movie>

    fun addMovies(movies: List<Movie>)

    fun updateMovie(movie: Movie)

    fun getMovieById(id: String): Movie

    fun clearMoviesByType(type: String)
}
