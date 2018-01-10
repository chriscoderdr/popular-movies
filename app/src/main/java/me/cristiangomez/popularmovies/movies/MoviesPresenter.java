package me.cristiangomez.popularmovies.movies;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.cristiangomez.popularmovies.data.MoviesRepository;

public class MoviesPresenter implements MoviesContract.Presenter {
    private MoviesRepository mMoviesRepository;
    private MoviesContract.View mView;

    public MoviesPresenter(MoviesRepository mMoviesRepository) {
        this.mMoviesRepository = mMoviesRepository;
    }

    @Override
    public void takeView(MoviesContract.View view) {
        this.mView = view;
        loadMovies();
    }

    @Override
    public void dropView() {

    }

    private void loadMovies() {
        mMoviesRepository.getMovies().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(movies -> mView.onMovies(movies))
                .subscribe();
    }
}
