package me.cristiangomez.popularmovies.movie;

import android.net.Uri;

import me.cristiangomez.popularmovies.data.pojo.Movie;
import me.cristiangomez.popularmovies.data.pojo.Photo;

public class MoviePresenter implements MovieContract.Presenter {
    private Movie mMovie;
    private MovieContract.View mView;

    public MoviePresenter(Movie movie) {
        mMovie = movie;
    }

    public MoviePresenter(MovieContract.PresenterState presenterState) {
        mMovie = presenterState.getMovie();
    }

    @Override
    public void takeView(MovieContract.View view) {
        mView = view;
        mView.onMovie(mMovie);
    }

    @Override
    public void dropView() {
        mView = null;
    }

    @Override
    public MovieContract.PresenterState getState() {
        return null;
    }

    @Override
    public void onMoviePosterClick() {
        if (mView != null) {
            mView.showMoviePosterViewer(new Photo(Uri.parse(mMovie.getPosterPath())));
        }
    }
}
