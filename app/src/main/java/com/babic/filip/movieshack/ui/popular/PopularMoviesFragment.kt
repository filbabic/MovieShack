package com.babic.filip.movieshack.ui.popular

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
import com.babic.filip.movieshack.model.Movie
import com.babic.filip.movieshack.networking.NetworkingUtils
import com.babic.filip.movieshack.ui.list.MovieAdapter
import com.babic.filip.movieshack.viewModel.PopularMoviesViewModel
import kotlinx.android.synthetic.main.fragment_movies.*
import org.koin.android.architecture.ext.viewModel

class PopularMoviesFragment : Fragment(), RefreshablePage, PopularMoviesView {

    private val adapter = MovieAdapter(R.layout.item_movie_popular)
    private val viewModel by viewModel<PopularMoviesViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()

        viewModel.setView(this)
        viewModel.viewState().observe(this, Observer { it?.run(::showData) })
    }

    private fun showData(moviesViewState: MoviesViewState) {
        adapter.setData(moviesViewState.movies)
    }

    private fun initUi() {
        movies.itemAnimator = DefaultItemAnimator()
        movies.layoutManager = LinearLayoutManager(activity)
        movies.adapter = adapter
        movies.addOnScrollListener(LastItemReachedListener { viewModel.getMovies(NetworkingUtils.hasInternet(activity)) })
    }

    override fun refresh() = viewModel.refresh(NetworkingUtils.hasInternet(activity))

    override fun showServerError() = Toast.makeText(activity, getString(R.string.server_error), Toast.LENGTH_SHORT).show()
    override fun showNetworkError() = Toast.makeText(activity, getString(R.string.network_error), Toast.LENGTH_SHORT).show()
    override fun showGeneralError() = Toast.makeText(activity, getString(R.string.general_error), Toast.LENGTH_SHORT).show()
}


