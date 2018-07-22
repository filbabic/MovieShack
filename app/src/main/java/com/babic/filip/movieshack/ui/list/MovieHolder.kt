package com.babic.filip.movieshack.ui.list

import android.support.v7.widget.RecyclerView
import android.view.View

import com.babic.filip.movieshack.model.Movie

abstract class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun displayItem(movie: Movie)
}
