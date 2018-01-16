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
import me.cristiangomez.popularmovies.data.pojo.Cast;
import me.cristiangomez.popularmovies.util.Utils;

public class MovieCastAdapter extends RecyclerView.Adapter<MovieCastAdapter.MovieCastViewHolder> {
    private List<Cast> mCasts;
    private Picasso mPicasso;

    public MovieCastAdapter(List<Cast> mCasts, Picasso mPicasso) {
        this.mCasts = mCasts;
        this.mPicasso = mPicasso;
    }

    @Override
    public MovieCastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cast,
                parent, false);
        return new MovieCastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieCastViewHolder holder, int position) {
        holder.bind(mCasts.get(position), mPicasso);
    }

    @Override
    public int getItemCount() {
        if (mCasts != null) {
            return mCasts.size();
        }
        return 0;
    }

    static class MovieCastViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_cast_photo)
        ImageView mCastPhotoIv;
        @BindView(R.id.tv_cast_name)
        TextView mCastNameTv;
        @BindView(R.id.tv_cast_character)
        TextView mCastCharacterTv;

        public MovieCastViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Cast cast, Picasso picasso) {
            mCastNameTv.setText(cast.getName());
            mCastCharacterTv.setText(cast.getCharacter());
            picasso.load(Utils.getImageUri(cast.getProfilePath(),
                    "original"))
                    .into(mCastPhotoIv);
        }
    }
}
