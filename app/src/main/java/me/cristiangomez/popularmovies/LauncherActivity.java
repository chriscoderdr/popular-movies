package me.cristiangomez.popularmovies;

import android.content.Intent;
import android.os.Bundle;

import me.cristiangomez.popularmovies.movie.MovieActivity;
import me.cristiangomez.popularmovies.movies.MoviesActivity;

public class LauncherActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        startActivity(new Intent(this, MoviesActivity.class));
        startActivity(new Intent(this, MovieActivity.class));
    }
}
