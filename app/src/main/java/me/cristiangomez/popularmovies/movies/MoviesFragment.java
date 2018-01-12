package me.cristiangomez.popularmovies.movies;

import android.content.Context;
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
    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.rv_movies)
    RecyclerView mMoviesRv;
    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.pb_movies)
    ProgressBar mMoviesPb;
    private Unbinder mUnbinder;
    private MoviesPresenter mMoviesPresenter;
    private Snackbar mErrorSnb;
    private static final String SAVE_INSTANCE_MOVIES_RV_POSITION = "MOVIES_RV_POSITION";
    private Parcelable mSavedRecyclerviewState;
    private boolean mShouldRestoreState;
    private MoviesFragmentListener mListener;

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
        if (savedInstanceState != null) {
            mSavedRecyclerviewState = savedInstanceState.getParcelable(SAVE_INSTANCE_MOVIES_RV_POSITION);
            mShouldRestoreState = true;
        }
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),
                2, LinearLayoutManager.VERTICAL, false);
        mMoviesRv.setLayoutManager(layoutManager);
        MoviesAdapter moviesAdapter = new MoviesAdapter(null, getContext());
        moviesAdapter.setListener(mMoviesPresenter);
        mMoviesRv.setAdapter(moviesAdapter);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            mSavedRecyclerviewState = savedInstanceState.getParcelable(SAVE_INSTANCE_MOVIES_RV_POSITION);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (MoviesFragmentListener) context;
        } catch (ClassCastException e) {
            throw new RuntimeException(String.format("%s must implement %s",
                    context.getClass().getCanonicalName(),
                    MoviesFragmentListener.class.getCanonicalName()));
        }
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

    public void setMoviesPresenter(MoviesPresenter moviesPresenter) {
        this.mMoviesPresenter = moviesPresenter;
    }

    @Override
    public void onMovies(List<Movie> movies) {
        MoviesAdapter moviesAdapter = new MoviesAdapter(movies, getContext());
        moviesAdapter.setListener(mMoviesPresenter);
        mMoviesRv.setAdapter(moviesAdapter);
        showMovieList();
        if (mShouldRestoreState) {
            mShouldRestoreState = false;
            mMoviesRv.getLayoutManager().onRestoreInstanceState(mSavedRecyclerviewState);
        }
    }

    public void onSortChanged(MovieSortOption movieSortOption) {
        if (mMoviesPresenter != null) {
            mMoviesPresenter.onSortChanged(movieSortOption);
        }
    }

    public void showLoading() {
        dismissError();
        mMoviesPb.setVisibility(View.VISIBLE);
        mMoviesRv.setVisibility(View.INVISIBLE);
    }

    private void showMovieList() {
        dismissError();
        mMoviesRv.setVisibility(View.VISIBLE);
        mMoviesPb.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onError(DataError dataError) {
        dismissError();
        String errorString = null;
        switch (dataError) {
            case NETWORK_NOT_AVAILABLE:
                errorString = getString(R.string.error_network_not_available);
                break;
            case INVALID_API_KEY:
                errorString = getString(R.string.error_invalid_api_key);
        }
        mMoviesPb.setVisibility(View.INVISIBLE);
        mErrorSnb = Snackbar.make(mMoviesRv, errorString,
                Snackbar.LENGTH_INDEFINITE);
        mErrorSnb.setAction(R.string.error_network_not_available_action_retry,
                v -> {
                    if (mMoviesPresenter != null) {
                        mMoviesPresenter.retryMoviesLoad();
                    }
                });
        mErrorSnb.show();
    }

    public void dismissError() {
        if (mErrorSnb != null) {
            mErrorSnb.dismiss();
            mErrorSnb = null;
        }
    }

    @Override
    public void onMovieClick(Movie movie) {
        if (mListener != null) {
            mListener.onMovieClick(movie);
        }
    }

    interface MoviesFragmentListener {
        void onMovieClick(Movie movie);
    }
}
