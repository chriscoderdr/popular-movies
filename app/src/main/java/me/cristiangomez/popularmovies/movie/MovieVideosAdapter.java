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
import me.cristiangomez.popularmovies.data.pojo.MovieVideo;
import me.cristiangomez.popularmovies.util.Utils;

public class MovieVideosAdapter extends RecyclerView.Adapter<MovieVideosAdapter.MovieVideoViewHolder> {
    private List<MovieVideo> mMovieVideos;
    private Picasso mPicasso;

    public MovieVideosAdapter(List<MovieVideo> mMovieVideos, Picasso mPicasso) {
        this.mMovieVideos = mMovieVideos;
        this.mPicasso = mPicasso;
    }

    @Override
    public MovieVideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_video,
                parent, false);
        return new MovieVideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieVideoViewHolder holder, int position) {
        holder.bind(mMovieVideos.get(position), mPicasso);
    }

    @Override
    public int getItemCount() {
        if (mMovieVideos != null) {
            return mMovieVideos.size();
        }
        return 0;
    }

    class MovieVideoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_movie_video_thumbnail)
        ImageView mMovieVideoThumbnail;
        @BindView(R.id.tv_movie_video_name)
        TextView mMovieVideoNameTv;

        public MovieVideoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(MovieVideo movieVideo, Picasso picasso) {
            mMovieVideoNameTv.setText(movieVideo.getName());
            picasso.load(Utils.getYoutubeVideoThumbnail(movieVideo.getKey()))
                    .into(mMovieVideoThumbnail);
        }
    }
}
