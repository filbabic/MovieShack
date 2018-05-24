package com.babic.filip.movieshack.interaction;

import com.babic.filip.movieshack.api.MovieApiService;

public class MovieInteractorImpl implements MovieInteractor {

    private final MovieApiService movieApiService;

    public MovieInteractorImpl(MovieApiService movieApiService) {
        this.movieApiService = movieApiService;
    }
}
