package me.cristiangomez.popularmovies.data.pojo;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Photo implements Parcelable {
    private Uri mImagePath;

    public Photo(Uri imagePath) {
        this.mImagePath = imagePath;
    }

    protected Photo(Parcel in) {
        mImagePath = in.readParcelable(Uri.class.getClassLoader());
    }

    public Uri getImagePath() {
        return mImagePath;
    }

    public void setImagePath(Uri mImagePath) {
        this.mImagePath = mImagePath;
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mImagePath, flags);
    }
}
