package com.babic.filip.movieshack.ui.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.babic.filip.movieshack.model.Movie;

public abstract class MovieHolder extends RecyclerView.ViewHolder {

    public MovieHolder(final View itemView) {
        super(itemView);
    }

    abstract void displayItem(final Movie movie);
}
