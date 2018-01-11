package me.cristiangomez.popularmovies.movie;

import me.cristiangomez.popularmovies.BasePresenter;
import me.cristiangomez.popularmovies.BaseView;
import me.cristiangomez.popularmovies.data.pojo.Movie;

public interface MovieContract {
    interface View extends BaseView {
        void onMovie(Movie movie);
    }

    interface Presenter extends BasePresenter<View> {
    }
}
