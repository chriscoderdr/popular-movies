package me.cristiangomez.popularmovies.movie.movieheader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.cristiangomez.popularmovies.R;
import me.cristiangomez.popularmovies.data.pojo.Movie;
import me.cristiangomez.popularmovies.util.Utils;

public class MovieHeaderView extends ConstraintLayout {
    @BindView(R.id.iv_movie_poster)
    ImageView mMoviePoster;
    @BindView(R.id.iv_movie_bg_poster)
    ImageView mMovieBgPoster;
    @BindView(R.id.tv_movie_title)
    TextView mMovieTitleTv;
    @BindView(R.id.tv_release_date)
    TextView mMovieReleaseYearTv;
    private Picasso mPicasso;
    private Unbinder mUnbinder;

    public MovieHeaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_movie_header, this);
        mPicasso = Picasso.with(getContext().getApplicationContext());
        mUnbinder = ButterKnife.bind(this);
    }

    public void bind(Movie movie) {
        mMovieTitleTv.setText(movie.getTitle());
        mPicasso.load(Utils.getImageUri(movie.getPosterPath(), "original"))
                .fit()
                .into(mMoviePoster);
        mPicasso.load(Utils.getImageUri(movie.getBackdropPath(), "original"))
                .fit()
                .centerCrop()
                .into(mMovieBgPoster);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY");
        if (movie.getReleaseDate() != null) {
            mMovieReleaseYearTv.setText(dateFormat.format(movie.getReleaseDate()));
        }
    }
}
