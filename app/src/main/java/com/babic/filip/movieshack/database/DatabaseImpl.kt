package com.babic.filip.movieshack.database

import com.babic.filip.movieshack.database.dao.MovieDao
import com.babic.filip.movieshack.model.Movie

class DatabaseImpl(private val movieDao: MovieDao) : DatabaseInterface {

    override fun getMoviesByType(type: String): List<Movie> = movieDao.getMoviesByType(type)

    override fun addMovies(movies: List<Movie>) = movies.forEach { movieDao.addMovie(it) }
    override fun updateMovie(movie: Movie) = movieDao.updateMovie(movie)

    override fun getMovieById(id: String): Movie = movieDao.getMovieById(id)

    override fun clearMoviesByType(type: String) = movieDao.deleteMoviesByType(type)
}
