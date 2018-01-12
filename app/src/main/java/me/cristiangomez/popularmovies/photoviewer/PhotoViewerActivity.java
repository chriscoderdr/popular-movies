package me.cristiangomez.popularmovies.photoviewer;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.cristiangomez.popularmovies.BaseActivity;
import me.cristiangomez.popularmovies.R;
import me.cristiangomez.popularmovies.data.pojo.Photo;


public class PhotoViewerActivity extends BaseActivity {
    public static final String EXTRA_PHOTO = "EXTRA_PHOTO";
    private PhotoViewerContract.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_viewer);
        PhotoViewerFragment photoViewerFragment = (PhotoViewerFragment) getSupportFragmentManager()
                .findFragmentById(R.id.photo_viewer_fragment);
        if (savedInstanceState == null) {
            Photo photo = getIntent().getParcelableExtra(EXTRA_PHOTO);
            mPresenter = new PhotoViewerPresenter(photo);
            mPresenter.takeView(photoViewerFragment);
        }
    }
}
