package me.cristiangomez.popularmovies.data;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import me.cristiangomez.popularmovies.data.pojo.Movie;

public class MoviesRepository {
    public Observable<List<Movie>> getMovies() {
        // TODO Remove fake data and get data from api
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
        movies.add(new Movie("https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
        movies.add(new Movie("https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
        movies.add(new Movie("https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
        movies.add(new Movie("https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
        movies.add(new Movie("https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
        movies.add(new Movie("https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
        movies.add(new Movie("https://marketplace.canva.com/MACD7vUhHk0/2/0/thumbnail_large/canva-girl-under-water-movie-poster-MACD7vUhHk0.jpg"));
        return Observable.just(movies);
    }
}
