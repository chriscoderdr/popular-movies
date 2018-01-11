package me.cristiangomez.popularmovies.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie implements Parcelable {
    private String title;
    @JsonProperty("poster_path")
    private String posterPath;
    private int releaseYear;
    private String rating;
    private String duration;
    private String plot;


    public Movie() {

    }

    public Movie(String title, String posterPath) {
        this.title = title;
        this.posterPath = posterPath;
    }

    public Movie(String title, String posterPath, int releaseYear, String rating, String duration, String plot) {
        this.title = title;
        this.posterPath = posterPath;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.duration = duration;
        this.plot = plot;
    }

    protected Movie(Parcel in) {
        title = in.readString();
        posterPath = in.readString();
        releaseYear = in.readInt();
        rating = in.readString();
        duration = in.readString();
        plot = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(posterPath);
        dest.writeInt(releaseYear);
        dest.writeString(rating);
        dest.writeString(duration);
        dest.writeString(plot);
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

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}
