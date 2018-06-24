package com.babic.filip.movieshack.di.module;

import com.babic.filip.movieshack.api.MovieApiService;
import com.babic.filip.movieshack.interaction.MovieInteractor;
import com.babic.filip.movieshack.interaction.MovieInteractorImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@Singleton
public class NetworkingModule {

    private static final String BASE_URL = "http://api.themoviedb.org/";

    @Provides
    public String baseUrl() {
        return BASE_URL;
    }

    @Provides
    public HttpLoggingInterceptor loggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    public OkHttpClient okHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
    }

    @Provides
    public GsonConverterFactory gsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    public Retrofit retrofit(final GsonConverterFactory gsonConverterFactory,
                             final OkHttpClient okHttpClient,
                             final String baseUrl) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @Provides
    public MovieApiService movieApiService(final Retrofit retrofit) {
        return retrofit.create(MovieApiService.class);
    }
}


