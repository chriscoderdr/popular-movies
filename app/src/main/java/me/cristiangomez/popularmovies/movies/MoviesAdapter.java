package me.cristiangomez.popularmovies.movies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.cristiangomez.popularmovies.R;
import me.cristiangomez.popularmovies.data.Movie;
import me.cristiangomez.popularmovies.util.Utils;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {
    private List<Movie> mMovies;
    private Picasso mPicasso;

    public MoviesAdapter(List<Movie> movies, Context context) {
        this.mMovies = movies;
        mPicasso = Picasso.with(context);
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater
                .from(parent.getContext()).inflate(R.layout.item_movie, parent,
                        false), mPicasso);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.bind(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        if (mMovies != null) {
            return mMovies.size();
        }
        return 0;
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_movie_poster)
        ImageView mMoviePosterIv;
        Picasso mPicasso;

        MovieViewHolder(View itemView, Picasso picasso) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mPicasso = picasso;
        }

        void bind(Movie movie) {
            mPicasso.load(movie.getPosterImagePath())
                    .fit()
                    .centerCrop()
                    .into(mMoviePosterIv);
        }
    }
}
