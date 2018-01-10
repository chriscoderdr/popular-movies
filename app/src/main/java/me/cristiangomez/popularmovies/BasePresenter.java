package me.cristiangomez.popularmovies;

public interface BasePresenter<T> {
    void takeView(T view);
    void dropView();
}
