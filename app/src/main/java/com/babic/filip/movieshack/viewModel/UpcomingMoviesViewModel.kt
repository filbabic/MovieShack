package com.babic.filip.movieshack.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.babic.filip.movieshack.database.DatabaseInterface
import com.babic.filip.movieshack.interaction.MovieInteractor
import com.babic.filip.movieshack.model.Movie
import com.babic.filip.movieshack.model.MovieList
import com.babic.filip.movieshack.ui.base.BaseViewModel
import com.babic.filip.movieshack.ui.list.MoviesViewState
import com.babic.filip.movieshack.ui.upcoming.UpcomingMoviesView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

private const val MOVIE_TYPE = "UPCOMING"

class UpcomingMoviesViewModel(private val databaseInterface: DatabaseInterface,
                              private val movieInteractor: MovieInteractor) : ViewModel(), BaseViewModel<UpcomingMoviesView, MoviesViewState> {

    private val viewState = MutableLiveData<MoviesViewState>()

    private lateinit var view: UpcomingMoviesView
    private var page = 1

    override fun setView(view: UpcomingMoviesView) {
    }

    override fun viewState(): LiveData<MoviesViewState> = viewState


    fun getMovies(hasInternet: Boolean) = if (page == 1 && !hasInternet) {
        val data = MoviesViewState(databaseInterface.getMoviesByType(MOVIE_TYPE))
        viewState.value = data
    } else {
        movieInteractor.getMovies(page, MOVIE_TYPE, getCallback())
    }

    fun refresh(hasInternet: Boolean) {
        page = 1
        getMovies(hasInternet)
    }

    private fun getCallback(): Callback<MovieList> = object : Callback<MovieList> {
        override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
            response.body()?.movies?.run { if (!isEmpty()) showData(this) }
        }

        override fun onFailure(call: Call<MovieList>, error: Throwable) = when (error) {
            is HttpException -> showServerError()
            is IOException -> showNetworkError()
            else -> showGeneralError()
        }
    }

    private fun showServerError() = view.showServerError()
    private fun showNetworkError() = view.showNetworkError()
    private fun showGeneralError() = view.showGeneralError()

    private fun showData(newMovies: List<Movie>) {
        newMovies.forEach { it.type = MOVIE_TYPE }

        if (page == 1) {
            databaseInterface.clearMoviesByType(MOVIE_TYPE)
            databaseInterface.addMovies(newMovies)
            viewState.value = null
        }
        val data = (viewState.value ?: MoviesViewState()).let {
            it.copy(movies = it.movies + newMovies)
        }

        viewState.value = data

        page++
    }
}