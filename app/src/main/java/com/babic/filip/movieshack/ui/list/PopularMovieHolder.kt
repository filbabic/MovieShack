package com.babic.filip.movieshack.ui.list

import android.view.View
import com.babic.filip.movieshack.R
import com.babic.filip.movieshack.common.utils.loadImage
import com.babic.filip.movieshack.model.Movie
import kotlinx.android.synthetic.main.item_movie_popular.view.*

class PopularMovieHolder(itemView: View) : MovieHolder(itemView) {

    override fun displayItem(movie: Movie) = with(itemView) {
        movie.image?.run { loadImage(movieImage, this) }

        moviePopularity.text = itemView.context.getString(R.string.movie_popularity, movie.popularity)
        movieName.text = movie.title
    }
}
