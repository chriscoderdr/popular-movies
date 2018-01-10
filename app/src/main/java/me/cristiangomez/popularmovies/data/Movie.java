package me.cristiangomez.popularmovies.data;

public class Movie {
    private String posterImagePath;

    public Movie(String posterImagePath) {
        this.posterImagePath = posterImagePath;
    }

    public String getPosterImagePath() {
        return posterImagePath;
    }
}
