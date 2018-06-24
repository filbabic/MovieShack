package com.babic.filip.movieshack.di;

import com.babic.filip.movieshack.App;
import com.babic.filip.movieshack.di.module.PresentationModule;
import com.babic.filip.movieshack.ui.popular.PopularMoviesFragment;

import dagger.Component;

@Component(modules = {PresentationModule.class})
public interface AppComponent {

    void inject(App app);

    void inject(PopularMoviesFragment popularMoviesFragment);
}


