package me.cristiangomez.popularmovies.network;

import java.util.List;

import io.reactivex.Observable;
import me.cristiangomez.popularmovies.data.pojo.Movie;
import me.cristiangomez.popularmovies.data.pojo.MoviesResponse;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheMovieDbApi {
    @GET("/3/movie/top_rated")
    Observable<Response<MoviesResponse>> topRatedMovies(@Query("api_key") String apiKey,
                                                        @Query("language") String language,
                                                        @Query("page") int page);

}
