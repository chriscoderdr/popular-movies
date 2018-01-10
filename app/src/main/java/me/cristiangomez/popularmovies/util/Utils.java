package me.cristiangomez.popularmovies.util;

import android.net.Uri;

import me.cristiangomez.popularmovies.BuildConfig;

public class Utils {
    public static Uri getImageUri(String imagePath) {
        return Uri.parse(imagePath);
//        return Uri.parse(BuildConfig.API_BASE_URL)
//                .buildUpon()
//                .path(imagePath)
//                .build();
    }
}
