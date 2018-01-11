package me.cristiangomez.popularmovies.movie;

import android.os.Parcelable;

import me.cristiangomez.popularmovies.BasePresenter;
import me.cristiangomez.popularmovies.BasePresenterState;
import me.cristiangomez.popularmovies.BaseView;
import me.cristiangomez.popularmovies.data.pojo.Movie;

public interface MovieContract {
    interface View extends BaseView {
        void onMovie(Movie movie);
    }

    interface PresenterState extends BasePresenterState {
        Movie getMovie();
    }

    interface Presenter extends BasePresenter<View, PresenterState> {
        PresenterState getState();
    }
}
