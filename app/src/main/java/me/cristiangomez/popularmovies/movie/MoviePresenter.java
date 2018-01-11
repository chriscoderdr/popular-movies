package me.cristiangomez.popularmovies.movie;

import me.cristiangomez.popularmovies.data.pojo.Movie;

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
}
