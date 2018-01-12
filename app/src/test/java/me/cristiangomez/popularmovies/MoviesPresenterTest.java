package me.cristiangomez.popularmovies;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import me.cristiangomez.popularmovies.data.MoviesRepository;
import me.cristiangomez.popularmovies.movies.MoviesContract;
import me.cristiangomez.popularmovies.movies.MoviesPresenter;
import me.cristiangomez.popularmovies.util.DataError;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MoviesPresenterTest {
    @Mock
    private MoviesContract.View mMoviesView;
    @Mock
    private MoviesRepository mMoviesRepository;
    private MoviesPresenter mMoviesPresenter;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(mMoviesRepository.getMovies(Mockito.any())).thenReturn(
                Observable.just(new ArrayList<>())
        );
        mMoviesPresenter = new MoviesPresenter(mMoviesRepository,
                Schedulers.single(), Schedulers.single());
    }

    @Test
    public void loadOnTakeView() {
        mMoviesPresenter.takeView(mMoviesView);
        Mockito.verify(mMoviesView, Mockito.atMost(1)).onMovies(Mockito.any());
    }

    @Test
    public void showProgressOnLoad() {
        mMoviesPresenter.takeView(mMoviesView);
        Mockito.verify(mMoviesView, Mockito.atMost(1)).showLoading();
    }

    @Test
    public void showErrorOnIOException() {
        Mockito.when(mMoviesRepository.getMovies(Mockito.any())).thenAnswer(invocation -> Observable.error(new IOException()));
        mMoviesPresenter.takeView(mMoviesView);
        Mockito.verify(mMoviesView, Mockito.atMost(1)).onError(DataError.NETWORK_NOT_AVAILABLE);
    }

    @Test
    public void dismissErrorWhenLoading() {
        mMoviesPresenter.takeView(mMoviesView);
        Mockito.verify(mMoviesView, Mockito.atMost(1)).dismissError();
    }
}