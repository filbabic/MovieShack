package com.babic.filip.movieshack.ui.topRated

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.babic.filip.movieshack.R
import com.babic.filip.movieshack.listener.LastItemReachedListener
import com.babic.filip.movieshack.listener.RefreshablePage
import com.babic.filip.movieshack.networking.hasInternet
import com.babic.filip.movieshack.ui.base.BaseMoviesFragment
import com.babic.filip.movieshack.ui.list.MovieAdapter
import com.babic.filip.movieshack.ui.list.MoviesViewState
import com.babic.filip.movieshack.viewModel.TopRatedMoviesViewModel
import kotlinx.android.synthetic.main.fragment_movies.*
import org.koin.android.architecture.ext.viewModel

class TopRatedMoviesFragment : BaseMoviesFragment(), RefreshablePage, TopRatedMoviesView {

    private val movieAdapter = MovieAdapter(R.layout.item_movie_top_rated)
    private val viewModel by viewModel<TopRatedMoviesViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()

        viewModel.setView(this)
        viewModel.viewState().observe(this, Observer { it?.run(::showData) })

        viewModel.getMovies(hasInternet(activity))
    }

    private fun showData(moviesViewState: MoviesViewState) = movieAdapter.setData(moviesViewState.movies)

    private fun initUi() = movies.apply {
        itemAnimator = DefaultItemAnimator()
        layoutManager = LinearLayoutManager(activity)
        adapter = movieAdapter
        addOnScrollListener(LastItemReachedListener { viewModel.getMovies(hasInternet(activity)) })
    }

    override fun refresh() = viewModel.refresh(hasInternet(activity))
}
