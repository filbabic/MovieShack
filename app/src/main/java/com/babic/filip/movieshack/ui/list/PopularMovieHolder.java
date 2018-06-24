package com.babic.filip.movieshack.ui.list;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.babic.filip.movieshack.R;
import com.babic.filip.movieshack.common.utils.ImageUtils;
import com.babic.filip.movieshack.model.Movie;

public class PopularMovieHolder extends MovieHolder {

    public PopularMovieHolder(final View itemView) {
        super(itemView);
    }

    @Override
    void displayItem(@NonNull final Movie movie) {
        TextView moviePopularity = itemView.findViewById(R.id.moviePopularity);
        TextView movieName = itemView.findViewById(R.id.movieName);
        ImageView movieImage = itemView.findViewById(R.id.movieImage);

        moviePopularity.setText(itemView.getContext().getString(R.string.movie_popularity, movie.getPopularity()));
        movieName.setText(movie.getTitle());

        ImageUtils.loadImage(movieImage, movie.getImage());
    }
}
