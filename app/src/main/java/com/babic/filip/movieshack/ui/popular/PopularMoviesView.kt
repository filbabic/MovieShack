package com.babic.filip.movieshack.ui.popular

interface PopularMoviesView {

    fun showServerError()

    fun showNetworkError()

    fun showGeneralError()
}