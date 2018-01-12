package me.cristiangomez.popularmovies.photoviewer;

import me.cristiangomez.popularmovies.BasePresenter;
import me.cristiangomez.popularmovies.BasePresenterState;
import me.cristiangomez.popularmovies.BaseView;
import me.cristiangomez.popularmovies.data.pojo.Photo;

public interface PhotoViewerContract {
    interface View extends BaseView {
        void onPhoto(Photo photo);
    }

    interface PresenterState extends BasePresenterState {
        Photo getPhoto();
    }

    interface Presenter extends BasePresenter<View, PresenterState> {

    }
}
