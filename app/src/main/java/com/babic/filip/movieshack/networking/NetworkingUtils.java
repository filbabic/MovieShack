package com.babic.filip.movieshack.networking;

import com.babic.filip.movieshack.api.MovieApiService;
import com.babic.filip.movieshack.interaction.MovieInteractor;
import com.babic.filip.movieshack.interaction.MovieInteractorImpl;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkingUtils {

    private static final String BASE_URL = "";
    private static MovieApiService movieApiService;

    private static String baseUrl() {
        return BASE_URL;
    }

    private static HttpLoggingInterceptor loggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    private static OkHttpClient okHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
    }

    private static GsonConverterFactory gsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    private static Retrofit retrofit(GsonConverterFactory gsonConverterFactory, OkHttpClient okHttpClient, String baseUrl) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    private static MovieApiService movieApiService() {
        if (movieApiService == null) {
            movieApiService = retrofit(gsonConverterFactory(), okHttpClient(loggingInterceptor()), baseUrl()).create(MovieApiService.class);
        }
        return movieApiService;
    }

    public static MovieInteractor movieInteractor() {
        return new MovieInteractorImpl(movieApiService());
    }
}
