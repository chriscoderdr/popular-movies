package me.cristiangomez.popularmovies.movie;

import me.cristiangomez.popularmovies.data.pojo.Movie;

public class MoviePresenter implements MovieContract.Presenter {
    @Override
    public void takeView(MovieContract.View view) {
        view.onMovie(new Movie("Baby Driver",
                "https://i2.wp.com/licensedtoill.lonchan.com/wp-content/uploads/sites/3/2017/07/1-baby-driver-screen-Lon-Chan.jpg?w=904",
                2017, "8.0 / 10", "120 min",
                "Plot Baby is a getaway driver in Atlanta, Georgia. When he was a child, a car accident killed his parents and left him with tinnitus, which he blocks out by listening to music on iPods. He ferries crews of robbers assembled by Doc, a heist mastermind, to pay off a debt he incurred after stealing one of Doc's cars. Between jobs, he creates remixes from snippets of conversations he records, and cares for his deaf foster father Joseph. At a diner, he meets a waitress, Debora, and they start dating."));
    }

    @Override
    public void dropView() {

    }
}
