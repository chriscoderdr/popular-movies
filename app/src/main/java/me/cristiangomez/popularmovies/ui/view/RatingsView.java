package me.cristiangomez.popularmovies.ui.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import me.cristiangomez.popularmovies.R;
import me.cristiangomez.popularmovies.data.pojo.Movie;

public class RatingsView extends ConstraintLayout {
    @BindView(R.id.tv_rating_number)
    TextView mRatingNumberTv;
    @BindViews({R.id.iv_rating_1, R.id.iv_rating_2, R.id.iv_rating_3,
            R.id.iv_rating_4, R.id.iv_rating_5})
    List<ImageView> mRatingIvs;

    public RatingsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(getContext(), R.layout.view_ratings, this);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
    }

    public void bind(Movie movie) {
        if (movie != null) {
            mRatingNumberTv.setText(String.valueOf(movie.getVoteAverage()));
        }
    }
}
