package me.cristiangomez.popularmovies.photoviewer;

import me.cristiangomez.popularmovies.data.pojo.Photo;

public class PhotoViewerPresenter implements PhotoViewerContract.Presenter {
    private Photo mPhoto;

    public PhotoViewerPresenter(Photo mPhoto) {
        this.mPhoto = mPhoto;
    }

    @Override
    public void takeView(PhotoViewerContract.View view) {
        view.onPhoto(mPhoto);
    }

    @Override
    public void dropView() {

    }

    @Override
    public PhotoViewerContract.PresenterState getState() {
        return null;
    }
}
