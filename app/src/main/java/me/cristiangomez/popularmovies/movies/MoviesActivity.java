package me.cristiangomez.popularmovies.movies;

import android.content.Intent;
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
import me.cristiangomez.popularmovies.data.pojo.Movie;
import me.cristiangomez.popularmovies.movie.MovieActivity;
import me.cristiangomez.popularmovies.network.ApiFactory;
import me.cristiangomez.popularmovies.util.Constants;

public class MoviesActivity extends BaseActivity implements MoviesFragment.MoviesFragmentListener {
    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private MoviesFragment mMoviesFragment;
    private MoviesPresenter mMoviesPresenter;
    private static final String PRESENTER_STATE = "PRESENTER_STATE";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        mMoviesFragment = ((MoviesFragment) getSupportFragmentManager()
                .findFragmentById(R.id.movies_fragment));
        if (savedInstanceState == null) {
            mMoviesPresenter = (MoviesPresenter) getLastCustomNonConfigurationInstance();
            if (mMoviesPresenter == null) {
                mMoviesPresenter = new MoviesPresenter(new MoviesRepository(ApiFactory.getApi()),
                        null);
            }
            mMoviesFragment.setMoviesPresenter(mMoviesPresenter);
            changeSubtitle(Constants.DEFAULT_MOVIE_SORT);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMoviesFragment = ((MoviesFragment) getSupportFragmentManager()
                .findFragmentById(R.id.movies_fragment));
        if (mMoviesFragment != null) {
            mMoviesFragment.setMoviesPresenter(mMoviesPresenter);
            mMoviesPresenter.takeView(mMoviesFragment);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mMoviesPresenter != null) {
            mMoviesPresenter.dropView();
        }
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
                mToolbar.setSubtitle(R.string.movies_subtitle_most_popular);
                break;
            case BY_HIGHEST_RATED:
                mToolbar.setSubtitle(R.string.movies_subtitle_highest_rated);
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(PRESENTER_STATE, mMoviesPresenter.getState());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        MoviesContract.PresenterState presenterState = savedInstanceState
                .getParcelable(PRESENTER_STATE);
        if (presenterState != null) {
            mMoviesPresenter = new MoviesPresenter(new MoviesRepository(ApiFactory.getApi()),
                    presenterState);
            changeSubtitle(presenterState.getMovieSortOption());
        }

    }

    @Override
    public void onMovieClick(Movie movie) {
        Intent intent = new Intent(this, MovieActivity.class);
        intent.putExtra(MovieActivity.EXTRA_MOVIE, movie);
        startActivity(intent);
    }
}
