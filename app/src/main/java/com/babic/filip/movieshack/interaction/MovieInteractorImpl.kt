package com.babic.filip.movieshack.interaction

import com.babic.filip.movieshack.api.MovieApiService
import com.babic.filip.movieshack.common.TYPE_POPULAR
import com.babic.filip.movieshack.common.TYPE_TOP_RATED
import com.babic.filip.movieshack.common.TYPE_UPCOMING
import com.babic.filip.movieshack.common.utils.getMoviesQuery
import com.babic.filip.movieshack.model.MovieList

import retrofit2.Callback

class MovieInteractorImpl(private val movieApiService: MovieApiService) : MovieInteractor {

    override fun getMovies(page: Int, movieType: String, callback: Callback<MovieList>) = when (movieType) {
        TYPE_POPULAR -> movieApiService.getPopularMovies(getMoviesQuery(page)).enqueue(callback)
        TYPE_UPCOMING -> movieApiService.getUpcomingMovies(getMoviesQuery(page)).enqueue(callback)
        TYPE_TOP_RATED -> movieApiService.getTopRatedMovies(getMoviesQuery(page)).enqueue(callback)
        else -> Unit
    }
}
