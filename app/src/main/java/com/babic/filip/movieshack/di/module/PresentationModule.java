package com.babic.filip.movieshack.di.module;

import com.babic.filip.movieshack.presentation.PopularMoviesPresenter;
import com.babic.filip.movieshack.ui.popular.PopularMoviesContract;

import dagger.Binds;
import dagger.Module;

@Module(includes = {InteractionModule.class})
public abstract class PresentationModule {

    @Binds
    abstract PopularMoviesContract.Presenter popularPresenter(PopularMoviesPresenter popularMoviesPresenter);
}
