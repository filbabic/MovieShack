package com.babic.filip.movieshack.di.module

import com.babic.filip.movieshack.App
import com.babic.filip.movieshack.api.MovieApiService
import com.babic.filip.movieshack.database.DatabaseImpl
import com.babic.filip.movieshack.database.DatabaseInterface
import com.babic.filip.movieshack.database.dao.DaoProvider
import com.babic.filip.movieshack.interaction.MovieInteractor
import com.babic.filip.movieshack.interaction.MovieInteractorImpl
import com.babic.filip.movieshack.viewModel.PopularMoviesViewModel
import com.babic.filip.movieshack.viewModel.TopRatedMoviesViewModel
import com.babic.filip.movieshack.viewModel.UpcomingMoviesViewModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "http://api.themoviedb.org/"

val applicationModule = applicationContext {

    //application related
    bean { App.instance }
    bean { DaoProvider.instance }
    bean { get<DaoProvider>().movieDao() }
    bean { DatabaseImpl(get()) as DatabaseInterface }

    //networking
    bean { BASE_URL }
    bean { HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY } as Interceptor }
    bean { OkHttpClient.Builder().addInterceptor(get()).build() }
    bean { GsonConverterFactory.create() as Converter.Factory }
    bean {
        Retrofit.Builder()
                .baseUrl(get<String>())
                .client(get())
                .addConverterFactory(get())
                .build()

    }
    bean { get<Retrofit>().create(MovieApiService::class.java) }

    //interaction
    bean { MovieInteractorImpl(get()) as MovieInteractor }

    //presentation
    viewModel { PopularMoviesViewModel(get(), get()) }
    viewModel { TopRatedMoviesViewModel(get(), get()) }
    viewModel { UpcomingMoviesViewModel(get(), get()) }
}