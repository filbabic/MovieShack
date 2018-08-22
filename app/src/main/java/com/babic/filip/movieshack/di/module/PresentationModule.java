package com.babic.filip.movieshack.di.module;

import com.babic.filip.movieshack.presentation.PopularMoviesPresenter;
import com.babic.filip.movieshack.presentation.TopRatedMoviesPresenter;
import com.babic.filip.movieshack.presentation.UpcomingMoviesPresenter;
import com.babic.filip.movieshack.ui.popular.PopularMoviesContract;
import com.babic.filip.movieshack.ui.topRated.TopRatedMoviesContract;
import com.babic.filip.movieshack.ui.upcoming.UpcomingMoviesContract;

import dagger.Binds;
import dagger.Module;

@Module(includes = {InteractionModule.class})
public abstract class PresentationModule {

    @Binds
    abstract PopularMoviesContract.Presenter popularPresenter(PopularMoviesPresenter popularMoviesPresenter);

    @Binds
    abstract TopRatedMoviesContract.Presenter topRatedPresenter(TopRatedMoviesPresenter topRatedMoviesPresenter);

    @Binds
    abstract UpcomingMoviesContract.Presenter upcomingPresenter(UpcomingMoviesPresenter upcomingMoviesPresenter);
}
