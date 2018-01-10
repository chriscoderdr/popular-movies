package me.cristiangomez.popularmovies.movies;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.cristiangomez.popularmovies.BaseActivity;
import me.cristiangomez.popularmovies.R;
import me.cristiangomez.popularmovies.data.MoviesRepository;

public class MoviesActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        ((MoviesFragment)getSupportFragmentManager().findFragmentById(R.id.movies_fragment))
        .setMoviesPresenter(new MoviesPresenter(new MoviesRepository()));
    }
}
