package me.cristiangomez.popularmovies.movie;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.cristiangomez.popularmovies.R;
import me.cristiangomez.popularmovies.data.pojo.Cast;
import me.cristiangomez.popularmovies.data.pojo.Movie;
import me.cristiangomez.popularmovies.data.pojo.MovieVideo;
import me.cristiangomez.popularmovies.network.responses.MovieImage;

public class MovieOverviewView extends ConstraintLayout {
    @BindView(R.id.tv_movie_plot)
    TextView mMoviePlotTv;
    @BindView(R.id.rv_photos)
    RecyclerView mPhotosRv;
    @BindView(R.id.rv_movie_cast)
    RecyclerView mMovieCastRv;
    @BindView(R.id.rv_movie_videos)
    RecyclerView mMovieVideosRv;
    @BindView(R.id.rv_movie_recommendations)
    RecyclerView mMovieRecomendationsRv;
    private Picasso mPicasso;

    public MovieOverviewView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_movieoverview, this);
        ButterKnife.bind(this);
        mPicasso = Picasso.with(getContext().getApplicationContext());

        mPhotosRv.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false));
        mPhotosRv.setAdapter(new MovieImagesAdapter(null, null));
        mMovieCastRv.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false));
        mMovieCastRv.setAdapter(new MovieCastAdapter(null, null));
        mMovieVideosRv.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false));
        mMovieVideosRv.setAdapter(new MovieVideosAdapter(null, null));
        mMovieRecomendationsRv.setAdapter(new MovieRecomendationsAdapter(null,
                null));
        mMovieRecomendationsRv.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false));
    }

    public void bind(Movie movie) {
        mMoviePlotTv.setText(movie.getOverview());
    }

    public void bindMovieImages(List<MovieImage> movieImages) {
        MovieImagesAdapter adapter = new MovieImagesAdapter(
                movieImages, Picasso.with(getContext().getApplicationContext())
        );
        adapter.setListener(movieImage -> {
//            mPresenter.onMovieImageTouch(movieImage);
        });
        mPhotosRv.swapAdapter(adapter, true);
    }

    public void bindCast(List<Cast> casts) {
        mMovieCastRv.swapAdapter(new MovieCastAdapter(casts, mPicasso),
                true);
    }

    public void bindMovieVideos(List<MovieVideo> movieVideos) {
        mMovieVideosRv.swapAdapter(new MovieVideosAdapter(
                movieVideos, mPicasso
        ), true);
    }

    public void binMovieRecomendations(List<Movie> movies) {
        mMovieRecomendationsRv.setAdapter(new MovieRecomendationsAdapter(
                movies, getContext()
        ));
    }
}
