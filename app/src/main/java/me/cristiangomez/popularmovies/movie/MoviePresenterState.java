package me.cristiangomez.popularmovies.movie;

import android.os.Parcel;
import android.os.Parcelable;

import me.cristiangomez.popularmovies.data.pojo.Movie;

public class MoviePresenterState implements MovieContract.PresenterState {
    private Movie movie;

    protected MoviePresenterState(Parcel in) {
        movie = in.readParcelable(Movie.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(movie, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MoviePresenterState> CREATOR = new Creator<MoviePresenterState>() {
        @Override
        public MoviePresenterState createFromParcel(Parcel in) {
            return new MoviePresenterState(in);
        }

        @Override
        public MoviePresenterState[] newArray(int size) {
            return new MoviePresenterState[size];
        }
    };

    @Override
    public Movie getMovie() {
        return movie;
    }
}
