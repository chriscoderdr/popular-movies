package me.cristiangomez.popularmovies.movie;

import java.util.List;

import me.cristiangomez.popularmovies.BasePresenter;
import me.cristiangomez.popularmovies.BasePresenterState;
import me.cristiangomez.popularmovies.BaseView;
import me.cristiangomez.popularmovies.data.pojo.Cast;
import me.cristiangomez.popularmovies.data.pojo.Movie;
import me.cristiangomez.popularmovies.data.pojo.MovieVideo;
import me.cristiangomez.popularmovies.data.pojo.Photo;
import me.cristiangomez.popularmovies.network.responses.MovieImage;
import me.cristiangomez.popularmovies.util.DataError;

public interface MovieContract {
    interface View extends BaseView {
        void onMovie(Movie movie);

        void showMoviePosterViewer(Photo photo);

        void onError(DataError dataError);

        void dismissError();

        void onMovieImages(List<MovieImage> mMovieImages);

        void showMovieImagePhotoViewer(MovieImage movieImage);

        void onMovieCast(List<Cast> casts);

        void onMovieVideos(List<MovieVideo> movieVideos);

        void onMovieRecommendations(List<Movie> movies);
    }

    interface PresenterState extends BasePresenterState {
        Movie getMovie();
    }

    interface Presenter extends BasePresenter<View, PresenterState> {
        PresenterState getState();

        void onMoviePosterClick();

        void retryMovieLoad();

        void onMovieImageTouch(MovieImage movieImage);
    }
}
