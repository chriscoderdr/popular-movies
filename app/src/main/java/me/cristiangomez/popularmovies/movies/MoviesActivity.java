package me.cristiangomez.popularmovies.movies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.cristiangomez.popularmovies.BaseActivity;
import me.cristiangomez.popularmovies.R;
import me.cristiangomez.popularmovies.data.MoviesRepository;
import me.cristiangomez.popularmovies.util.Constants;

public class MoviesActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    MoviesFragment mMoviesFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        mMoviesFragment = ((MoviesFragment) getSupportFragmentManager()
                .findFragmentById(R.id.movies_fragment));
        mMoviesFragment.setMoviesPresenter(new MoviesPresenter(new MoviesRepository()));
        changeSubtitle(Constants.DEFAULT_MOVIE_SORT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.movies_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sort_highest_rated:
                mMoviesFragment.onSortChanged(MovieSortOption.BY_HIGHEST_RATED);
                changeSubtitle(MovieSortOption.BY_HIGHEST_RATED);
                return true;
            case R.id.action_sort_most_popular:
                mMoviesFragment.onSortChanged(MovieSortOption.BY_MOST_POPULAR);
                changeSubtitle(MovieSortOption.BY_MOST_POPULAR);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void changeSubtitle(MovieSortOption movieSortOption) {
        switch (movieSortOption) {
            case BY_MOST_POPULAR:
                mToolbar.setSubtitle(R.string.movies_substitle_most_popular);
                break;
            case BY_HIGHEST_RATED:
                mToolbar.setSubtitle(R.string.movies_substitle_highest_rated);
                break;
        }
    }
}
