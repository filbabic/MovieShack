package com.babic.filip.movieshack.networking

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

import com.babic.filip.movieshack.api.MovieApiService
import com.babic.filip.movieshack.interaction.MovieInteractor
import com.babic.filip.movieshack.interaction.MovieInteractorImpl

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun hasInternet(from: Context?): Boolean = from?.let {
    val manager = from.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeInfo = manager.activeNetworkInfo

    activeInfo != null && activeInfo.isConnectedOrConnecting
} ?: false