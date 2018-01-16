package me.cristiangomez.popularmovies.movie;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
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
    RecyclerView mMovieRecommendationsRv;
    private Picasso mPicasso;
    private Unbinder mUnbinder;
    private View mView;

    public MovieOverviewView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.view_movieoverview, this, false);
        addView(mView);
        mUnbinder = ButterKnife.bind(this, mView);
        init();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        /*
        If I don't do this I get NPE exception from recyclerview mGapWorker
        https://issuetracker.google.com/issues/38375597
         */
        if (mView != null) {
            removeView(mView);
        }
        super.onDetachedFromWindow();
    }

    private void init() {
        mPicasso = Picasso.with(getContext().getApplicationContext());

        mPhotosRv.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false));
        mPhotosRv.setAdapter(new MovieImagesAdapter(null, null));
        mMovieCastRv.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false));
        mMovieCastRv.setAdapter(new MovieCastAdapter(null, null));
        mMovieVideosRv.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false));
        mMovieVideosRv.setAdapter(new MovieVideosAdapter(null, null));
        mMovieRecommendationsRv.setAdapter(new MovieRecomendationsAdapter(null,
                null));
        mMovieRecommendationsRv.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext(),
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
        mMovieRecommendationsRv.setAdapter(new MovieRecomendationsAdapter(
                movies, getContext()
        ));
    }
}
