package com.babic.filip.movieshack.ui.upcoming;

import com.babic.filip.movieshack.model.Movie;

import java.util.List;

public interface UpcomingMoviesContract {

    interface View {

        void showMovies(List<Movie> movies);

        void addMoreMovies(List<Movie> movies);

        void showServerError();

        void showNetworkError();

        void showGeneralError();
    }

    interface Presenter {

        void setView(View view);

        void getMovies(boolean hasInternet);

        void refresh(boolean hasInternet);
    }
}
