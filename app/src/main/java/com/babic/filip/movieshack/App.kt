package com.babic.filip.movieshack

import android.app.Application
import com.babic.filip.movieshack.di.module.applicationModule

import org.koin.android.ext.android.startKoin

class App : Application() {

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin(listOf(applicationModule))
    }
}



