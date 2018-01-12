package me.cristiangomez.popularmovies;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import me.cristiangomez.popularmovies.movies.MoviesActivity;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MoviesTestCase {

    @Rule
    public ActivityTestRule<MoviesActivity> mMoviesActivityActivityTestRule =
            new ActivityTestRule<>(MoviesActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("me.cristiangomez.popularmovies", appContext.getPackageName());
    }

    @Test
    public void showListOfMovies() {
        Espresso.onView(ViewMatchers.withId(R.id.pb_movies))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
