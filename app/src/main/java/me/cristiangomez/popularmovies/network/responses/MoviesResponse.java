package me.cristiangomez.popularmovies.network.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import me.cristiangomez.popularmovies.data.pojo.Movie;

@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MoviesResponse {
    @JsonProperty("status_code")
    private int statusCode;
    private boolean success;
    private List<Movie> results;

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public List<Movie> getResults() {
        return results;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
