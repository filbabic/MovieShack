package com.babic.filip.movieshack.ui.popular;

import com.babic.filip.movieshack.model.Movie;

import java.util.List;

public interface PopularMoviesContract {

    interface View {

        void showMovies(List<Movie> movies);

        void addMoreMovies(List<Movie> movies);

        void showServerError();

        void showNetworkError();

        void showGeneralError();
    }

    interface Presenter {

        void setView(View view);

        void getMovies(final boolean hasInternet);

        void refresh(final boolean hasInternet);
    }
}


