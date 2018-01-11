package me.cristiangomez.popularmovies.movies;

import java.util.List;

import me.cristiangomez.popularmovies.BasePresenter;
import me.cristiangomez.popularmovies.BaseView;
import me.cristiangomez.popularmovies.data.pojo.Movie;
import me.cristiangomez.popularmovies.util.DataError;

public interface MoviesContract {
    interface View extends BaseView {
        void onMovies(List<Movie> movies);

        void onError(DataError networkNotAvailable);
    }

    interface Presenter extends BasePresenter<View> {
        void onSortChanged(MovieSortOption movieSortOption);
    }
}
