package me.cristiangomez.popularmovies.movies;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.cristiangomez.popularmovies.BaseFragment;
import me.cristiangomez.popularmovies.R;
import me.cristiangomez.popularmovies.data.pojo.Movie;

public class MoviesFragment extends BaseFragment implements MoviesContract.View {
    @BindView(R.id.rv_movies)
    RecyclerView mMoviesRv;
    private Unbinder mUnbinder;
    private MoviesPresenter mMoviesPresenter;

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

    public void setMoviesPresenter(MoviesPresenter moviesPresenter) {
        this.mMoviesPresenter = moviesPresenter;
    }

    @Override
    public void onMovies(List<Movie> movies) {
        mMoviesRv.setAdapter(new MoviesAdapter(movies, getContext()));
    }
}
