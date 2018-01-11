package me.cristiangomez.popularmovies.data.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MoviesResponse {
    private List<Movie> results;

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public List<Movie> getResults() {
        return results;
    }
}
