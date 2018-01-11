package me.cristiangomez.popularmovies.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.cristiangomez.popularmovies.BuildConfig;
import me.cristiangomez.popularmovies.data.pojo.Movie;
import me.cristiangomez.popularmovies.data.pojo.MoviesResponse;
import me.cristiangomez.popularmovies.network.TheMovieDbApi;
import retrofit2.Response;

public class MoviesRepository {
    private TheMovieDbApi theMovieDbApi;

    public MoviesRepository(TheMovieDbApi theMovieDbApi) {
        this.theMovieDbApi = theMovieDbApi;
    }

    public Observable<List<Movie>> getMovies() {
        return theMovieDbApi.topRatedMovies(BuildConfig.API_KEY, null, 1)
                .map((Response<MoviesResponse> listResponse) -> {
                    if (listResponse.isSuccessful() && listResponse.body() != null) {
                        return listResponse.body().getResults();
                    }
                    return new ArrayList<>();
                });
//        // TODO Remove fake data and get data from api
//        List<Movie> movies = new ArrayList<>();
//        movies.add(new Movie("TestName", "https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
//        movies.add(new Movie("TestName", "https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
//        movies.add(new Movie("TestName", "https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
//        movies.add(new Movie("TestName", "https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
//        movies.add(new Movie("TestName", "https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
//        movies.add(new Movie("TestName", "https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
//        movies.add(new Movie("TestName", "https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
//        movies.add(new Movie("TestName", "https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
//
//        Random random = new Random();
//        int randomNum = random.nextInt(100);
//        if (randomNum <= 70) {
//            return Observable.just(movies).delay(5, TimeUnit.SECONDS);
//        } else {
//            return Observable
//                    .error(new NetworkNotAvailableException());
//        }
    }
}
