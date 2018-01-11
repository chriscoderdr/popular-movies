package me.cristiangomez.popularmovies.movies;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.cristiangomez.popularmovies.data.MoviesRepository;
import me.cristiangomez.popularmovies.util.Constants;

public class MoviesPresenter implements MoviesContract.Presenter {
    private MoviesRepository mMoviesRepository;
    private MoviesContract.View mView;

    public MoviesPresenter(MoviesRepository mMoviesRepository) {
        this.mMoviesRepository = mMoviesRepository;
    }

    @Override
    public void takeView(MoviesContract.View view) {
        this.mView = view;
        loadMovies(Constants.DEFAULT_MOVIE_SORT);
    }

    @Override
    public void dropView() {

    }

    @Override
    public void onSortChanged(MovieSortOption movieSortOption) {
        loadMovies(movieSortOption);
    }

    private void loadMovies(MovieSortOption sortOption) {
        mMoviesRepository.getMovies().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(movies -> mView.onMovies(movies))
                .subscribe();
    }
}
