package com.babic.filip.movieshack.ui.base

import android.arch.lifecycle.LiveData

interface BaseViewModel<in View, State : Any> {

    fun setView(view: View)

    fun viewState(): LiveData<State>
}