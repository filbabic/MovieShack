package com.babic.filip.movieshack.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.babic.filip.movieshack.R;
import com.babic.filip.movieshack.listener.RefreshablePage;
import com.babic.filip.movieshack.ui.popular.PopularMoviesFragment;
import com.babic.filip.movieshack.ui.topRated.TopRatedMoviesFragment;
import com.babic.filip.movieshack.ui.upcoming.UpcomingMoviesFragment;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemReselectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private RefreshablePage refreshablePage = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);

        bottomNavigation.setOnNavigationItemSelectedListener(this);
        bottomNavigation.setOnNavigationItemReselectedListener(this);
    }

    private void showUpcoming() {
        UpcomingMoviesFragment fragment = new UpcomingMoviesFragment();
        refreshablePage = fragment;

        replacePage(fragment);
    }

    private void showTopRated() {
        TopRatedMoviesFragment fragment = new TopRatedMoviesFragment();
        refreshablePage = fragment;

        replacePage(fragment);
    }

    private void showPopular() {
        PopularMoviesFragment fragment = new PopularMoviesFragment();
        refreshablePage = fragment;

        replacePage(fragment);
    }

    private void replacePage(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameContainer, fragment)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.upcomingMovies: {
                showUpcoming();
                break;
            }

            case R.id.topMovies: {
                showTopRated();
                break;
            }

            case R.id.popularMovies: {
                showPopular();
                break;
            }

            default:
                break;
        }

        return true;
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {
        if (refreshablePage != null) {
            refreshablePage.refresh();
        }
    }
}
