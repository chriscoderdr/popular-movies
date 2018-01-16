package me.cristiangomez.popularmovies.movie;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.cristiangomez.popularmovies.R;
import me.cristiangomez.popularmovies.data.pojo.MovieReview;
import me.cristiangomez.popularmovies.util.Utils;

public class MovieReviewsAdapter extends RecyclerView.Adapter<MovieReviewsAdapter.MovieReviewViewHolder> {
    private List<MovieReview> mMovieReviews;
    private Picasso mPicasso;

    public MovieReviewsAdapter(List<MovieReview> mMovieReviews, Picasso mPicasso) {
        this.mMovieReviews = mMovieReviews;
        this.mPicasso = mPicasso;
    }

    @Override
    public MovieReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_review,
                parent, false);
        return new MovieReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieReviewViewHolder holder, int position) {
        holder.bind(mMovieReviews.get(position), mPicasso);
    }

    @Override
    public int getItemCount() {
        if (mMovieReviews != null) {
            return mMovieReviews.size();
        }
        return 0;
    }

    class MovieReviewViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_reviewer_avatar)
        ImageView mReviewerAvatarIv;
        @BindView(R.id.tv_reviewer_name)
        TextView mReviewerNameTv;
        @BindView(R.id.tv_review_content)
        TextView mReviewContent;

        public MovieReviewViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(MovieReview movieReview, Picasso picasso) {
            mReviewContent.setText(movieReview.getContent());
            mReviewerNameTv.setText(movieReview.getAuthor());
            picasso.load(Utils.getGravatarUri(movieReview.getId()))
                    .into(mReviewerAvatarIv);
        }
    }
}
