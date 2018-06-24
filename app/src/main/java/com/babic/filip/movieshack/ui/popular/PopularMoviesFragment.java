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
import android.widget.Toast;

import com.babic.filip.movieshack.App;
import com.babic.filip.movieshack.R;
import com.babic.filip.movieshack.listener.LastItemReachedListener;
import com.babic.filip.movieshack.listener.RefreshablePage;
import com.babic.filip.movieshack.model.Movie;
import com.babic.filip.movieshack.networking.NetworkingUtils;
import com.babic.filip.movieshack.ui.list.MovieAdapter;

import java.util.List;

import javax.inject.Inject;

public class PopularMoviesFragment extends Fragment implements RefreshablePage, PopularMoviesContract.View {

    private final MovieAdapter adapter = new MovieAdapter(R.layout.item_movie_popular);

    @Inject
    PopularMoviesContract.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater,
                             @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi(view);
        App.component().inject(this);
        presenter.setView(this);

        presenter.getMovies(NetworkingUtils.hasInternet(getActivity()));
    }

    private void initUi(View view) {
        RecyclerView movies = view.findViewById(R.id.movies);
        movies.setItemAnimator(new DefaultItemAnimator());
        movies.setLayoutManager(new LinearLayoutManager(getActivity()));
        movies.setAdapter(adapter);
        movies.addOnScrollListener(new LastItemReachedListener(() -> presenter.getMovies(NetworkingUtils.hasInternet(getActivity()))));
    }

    @Override
    public void refresh() {
        presenter.refresh(NetworkingUtils.hasInternet(getActivity()));
    }

    @Override
    public void showMovies(final List<Movie> movies) {
        adapter.setData(movies);
    }

    @Override
    public void addMoreMovies(final List<Movie> movies) {
        adapter.addData(movies);
    }

    @Override
    public void showServerError() {
        Toast.makeText(getActivity(), getString(R.string.server_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNetworkError() {
        Toast.makeText(getActivity(), getString(R.string.network_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showGeneralError() {
        Toast.makeText(getActivity(), getString(R.string.general_error), Toast.LENGTH_SHORT).show();
    }
}
