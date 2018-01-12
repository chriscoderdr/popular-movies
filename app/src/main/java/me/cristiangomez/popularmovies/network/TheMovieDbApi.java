package me.cristiangomez.popularmovies.network;

import io.reactivex.Observable;
import me.cristiangomez.popularmovies.data.pojo.Movie;
import me.cristiangomez.popularmovies.data.pojo.MoviesResponse;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TheMovieDbApi {
    @GET("/3/movie/top_rated")
    Observable<Response<MoviesResponse>> topRatedMovies(@Query("api_key") String apiKey,
                                                        @Query("language") String language,
                                                        @Query("page") int page);

    @GET("/3/movie/popular")
    Observable<Response<MoviesResponse>> popularMovies(@Query("api_key") String apiKey,
                                                        @Query("language") String language,
                                                        @Query("page") int page);

    @GET("/3/movie/{id}")
    Observable<Response<Movie>> getMovie(@Path("id") int id,
                                         @Query("api_key") String apiKey,
                                         @Query("language") String language);

}
