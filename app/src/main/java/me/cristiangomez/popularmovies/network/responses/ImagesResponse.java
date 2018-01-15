package me.cristiangomez.popularmovies.network.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImagesResponse {
    private int id;
    private List<MovieImage> backdrops;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MovieImage> getBackdrops() {
        return backdrops;
    }

    public void setBackdrops(List<MovieImage> backdrops) {
        this.backdrops = backdrops;
    }
}
