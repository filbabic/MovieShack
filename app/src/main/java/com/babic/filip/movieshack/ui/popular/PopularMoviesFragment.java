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

import com.babic.filip.movieshack.R;
import com.babic.filip.movieshack.listener.RefreshablePage;
import com.babic.filip.movieshack.ui.list.MovieAdapter;

public class PopularMoviesFragment extends Fragment implements RefreshablePage {

    private MovieAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi(view);
    }

    private void initUi(View view) {
        adapter = new MovieAdapter(R.layout.item_movie_popular);

        RecyclerView movies = view.findViewById(R.id.movies);
        movies.setItemAnimator(new DefaultItemAnimator());
        movies.setLayoutManager(new LinearLayoutManager(getActivity()));
        movies.setAdapter(adapter);
    }

    @Override
    public void refresh() {

    }
}
