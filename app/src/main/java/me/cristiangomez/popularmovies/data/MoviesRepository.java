package me.cristiangomez.popularmovies.data;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import me.cristiangomez.popularmovies.BuildConfig;
import me.cristiangomez.popularmovies.data.pojo.Cast;
import me.cristiangomez.popularmovies.data.pojo.Movie;
import me.cristiangomez.popularmovies.data.pojo.MovieReview;
import me.cristiangomez.popularmovies.data.pojo.MovieVideo;
import me.cristiangomez.popularmovies.exceptions.InvalidApiKeyException;
import me.cristiangomez.popularmovies.movies.MovieSortOption;
import me.cristiangomez.popularmovies.network.TheMovieDbApi;
import me.cristiangomez.popularmovies.network.responses.MovieImage;
import me.cristiangomez.popularmovies.network.responses.MoviesResponse;
import retrofit2.Response;

public class MoviesRepository {
    private final TheMovieDbApi theMovieDbApi;

    public MoviesRepository(TheMovieDbApi theMovieDbApi) {
        this.theMovieDbApi = theMovieDbApi;
    }

    public Observable<List<Movie>> getMovies(@NonNull MovieSortOption moviesSortOption) {
        Observable<Response<MoviesResponse>> moviesObservable = null;
        switch (moviesSortOption) {
            case BY_MOST_POPULAR:
                moviesObservable = theMovieDbApi.popularMovies(BuildConfig.API_KEY, null, 1);
                break;
            case BY_HIGHEST_RATED:
                moviesObservable = theMovieDbApi.topRatedMovies(BuildConfig.API_KEY, null, 1);
                break;
        }
        return moviesObservable
                .map((Response<MoviesResponse> listResponse) -> {
                    if (listResponse.isSuccessful() && listResponse.body() != null) {
                        return listResponse.body().getResults();
                    } else if (!listResponse.isSuccessful() && listResponse.code() == 401) {
                        throw new InvalidApiKeyException();
                    }
                    return new ArrayList<>();
                });
    }


    public Observable<Movie> getMovie(int id) {
        return theMovieDbApi.getMovie(id, BuildConfig.API_KEY, null)
                .map(movieResponse -> {
                    if (movieResponse.isSuccessful() && movieResponse.body() != null) {
                        return movieResponse.body();
                    } else if (!movieResponse.isSuccessful() && movieResponse.code() == 401) {
                        throw new InvalidApiKeyException();
                    }
                    return null;
                });
    }

    public Observable<List<MovieImage>> getMovieImages(int id) {
        return theMovieDbApi.getMoviePhotos(id, BuildConfig.API_KEY, null)
                .map(imagesResponseResponse -> {
                    if (imagesResponseResponse.isSuccessful() && imagesResponseResponse.body() != null) {
                        return imagesResponseResponse.body().getBackdrops();
                    }
                    return null;
                });
    }

    public Observable<List<Cast>> getMovieCast(int id) {
        return theMovieDbApi.getMovieCast(id, BuildConfig.API_KEY)
                .map(castResponseResponse -> {
                    if (castResponseResponse.isSuccessful() && castResponseResponse.body() != null) {
                        return castResponseResponse.body().getCast();
                    }
                    return null;
                });
    }

    public Observable<List<MovieVideo>> getMovieVideos(int id) {
        return theMovieDbApi.getMovieVideos(id, BuildConfig.API_KEY)
                .map(movieVideoResponseResponse -> {
                    if (movieVideoResponseResponse.isSuccessful() && movieVideoResponseResponse.body() != null) {
                        return movieVideoResponseResponse.body().getResults();
                    }
                    return null;
                });
    }

    public Observable<List<Movie>> getMovieRecommendations(int id) {
        return theMovieDbApi.getMovieRecommendations(id, BuildConfig.API_KEY)
                .map(moviesResponseResponse -> {
                    if (moviesResponseResponse.isSuccessful() && moviesResponseResponse.body() != null) {
                        return moviesResponseResponse.body().getResults();
                    }
                    return null;
                });
    }

    public Observable<List<MovieReview>> getMovieReviews(int id) {
        return theMovieDbApi.getMovieReviews(id, BuildConfig.API_KEY)
                .map(movieReviewResponseResponse -> {
                    if (movieReviewResponseResponse != null && movieReviewResponseResponse.body() != null) {
                        return movieReviewResponseResponse.body().getResults();
                    }
                    return null;
                });
    }
}
