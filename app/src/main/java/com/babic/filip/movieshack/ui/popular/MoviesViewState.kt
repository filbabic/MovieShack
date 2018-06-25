package com.babic.filip.movieshack.ui.popular

import com.babic.filip.movieshack.model.Movie

data class MoviesViewState(val movies: List<Movie> = listOf(), val isLoading: Boolean = false)