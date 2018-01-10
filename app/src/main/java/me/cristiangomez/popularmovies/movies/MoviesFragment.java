package me.cristiangomez.popularmovies.movies;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.cristiangomez.popularmovies.BaseFragment;
import me.cristiangomez.popularmovies.R;
import me.cristiangomez.popularmovies.data.Movie;

public class MoviesFragment extends BaseFragment {
    @BindView(R.id.rv_movies)
    RecyclerView mMoviesRv;
    private Unbinder mUnbinder;

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
        // TODO Remove fake data and get data from api
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
        movies.add(new Movie("https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
        movies.add(new Movie("https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
        movies.add(new Movie("https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
        mMoviesRv.setAdapter(new MoviesAdapter(movies, getContext()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
