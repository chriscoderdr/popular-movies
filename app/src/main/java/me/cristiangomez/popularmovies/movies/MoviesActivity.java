package me.cristiangomez.popularmovies.movies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.cristiangomez.popularmovies.BaseActivity;
import me.cristiangomez.popularmovies.R;
import me.cristiangomez.popularmovies.data.MoviesRepository;

public class MoviesActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        ((MoviesFragment)getSupportFragmentManager().findFragmentById(R.id.movies_fragment))
        .setMoviesPresenter(new MoviesPresenter(new MoviesRepository()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.movies_menu, menu);
        return true;
    }
}
