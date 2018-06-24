package com.babic.filip.movieshack.presentation;

import com.babic.filip.movieshack.database.DatabaseInterface;
import com.babic.filip.movieshack.interaction.MovieInteractor;
import com.babic.filip.movieshack.model.Movie;
import com.babic.filip.movieshack.model.MovieList;
import com.babic.filip.movieshack.ui.popular.PopularMoviesContract;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

public class PopularMoviesPresenter implements PopularMoviesContract.Presenter {

    private static final String MOVIE_TYPE = "POPULAR";

    private final MovieInteractor movieInteractor;
    private final DatabaseInterface databaseInterface;
    private PopularMoviesContract.View view;

    private int page = 1;

    @Inject
    public PopularMoviesPresenter(final MovieInteractor movieInteractor, final DatabaseInterface databaseInterface) {
        this.movieInteractor = movieInteractor;
        this.databaseInterface = databaseInterface;
    }

    @Override
    public void setView(final PopularMoviesContract.View view) {
        this.view = view;
    }

    @Override
    public void getMovies(final boolean hasInternet) {
        if (page == 1 && !hasInternet) {
            view.showMovies(databaseInterface.getMoviesByType(MOVIE_TYPE));
        } else {
            movieInteractor.getMovies(page, MOVIE_TYPE, getCallback());
        }
    }

    @Override
    public void refresh(final boolean hasInternet) {
        page = 1;
        getMovies(hasInternet);
    }

    private Callback<MovieList> getCallback() {
        return new Callback<MovieList>() {
            @Override
            public void onResponse(final Call<MovieList> call, final Response<MovieList> response) {
                if (response.body() != null && response.body().getMovies() != null) {
                    final List<Movie> movies = response.body().getMovies();

                    if (movies != null && !movies.isEmpty()) {
                        showData(movies);
                    }
                }
            }

            @Override
            public void onFailure(final Call<MovieList> call, final Throwable error) {
                if (error instanceof HttpException) {
                    showServerError();
                } else if (error instanceof IOException) {
                    showNetworkError();
                } else {
                    showGeneralError();
                }
            }
        };
    }

    private void showServerError() {
        view.showServerError();
    }
    private void showNetworkError() {
        view.showNetworkError();
    }
    private void showGeneralError() {
        view.showGeneralError();
    }

    private void showData(final List<Movie> movies) {
        for (Movie movie : movies) {
            movie.setType(MOVIE_TYPE);
        }

        if (page == 1) {
            view.showMovies(movies);
            databaseInterface.clearMoviesByType(MOVIE_TYPE);
            databaseInterface.addMovies(movies);
        } else {
            view.addMoreMovies(movies);
        }

        page++;
    }
}
