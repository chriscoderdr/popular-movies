package me.cristiangomez.popularmovies;

public interface BasePresenter<T, V> {
    void takeView(T view);
    void dropView();
    V getState();
}
