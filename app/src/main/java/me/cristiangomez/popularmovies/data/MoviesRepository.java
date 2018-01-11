package me.cristiangomez.popularmovies.data;

import android.support.annotation.NonNull;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import me.cristiangomez.popularmovies.BuildConfig;
import me.cristiangomez.popularmovies.data.pojo.Movie;
import me.cristiangomez.popularmovies.data.pojo.MoviesResponse;
import me.cristiangomez.popularmovies.exceptions.InvalidApiKeyException;
import me.cristiangomez.popularmovies.movies.MovieSortOption;
import me.cristiangomez.popularmovies.network.ApiFactory;
import me.cristiangomez.popularmovies.network.TheMovieDbApi;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MoviesRepository {
    private final TheMovieDbApi theMovieDbApi;

    public MoviesRepository(TheMovieDbApi theMovieDbApi) {
        this.theMovieDbApi = theMovieDbApi;
    }

    public Observable<List<Movie>> getMovies(@NonNull MovieSortOption moviesSortOption) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Baby Driver", "https://20ui41tp7v127j03rcnp97oh-wpengine.netdna-ssl.com/wp-content/uploads/2017/07/coupland_driver2.jpg",
                2017, "10/10", "160 min", "Lorem ipsum"));
        movies.add(new Movie("Baby Driver", "https://20ui41tp7v127j03rcnp97oh-wpengine.netdna-ssl.com/wp-content/uploads/2017/07/coupland_driver2.jpg",
                2017, "10/10", "160 min", "Lorem ipsum"));
        movies.add(new Movie("Baby Driver", "https://20ui41tp7v127j03rcnp97oh-wpengine.netdna-ssl.com/wp-content/uploads/2017/07/coupland_driver2.jpg",
                2017, "10/10", "160 min", "Lorem ipsum"));
        movies.add(new Movie("Baby Driver", "https://20ui41tp7v127j03rcnp97oh-wpengine.netdna-ssl.com/wp-content/uploads/2017/07/coupland_driver2.jpg",
                2017, "10/10", "160 min", "Lorem ipsum"));
        movies.add(new Movie("Baby Driver", "https://20ui41tp7v127j03rcnp97oh-wpengine.netdna-ssl.com/wp-content/uploads/2017/07/coupland_driver2.jpg",
                2017, "10/10", "160 min", "Lorem ipsum"));
        movies.add(new Movie("Baby Driver", "https://20ui41tp7v127j03rcnp97oh-wpengine.netdna-ssl.com/wp-content/uploads/2017/07/coupland_driver2.jpg",
                2017, "10/10", "160 min", "Lorem ipsum"));
        movies.add(new Movie("Baby Driver", "https://20ui41tp7v127j03rcnp97oh-wpengine.netdna-ssl.com/wp-content/uploads/2017/07/coupland_driver2.jpg",
                2017, "10/10", "160 min", "Lorem ipsum"));
        movies.add(new Movie("Baby Driver", "https://20ui41tp7v127j03rcnp97oh-wpengine.netdna-ssl.com/wp-content/uploads/2017/07/coupland_driver2.jpg",
                2017, "10/10", "160 min", "Lorem ipsum"));
        movies.add(new Movie("Baby Driver", "https://20ui41tp7v127j03rcnp97oh-wpengine.netdna-ssl.com/wp-content/uploads/2017/07/coupland_driver2.jpg",
                2017, "10/10", "160 min", "Lorem ipsum"));
        movies.add(new Movie("Baby Driver", "https://20ui41tp7v127j03rcnp97oh-wpengine.netdna-ssl.com/wp-content/uploads/2017/07/coupland_driver2.jpg",
                2017, "10/10", "160 min", "Lorem ipsum"));
        movies.add(new Movie("Baby Driver", "https://20ui41tp7v127j03rcnp97oh-wpengine.netdna-ssl.com/wp-content/uploads/2017/07/coupland_driver2.jpg",
                2017, "10/10", "160 min", "Lorem ipsum"));
        movies.add(new Movie("Baby Driver", "https://20ui41tp7v127j03rcnp97oh-wpengine.netdna-ssl.com/wp-content/uploads/2017/07/coupland_driver2.jpg",
                2017, "10/10", "160 min", "Lorem ipsum"));
        movies.add(new Movie("Baby Driver", "https://20ui41tp7v127j03rcnp97oh-wpengine.netdna-ssl.com/wp-content/uploads/2017/07/coupland_driver2.jpg",
                2017, "10/10", "160 min", "Lorem ipsum"));
        movies.add(new Movie("Baby Driver", "https://20ui41tp7v127j03rcnp97oh-wpengine.netdna-ssl.com/wp-content/uploads/2017/07/coupland_driver2.jpg",
                2017, "10/10", "160 min", "Lorem ipsum"));
        movies.add(new Movie("Baby Driver", "https://20ui41tp7v127j03rcnp97oh-wpengine.netdna-ssl.com/wp-content/uploads/2017/07/coupland_driver2.jpg",
                2017, "10/10", "160 min", "Lorem ipsum"));
        movies.add(new Movie("Baby Driver", "https://20ui41tp7v127j03rcnp97oh-wpengine.netdna-ssl.com/wp-content/uploads/2017/07/coupland_driver2.jpg",
                2017, "10/10", "160 min", "Lorem ipsum"));
        return Observable.just(movies);
//        Retrofit retrofit = ApiFactory.getRetrofit();
//        Observable<Response<MoviesResponse>> moviesObservable = null;
//        switch (moviesSortOption) {
//            case BY_MOST_POPULAR:
//                moviesObservable = theMovieDbApi.popularMovies(BuildConfig.API_KEY, null, 1);
//                break;
//            case BY_HIGHEST_RATED:
//                moviesObservable = theMovieDbApi.topRatedMovies(BuildConfig.API_KEY, null, 1);
//                break;
//        }
//        return moviesObservable
//                .map((Response<MoviesResponse> listResponse) -> {
//                    if (listResponse.isSuccessful() && listResponse.body() != null) {
//                        return listResponse.body().getResults();
//                    } else if (listResponse.errorBody() != null) {
//                        Converter<ResponseBody, MoviesResponse> converter = retrofit.responseBodyConverter(MoviesResponse.class,
//                                new Annotation[0]);
//                        MoviesResponse errorResponse = converter.convert(listResponse.errorBody());
//                        if (errorResponse.getStatusCode() == 7) {
//                            throw new InvalidApiKeyException();
//                        }
//                    }
//                    return new ArrayList<>();
//                });
    }
}
