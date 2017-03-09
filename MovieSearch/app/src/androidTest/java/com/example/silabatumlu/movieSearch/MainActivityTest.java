package com.example.silabatumlu.movieSearch;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class, false, false);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.silabatumlu.movieSearch", appContext.getPackageName());
    }

    @Test
    public void recyclerViewMovieList_addItem() throws Exception {
        activityTestRule.launchActivity(null);
        onView(withId(R.id.txtMovieTitle))
                .perform(typeText("Star Wars"));
        onView(withId(R.id.button_search)).perform(click());
        onView(withId(R.id.recycler_view)).check(new RecyclerViewItemCountAssertion());
    }
}
