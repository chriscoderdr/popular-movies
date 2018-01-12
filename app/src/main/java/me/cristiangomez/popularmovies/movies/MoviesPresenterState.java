package me.cristiangomez.popularmovies.movies;

import android.os.Parcel;

import java.util.List;

import me.cristiangomez.popularmovies.data.pojo.Movie;

public class MoviesPresenterState implements MoviesContract.PresenterState {
    public static final Creator<MoviesPresenterState> CREATOR = new Creator<MoviesPresenterState>() {
        @Override
        public MoviesPresenterState createFromParcel(Parcel in) {
            return new MoviesPresenterState(in);
        }

        @Override
        public MoviesPresenterState[] newArray(int size) {
            return new MoviesPresenterState[size];
        }
    };
    private List<Movie> movies;
    private MovieSortOption movieSortOption;

    public MoviesPresenterState(List<Movie> movies, MovieSortOption movieSortOption) {
        this.movies = movies;
        this.movieSortOption = movieSortOption;
    }

    protected MoviesPresenterState(Parcel in) {
        movies = in.createTypedArrayList(Movie.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(movies);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public MovieSortOption getMovieSortOption() {
        return movieSortOption;
    }

    public void setMovieSortOption(MovieSortOption movieSortOption) {
        this.movieSortOption = movieSortOption;
    }

}
