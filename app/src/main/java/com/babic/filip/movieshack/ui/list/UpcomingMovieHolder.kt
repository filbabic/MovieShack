package com.babic.filip.movieshack.ui.list

import android.view.View
import com.babic.filip.movieshack.common.utils.loadImage

import com.babic.filip.movieshack.model.Movie
import kotlinx.android.synthetic.main.item_movie_upcoming.view.*

class UpcomingMovieHolder(itemView: View) : MovieHolder(itemView) {

    override fun displayItem(movie: Movie) = with(itemView) {
        movie.image?.run { loadImage(movieImage, this) }

        releaseDate.text = movie.releaseDate
        movieName.text = movie.title
    }
}
