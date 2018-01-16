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

import butterknife.BindView;
import butterknife.ButterKnife;
import me.cristiangomez.popularmovies.R;

public class MovieReviewsView extends FrameLayout {
    @BindView(R.id.rv_movie_reviews)
    RecyclerView mMovieReviews;
    private View mView;

    public MovieReviewsView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mView = LayoutInflater.from(context).inflate(R.layout.view_movie_reviews, this,
                false);
        this.addView(mView);
        ButterKnife.bind(this, mView);
        init();
    }

    @Override
    protected void onDetachedFromWindow() {
        if (mView != null) {
            this.removeView(mView);
        }
        super.onDetachedFromWindow();
    }

    private void init() {
        mMovieReviews.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        mMovieReviews.setAdapter(new MovieReviewsAdapter(null, null));
    }
}
