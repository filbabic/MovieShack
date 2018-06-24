package com.babic.filip.movieshack.di.module;

import com.babic.filip.movieshack.interaction.MovieInteractor;
import com.babic.filip.movieshack.interaction.MovieInteractorImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module(includes = {NetworkingModule.class, AppModule.class})
@Singleton
public abstract class InteractionModule {

    @Binds
    abstract MovieInteractor movieInteractor(MovieInteractorImpl interactor);
}
