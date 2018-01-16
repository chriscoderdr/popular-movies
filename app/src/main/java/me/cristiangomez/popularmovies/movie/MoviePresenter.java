package me.cristiangomez.popularmovies.movie;

import java.io.IOException;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.cristiangomez.popularmovies.data.MoviesRepository;
import me.cristiangomez.popularmovies.data.pojo.Movie;
import me.cristiangomez.popularmovies.data.pojo.Photo;
import me.cristiangomez.popularmovies.exceptions.InvalidApiKeyException;
import me.cristiangomez.popularmovies.network.responses.MovieImage;
import me.cristiangomez.popularmovies.util.Constants;
import me.cristiangomez.popularmovies.util.DataError;
import me.cristiangomez.popularmovies.util.Utils;

public class MoviePresenter implements MovieContract.Presenter {
    private Movie mMovie;
    private MovieContract.View mView;
    private MoviesRepository mMoviesRepository;
    private List<MovieImage> mMovieImages;

    public MoviePresenter(Movie movie, MoviesRepository mMoviesRepository) {
        mMovie = movie;
        this.mMoviesRepository = mMoviesRepository;
    }

    public MoviePresenter(MovieContract.PresenterState presenterState) {
        mMovie = presenterState.getMovie();
    }

    @Override
    public void takeView(MovieContract.View view) {
        mView = view;
        mView.onMovie(mMovie);
        if (mMovie != null && mMovie.getRuntime() == 0) {
            loadMovie();
            loadMovieImages();
            loadMovieCast();
        }
    }

    private void loadMovie() {
        if (mView != null) {
            mView.dismissError();
        }
        if (mMovie != null) {
            mMoviesRepository.getMovie(mMovie.getId())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .doOnNext(movieResponse -> {
                        if (movieResponse != null) {
                            mMovie = movieResponse;
                            if (mView != null) {
                                mView.onMovie(mMovie);
                            }
                        }
                    })
                    .doOnError(throwable -> {
                        if (throwable instanceof InvalidApiKeyException) {
                            if (mView != null) {
                                mView.onError(DataError.INVALID_API_KEY);
                            }
                        } else if (throwable instanceof IOException) {
                            mView.onError(DataError.NETWORK_NOT_AVAILABLE);
                        }
                    })
                    .onErrorReturn(throwable -> mMovie)
                    .subscribe();
        }
    }

    private void loadMovieImages() {
        if (mMovie != null) {
            mMoviesRepository.getMovieImages(mMovie.getId())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(images -> {
                        mMovieImages = images;
                        if (mView != null) {
                            mView.onMovieImages(mMovieImages);
                        }
                    })
                    .doOnError(throwable -> {

                    })
                    .onErrorReturn(throwable -> {
                        return null;
                    })
                    .subscribe();
        }
    }

    private void loadMovieCast() {
        if (mMovie != null) {
            mMoviesRepository.getMovieCast(mMovie.getId())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(casts -> {
                        if (mView != null) {
                            mView.onMovieCast(casts);
                        }
                    })
                    .doOnError(throwable -> {

                    })
                    .onErrorReturn(throwable -> {
                        return null;
                    })
                    .subscribe();
        }
    }

    @Override
    public void dropView() {
        mView = null;
    }

    @Override
    public MovieContract.PresenterState getState() {
        return new MoviePresenterState(mMovie);
    }

    @Override
    public void onMoviePosterClick() {
        if (mView != null) {
            mView.showMoviePosterViewer(new Photo(Utils.getImageUri(mMovie.getPosterPath(),
                    Constants.IMAGE_SIZE_PHOTO_VIEWER)));
        }
    }

    @Override
    public void retryMovieLoad() {
        loadMovie();
    }

    @Override
    public void onMovieImageTouch(MovieImage movieImage) {
        if (mView != null) {
            mView.showMovieImagePhotoviewer(movieImage);
        }
    }
}
