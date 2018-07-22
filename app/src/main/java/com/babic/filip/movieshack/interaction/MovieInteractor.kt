package com.babic.filip.movieshack.interaction

import com.babic.filip.movieshack.model.MovieList

import retrofit2.Callback

interface MovieInteractor {

    fun getMovies(page: Int, movieType: String, callback: Callback<MovieList>)
}
