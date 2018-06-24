package com.babic.filip.movieshack.interaction;

import com.babic.filip.movieshack.api.MovieApiService;
import com.babic.filip.movieshack.common.Constants;
import com.babic.filip.movieshack.common.utils.QueryUtils;
import com.babic.filip.movieshack.model.MovieList;

import javax.inject.Inject;

import retrofit2.Callback;

public class MovieInteractorImpl implements MovieInteractor {

    private final MovieApiService movieApiService;

    @Inject
    public MovieInteractorImpl(MovieApiService movieApiService) {
        this.movieApiService = movieApiService;
    }

    @Override
    public void getMovies(final int page, final String movieType, final Callback<MovieList> callback) {
        switch (movieType) {
            case Constants.TYPE_POPULAR: {
                movieApiService.getPopularMovies(QueryUtils.getMoviesQuery(page)).enqueue(callback);
                break;
            }

            case Constants.TYPE_UPCOMING: {
                movieApiService.getUpcomingMovies(QueryUtils.getMoviesQuery(page)).enqueue(callback);
                break;
            }

            case Constants.TYPE_TOP_RATED: {
                movieApiService.getTopRatedMovies(QueryUtils.getMoviesQuery(page)).enqueue(callback);
                break;
            }

            default:
                break;
        }
    }
}
