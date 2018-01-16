package me.cristiangomez.popularmovies.network.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import me.cristiangomez.popularmovies.data.pojo.MovieReview;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieReviewResponse {
    private List<MovieReview> results;

    public List<MovieReview> getResults() {
        return results;
    }

    public void setResults(List<MovieReview> results) {
        this.results = results;
    }
}
