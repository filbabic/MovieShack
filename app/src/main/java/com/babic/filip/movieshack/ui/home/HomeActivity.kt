package com.babic.filip.movieshack.ui.home

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem

import com.babic.filip.movieshack.R
import com.babic.filip.movieshack.listener.RefreshablePage
import com.babic.filip.movieshack.ui.popular.PopularMoviesFragment
import com.babic.filip.movieshack.ui.topRated.TopRatedMoviesFragment
import com.babic.filip.movieshack.ui.upcoming.UpcomingMoviesFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemReselectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private var refreshablePage: RefreshablePage? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavigation.setOnNavigationItemSelectedListener(this)
        bottomNavigation.setOnNavigationItemReselectedListener(this)
        bottomNavigation.selectedItemId = R.id.upcomingMovies

        showUpcoming()
    }

    private fun showUpcoming() {
        val fragment = UpcomingMoviesFragment()
        refreshablePage = fragment

        replacePage(fragment)
    }

    private fun showTopRated() {
        val fragment = TopRatedMoviesFragment()
        refreshablePage = fragment

        replacePage(fragment)
    }

    private fun showPopular() {
        val fragment = PopularMoviesFragment()
        refreshablePage = fragment

        replacePage(fragment)
    }

    private fun replacePage(fragment: Fragment) = supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .commit()

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.upcomingMovies -> showUpcoming()
            R.id.topMovies -> showTopRated()
            R.id.popularMovies -> showPopular()
            else -> Unit
        }

        return true
    }

    override fun onNavigationItemReselected(item: MenuItem) = refreshablePage?.refresh() ?: Unit
}
