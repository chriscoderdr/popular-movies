package me.cristiangomez.popularmovies.ui.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;

import me.cristiangomez.popularmovies.R;

public class RatingsView extends ConstraintLayout {
    public RatingsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_ratings, this);
    }
}
