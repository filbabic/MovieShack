package com.babic.filip.movieshack.database;

import com.babic.filip.movieshack.database.dao.MovieDao;
import com.babic.filip.movieshack.model.Movie;

import java.util.List;

public class DatabaseImpl implements DatabaseInterface {

    private final MovieDao movieDao;

    public DatabaseImpl(final MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> getMoviesByType(final String type) {
        return movieDao.getMoviesByType(type);
    }

    @Override
    public void addMovie(final Movie movie) {
        movieDao.addMovie(movie);
    }

    @Override
    public void updateMovie(final Movie movie) {
        movieDao.updateMovie(movie);
    }

    @Override
    public Movie getMovieById(final String id) {
        return movieDao.getMovieById(id);
    }
}
