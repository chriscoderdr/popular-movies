package me.cristiangomez.popularmovies.data.pojo;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie implements Parcelable {
    private int id;
    private String title;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("backdrop_path")
    private String backdropPath;
    private Date releaseDate;
    @JsonProperty("vote_average")
    private int voteAverage;
    private int runtime;
    private String overview;
    private String popularity;


    public Movie() {

    }

    public Movie(String title, String posterPath) {
        this.title = title;
        this.posterPath = posterPath;
    }

    public Movie(String title, String posterPath, Date releaseDate, int voteAverage, int runtime, String overview) {
        this.title = title;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
        this.runtime = runtime;
        this.overview = overview;
    }

    protected Movie(Parcel in) {
        id = in.readInt();
        title = in.readString();
        posterPath = in.readString();
        voteAverage = in.readInt();
        runtime = in.readInt();
        overview = in.readString();
        releaseDate = (Date) in.readSerializable();
        backdropPath = in.readString();
        popularity = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(posterPath);
        dest.writeInt(voteAverage);
        dest.writeInt(runtime);
        dest.writeString(overview);
        dest.writeSerializable(releaseDate);
        dest.writeString(backdropPath);
        dest.writeString(popularity);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @JsonProperty("release_date")
    public void setReleaseData(String releaseData) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            releaseDate = formatter.parse(releaseData);
        } catch (ParseException e) {
            Log.e(Movie.class.getCanonicalName(), e.getMessage());
        }
    }

    public int getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(int voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }
}
