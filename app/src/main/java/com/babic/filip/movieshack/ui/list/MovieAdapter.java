package com.babic.filip.movieshack.ui.list;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.babic.filip.movieshack.R;
import com.babic.filip.movieshack.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieHolder> {

    @LayoutRes
    private final int movieType; //this will be our layout for holders

    private final List<Movie> movies = new ArrayList<>();

    public MovieAdapter(final int movieType) {
        this.movieType = movieType;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(movieType, parent, false);

        //todo add logic for each movie type
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieHolder holder, final int position) {
        holder.displayItem(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
