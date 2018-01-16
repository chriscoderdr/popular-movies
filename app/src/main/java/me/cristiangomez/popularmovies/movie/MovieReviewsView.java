package me.cristiangomez.popularmovies.movie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.cristiangomez.popularmovies.R;
import me.cristiangomez.popularmovies.data.pojo.MovieReview;

public class MovieReviewsView extends FrameLayout {
    @BindView(R.id.rv_movie_reviews)
    RecyclerView mMovieReviews;
    @BindView(R.id.lv_no_reviews)
    View mNoReviewsV;
    private View mView;
    private Picasso mPicasso;

    public MovieReviewsView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mView = LayoutInflater.from(context).inflate(R.layout.view_movie_reviews, this,
                false);
        this.addView(mView);
        ButterKnife.bind(this, mView);
        init();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        if (mView != null) {
            this.removeView(mView);
        }
        super.onDetachedFromWindow();
    }

    private void init() {
        mPicasso = Picasso.with(getContext());
        mMovieReviews.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        mMovieReviews.setAdapter(new MovieReviewsAdapter(null, null));
    }

    public void bind(List<MovieReview> movieReviews) {
        if (movieReviews != null && !movieReviews.isEmpty()) {
            mMovieReviews.setVisibility(VISIBLE);
            mNoReviewsV.setVisibility(INVISIBLE);
            mMovieReviews.swapAdapter(new MovieReviewsAdapter(movieReviews,
                    mPicasso), true);
        } else {
            mMovieReviews.setVisibility(INVISIBLE);
            mNoReviewsV.setVisibility(VISIBLE);
        }
    }
}
