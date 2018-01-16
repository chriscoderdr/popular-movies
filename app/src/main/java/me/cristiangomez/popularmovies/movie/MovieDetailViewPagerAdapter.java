package me.cristiangomez.popularmovies.movie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MovieDetailViewPagerAdapter extends PagerAdapter {
    private MovieOverviewView mMovieOverview;
    private MovieReviewsView mMovieReviews;
    private Context mContext;
    private int currentPosition;

    public MovieDetailViewPagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        switch (position) {
            case 0:
                title = "Overview";
                break;
            case 1:
                title = "Reviews";
                break;
        }
        return title;
    }

    @Override
    public float getPageWidth(int position) {
        return 1f;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = null;
        switch (position) {
            case 0:
                view = getMovieOverview();
                break;
            case 1:
                view = getMovieReviews();
                break;
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object view) {
        switch (position) {
            case 0:
                mMovieOverview = null;
                break;
            case 1:
                mMovieReviews = null;
                break;
        }
        container.removeView((View) view);
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.setPrimaryItem(container, position, object);
        currentPosition = position;
    }

    public MovieOverviewView getMovieOverview() {
        if (mMovieOverview == null) {
            mMovieOverview = new MovieOverviewView(mContext, null);
        }
        return mMovieOverview;
    }

    public MovieReviewsView getMovieReviews() {
        if (mMovieOverview != null) {
            mMovieReviews = new MovieReviewsView(mContext, null);
        }
        return mMovieReviews;
    }
}
