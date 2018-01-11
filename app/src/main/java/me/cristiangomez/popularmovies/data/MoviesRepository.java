package me.cristiangomez.popularmovies.data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import me.cristiangomez.popularmovies.data.pojo.Movie;
import me.cristiangomez.popularmovies.exception.NetworkNotAvailableException;

public class MoviesRepository {
    public Observable<List<Movie>> getMovies() {
        // TODO Remove fake data and get data from api
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("TestName", "https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
        movies.add(new Movie("TestName", "https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
        movies.add(new Movie("TestName", "https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
        movies.add(new Movie("TestName", "https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
        movies.add(new Movie("TestName", "https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
        movies.add(new Movie("TestName", "https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
        movies.add(new Movie("TestName", "https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
        movies.add(new Movie("TestName", "https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
//        return Observable.just(movies).delay(5, TimeUnit.SECONDS);
        return Observable.error(new NetworkNotAvailableException());
    }
}
