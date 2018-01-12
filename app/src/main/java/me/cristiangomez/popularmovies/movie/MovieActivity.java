package me.cristiangomez.popularmovies.movie;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.cristiangomez.popularmovies.BaseActivity;
import me.cristiangomez.popularmovies.R;
import me.cristiangomez.popularmovies.data.pojo.Movie;

public class MovieActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private MovieContract.Presenter mMoviePresenter;
    public static final String EXTRA_MOVIE = "EXTRA_MOVIE";
    private static final String PRESENTER_STATE = "PRESENTER_STATE";
    private MovieFragment mMovieFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mMovieFragment = (MovieFragment) getSupportFragmentManager()
                .findFragmentById(R.id.movie_fragment);
        if (savedInstanceState == null) {
            mMoviePresenter = (MoviePresenter) getLastCustomNonConfigurationInstance();
            if (mMoviePresenter == null) {
                Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
                mMoviePresenter = new MoviePresenter(movie);
            }
            mMovieFragment.setPresenter(mMoviePresenter);
            mMoviePresenter.takeView(mMovieFragment);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMovieFragment = (MovieFragment) getSupportFragmentManager()
                .findFragmentById(R.id.movie_fragment);
        if (mMoviePresenter != null) {
            mMoviePresenter.takeView(mMovieFragment);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mMoviePresenter != null) {
            mMoviePresenter.dropView();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(PRESENTER_STATE, mMoviePresenter.getState());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        MovieContract.PresenterState presenterState = savedInstanceState
                .getParcelable(PRESENTER_STATE);
        if (mMovieFragment != null && presenterState != null) {
            mMoviePresenter = new MoviePresenter(presenterState);
            mMovieFragment.setPresenter(mMoviePresenter);
        }
    }
}
