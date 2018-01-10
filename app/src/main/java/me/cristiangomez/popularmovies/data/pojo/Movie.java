package me.cristiangomez.popularmovies.data.pojo;

public class Movie {
    private String movieName;
    private String posterImagePath;

    public Movie(String movieName, String posterImagePath) {
        this.movieName = movieName;
        this.posterImagePath = posterImagePath;
    }

    public String getPosterImagePath() {
        return posterImagePath;
    }

    public String getMovieName() {
        return movieName;
    }
}
