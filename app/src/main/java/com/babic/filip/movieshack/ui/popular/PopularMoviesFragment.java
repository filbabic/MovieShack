package com.babic.filip.movieshack.ui.popular;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.babic.filip.movieshack.App;
import com.babic.filip.movieshack.R;
import com.babic.filip.movieshack.listener.RefreshablePage;
import com.babic.filip.movieshack.model.Movie;
import com.babic.filip.movieshack.model.MovieList;
import com.babic.filip.movieshack.networking.NetworkingUtils;
import com.babic.filip.movieshack.ui.list.MovieAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularMoviesFragment extends Fragment implements RefreshablePage {

    private final MovieAdapter adapter = new MovieAdapter(R.layout.item_movie_popular);

    private int page = 1;

    private static final String MOVIE_TYPE = "POPULAR";

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi(view);

        getMovies();
    }

    private void initUi(View view) {
        RecyclerView movies = view.findViewById(R.id.movies);
        movies.setItemAnimator(new DefaultItemAnimator());
        movies.setLayoutManager(new LinearLayoutManager(getActivity()));
        movies.setAdapter(adapter);
    }

    @Override
    public void refresh() {
        page = 1;
        getMovies();
    }

    private void getMovies() {
        if (page == 1 && !NetworkingUtils.hasInternet(getActivity())) {
            final List<Movie> movies = App.getDatabaseInterface().getMoviesByType(MOVIE_TYPE);

            adapter.setData(movies);
        } else {
            App.getMovieInteractor().getMovies(page, MOVIE_TYPE, getCallback());
        }
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
            public void onFailure(final Call<MovieList> call, final Throwable t) {
                // TODO: 03/06/2018 handle errors
            }
        };
    }

    private void showData(final List<Movie> movies) {
        for (Movie movie : movies) {
            movie.setType(MOVIE_TYPE);
        }

        if (page == 1) {
            adapter.setData(movies);
            App.getDatabaseInterface().clearMoviesByType(MOVIE_TYPE);
            App.getDatabaseInterface().addMovies(movies);
        } else {
            adapter.addData(movies);
        }

        page++;
    }
}
