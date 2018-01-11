package me.cristiangomez.popularmovies;

import android.content.Intent;
import android.os.Bundle;

import me.cristiangomez.popularmovies.data.pojo.Movie;
import me.cristiangomez.popularmovies.movie.MovieActivity;
import me.cristiangomez.popularmovies.movies.MoviesActivity;

public class LauncherActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        startActivity(new Intent(this, MoviesActivity.class));
        Movie movie = new Movie("Baby Driver",
                "https://i2.wp.com/licensedtoill.lonchan.com/wp-content/uploads/sites/3/2017/07/1-baby-driver-screen-Lon-Chan.jpg?w=904",
                2017, "8.0 / 10", "120 min",
                "Plot Baby is a getaway driver in Atlanta, Georgia. When he was a child, a car accident killed his parents and left him with tinnitus, which he blocks out by listening to music on iPods. He ferries crews of robbers assembled by Doc, a heist mastermind, to pay off a debt he incurred after stealing one of Doc's cars. Between jobs, he creates remixes from snippets of conversations he records, and cares for his deaf foster father Joseph. At a diner, he meets a waitress, Debora, and they start dating.");
        Intent intent = new Intent(this, MovieActivity.class);
        intent.putExtra(MovieActivity.EXTRA_MOVIE, movie);
        startActivity(intent);
    }
}
