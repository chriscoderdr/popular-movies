package me.cristiangomez.popularmovies.network.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import me.cristiangomez.popularmovies.data.pojo.Cast;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CastResponse {
    private List<Cast> cast;

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }
}
