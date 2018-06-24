package com.babic.filip.movieshack.networking;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.babic.filip.movieshack.api.MovieApiService;
import com.babic.filip.movieshack.interaction.MovieInteractor;
import com.babic.filip.movieshack.interaction.MovieInteractorImpl;

import javax.annotation.Nullable;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkingUtils {

    public static boolean hasInternet(@Nullable Context from) {
        if (from == null) {
            return false;
        }

        ConnectivityManager manager = (ConnectivityManager) from.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (manager != null) {
            NetworkInfo activeInfo = manager.getActiveNetworkInfo();

            return activeInfo != null && activeInfo.isConnectedOrConnecting();
        }

        return false;
    }
}
