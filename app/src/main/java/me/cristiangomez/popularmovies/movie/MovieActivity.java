package me.cristiangomez.popularmovies.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.cristiangomez.popularmovies.BaseActivity;
import me.cristiangomez.popularmovies.R;

public class MovieActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private MovieFragment mMovieFragment;
    private MovieContract.Presenter mMoviePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        mMovieFragment = (MovieFragment) getSupportFragmentManager()
                .findFragmentById(R.id.movie_fragment);
        mMoviePresenter = new MoviePresenter();
        mMoviePresenter.takeView(mMovieFragment);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mMoviePresenter != null) {
            mMoviePresenter.dropView();
        }
    }
}
