package me.cristiangomez.popularmovies.movies;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.cristiangomez.popularmovies.BaseActivity;
import me.cristiangomez.popularmovies.R;

public class MoviesActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
    }
}
