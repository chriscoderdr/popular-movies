package me.cristiangomez.popularmovies.network.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import me.cristiangomez.popularmovies.data.pojo.MovieVideo;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieVideoResponse {
    private List<MovieVideo> results;

    public List<MovieVideo> getResults() {
        return results;
    }

    public void setResults(List<MovieVideo> results) {
        this.results = results;
    }
}
