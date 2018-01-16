package me.cristiangomez.popularmovies.util;

import android.net.Uri;

import me.cristiangomez.popularmovies.BuildConfig;

public abstract class Utils {
    public static Uri getImageUri(String imagePath, String size) {
        return Uri.parse(BuildConfig.IMAGE_BASE_URL)
                .buildUpon()
                .appendPath(size)
                .appendEncodedPath("/" + imagePath)
                .build();
    }

    public static Uri getYoutubeVideoThumbnail(String videoId) {
        return Uri.parse("https://img.youtube.com/vi/")
                .buildUpon()
                .appendEncodedPath(videoId)
                .appendEncodedPath("hqdefault.jpg")
                .build();
    }

    public static Uri getTheMovieDbUri(int id, String name) {
        return Uri.parse("https://www.themoviedb.org/movie/")
                .buildUpon()
                .appendEncodedPath(String.format("%d-%s", id, name)
                        .replace(" ", "-"))
                .build();
    }
}
