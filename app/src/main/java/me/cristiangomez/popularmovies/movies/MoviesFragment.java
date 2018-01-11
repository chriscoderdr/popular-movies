package me.cristiangomez.popularmovies.movies;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.cristiangomez.popularmovies.BaseFragment;
import me.cristiangomez.popularmovies.R;
import me.cristiangomez.popularmovies.data.pojo.Movie;
import me.cristiangomez.popularmovies.util.DataError;

public class MoviesFragment extends BaseFragment implements MoviesContract.View {
    @BindView(R.id.rv_movies)
    RecyclerView mMoviesRv;
    @BindView(R.id.pb_movies)
    ProgressBar mMoviesPb;
    private Unbinder mUnbinder;
    private MoviesPresenter mMoviesPresenter;
    private Snackbar mErrorSnb;
    private static final String SAVE_INSTANCE_MOVIES_RV_POSITION = "MOVIES_RV_POSITION";
    private Parcelable mSavedRecyclerviewState;
    private boolean mShouldRestoreState;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMoviesRv.setLayoutManager(new GridLayoutManager(getContext(),
                2, LinearLayoutManager.VERTICAL, false));
        mMoviesRv.setAdapter(new MoviesAdapter(null, getContext()));
    }

    @Override
    public void onStart() {
        super.onStart();
        mMoviesPresenter.takeView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(SAVE_INSTANCE_MOVIES_RV_POSITION, mMoviesRv.getLayoutManager()
        .onSaveInstanceState());
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            mSavedRecyclerviewState = savedInstanceState.getParcelable(SAVE_INSTANCE_MOVIES_RV_POSITION);
            mShouldRestoreState = true;
        }
    }

    public void setMoviesPresenter(MoviesPresenter moviesPresenter) {
        this.mMoviesPresenter = moviesPresenter;
    }

    @Override
    public void onMovies(List<Movie> movies) {
        showMovieList();
        if (mShouldRestoreState) {
            mShouldRestoreState = false;
            mMoviesRv.getLayoutManager().onRestoreInstanceState(mSavedRecyclerviewState);
        }
        mMoviesRv.setAdapter(new MoviesAdapter(movies, getContext()));
    }

    public void onSortChanged(MovieSortOption movieSortOption) {
        mMoviesPresenter.onSortChanged(movieSortOption);
    }

    public void showLoading() {
        dismissError();
        mMoviesPb.setVisibility(View.VISIBLE);
        mMoviesRv.setVisibility(View.INVISIBLE);
    }

    public void showMovieList() {
        dismissError();
        mMoviesRv.setVisibility(View.VISIBLE);
        mMoviesPb.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onError(DataError dataError) {
        dismissError();
        mMoviesPb.setVisibility(View.INVISIBLE);
        mErrorSnb = Snackbar.make(mMoviesRv, R.string.error_network_not_available,
                Snackbar.LENGTH_INDEFINITE);
        mErrorSnb.setAction(R.string.error_network_not_available_action_retry,
                v -> {
            mMoviesPresenter.retryMoviesLoad();
                });
        mErrorSnb.show();
    }

    public void dismissError() {
        if (mErrorSnb != null) {
            mErrorSnb.dismiss();
            mErrorSnb = null;
        }
    }
}
