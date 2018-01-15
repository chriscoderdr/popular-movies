package me.cristiangomez.popularmovies.movie;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.cristiangomez.popularmovies.R;
import me.cristiangomez.popularmovies.network.responses.MovieImage;
import me.cristiangomez.popularmovies.util.Constants;
import me.cristiangomez.popularmovies.util.Utils;

public class MovieImagesAdapter extends RecyclerView.Adapter<MovieImagesAdapter.MovieImageViewHolder> {
    private List<MovieImage> mMovieImages;
    private Picasso mPicasso;

    public MovieImagesAdapter(List<MovieImage> mMovieImages, Picasso mPicasso) {
        this.mMovieImages = mMovieImages;
        this.mPicasso = mPicasso;
    }

    @Override
    public MovieImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie_image,
                        parent, false);
        return new MovieImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieImageViewHolder holder, int position) {
        holder.bind(mMovieImages.get(position), mPicasso);
    }

    @Override
    public int getItemCount() {
        if (mMovieImages != null) {
            return mMovieImages.size();
        }
        return 0;
    }

    static class MovieImageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_movie_photo)
        ImageView mMoviePhotoIv;

        public MovieImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(MovieImage movieImage, Picasso picasso) {
            picasso.load(Utils.getImageUri(movieImage.getFilePath(),
                    Constants.IMAGE_SIZE)).into(mMoviePhotoIv);
        }
    }
}
