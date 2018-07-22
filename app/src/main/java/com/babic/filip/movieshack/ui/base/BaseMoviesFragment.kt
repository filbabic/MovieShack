package com.babic.filip.movieshack.ui.base

import android.support.v4.app.Fragment
import android.widget.Toast
import com.babic.filip.movieshack.R

open class BaseMoviesFragment : Fragment(), BaseMoviesView {

    override fun showServerError() = Toast.makeText(activity, getString(R.string.server_error), Toast.LENGTH_SHORT).show()
    override fun showNetworkError() = Toast.makeText(activity, getString(R.string.network_error), Toast.LENGTH_SHORT).show()
    override fun showGeneralError() = Toast.makeText(activity, getString(R.string.general_error), Toast.LENGTH_SHORT).show()
}