package me.cristiangomez.popularmovies.movie;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.cristiangomez.popularmovies.R;
import me.cristiangomez.popularmovies.data.pojo.MovieReview;

public class MovieReviewsAdapter extends RecyclerView.Adapter<MovieReviewsAdapter.MovieReviewViewHolder> {
    private List<MovieReview> mMovieReviews;

    @Override
    public MovieReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_review,
                parent, false);
        return new MovieReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieReviewViewHolder holder, int position) {
        holder.bind(mMovieReviews.get(position));
    }

    @Override
    public int getItemCount() {
        if (mMovieReviews != null) {
            return mMovieReviews.size();
        }
        return 0;
    }

    class MovieReviewViewHolder extends RecyclerView.ViewHolder {

        public MovieReviewViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(MovieReview movieReview) {

        }
    }
}
