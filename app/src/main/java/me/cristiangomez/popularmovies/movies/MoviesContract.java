package me.cristiangomez.popularmovies.movies;

import java.util.List;

import me.cristiangomez.popularmovies.BasePresenter;
import me.cristiangomez.popularmovies.BaseView;
import me.cristiangomez.popularmovies.data.pojo.Movie;

public interface MoviesContract {
    interface View extends BaseView {
        void onMovies(List<Movie> movies);
    }

    interface Presenter extends BasePresenter<View> {

    }
}
