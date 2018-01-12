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
}
