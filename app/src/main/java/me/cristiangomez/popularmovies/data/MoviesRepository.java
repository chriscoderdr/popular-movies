package me.cristiangomez.popularmovies.data;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import me.cristiangomez.popularmovies.BuildConfig;
import me.cristiangomez.popularmovies.data.pojo.Movie;
import me.cristiangomez.popularmovies.data.pojo.MoviesResponse;
import me.cristiangomez.popularmovies.exceptions.InvalidApiKeyException;
import me.cristiangomez.popularmovies.movies.MovieSortOption;
import me.cristiangomez.popularmovies.network.TheMovieDbApi;
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
}
