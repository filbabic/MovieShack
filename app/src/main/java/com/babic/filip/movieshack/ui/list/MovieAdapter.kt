package com.babic.filip.movieshack.ui.list

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.babic.filip.movieshack.R
import com.babic.filip.movieshack.model.Movie

import java.util.ArrayList

class MovieAdapter(@LayoutRes private val movieType: Int) : RecyclerView.Adapter<MovieHolder>() {

    private val movies = ArrayList<Movie>()

    fun setData(items: List<Movie>) {
        movies.clear()
        movies.addAll(items)
        notifyDataSetChanged()
    }

    fun addData(items: List<Movie>) {
        movies.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(movieType, parent, false)

        return when (movieType) {
            R.layout.item_movie_popular -> PopularMovieHolder(view)
            R.layout.item_movie_top_rated -> TopRatedMovieHolder(view)
            else -> UpcomingMovieHolder(view)
        }
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) = holder.displayItem(movies[position])

    override fun getItemCount(): Int = movies.size
}
