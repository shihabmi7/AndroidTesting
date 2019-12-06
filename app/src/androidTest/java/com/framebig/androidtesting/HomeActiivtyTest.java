package com.framebig.androidtesting;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class HomeActiivtyTest {

    @Rule
    public ActivityTestRule<HomeActivity> rule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.framebig.androidtesting", appContext.getPackageName());
    }

    @Test
    public void greeterSaysHello() {

        onView(withId(R.id.editText_firstName)).perform(typeText("Manik"));
        onView(withId(R.id.editText_lastName)).perform(typeText("Monem"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView_message)).check(matches(withText("Welcome! Manik Monem")));


        //onView(withText("Hello Steve!")).check(matches(isDisplayed()));
    }

    @Test
    public void checkNewActivity() {

        onView(withId(R.id.button_open_new_activity)).perform(click());
        onView(withText("NumberTwo")).check(matches(isDisplayed()));

    }

    @Test
    public void checkHomeActivityIsLauched() {

        onView(withId(R.id.main)).check(matches(isDisplayed()));

    }

    @Test
    public void checkSecondActivityAndGetBack() {
        onView(withId(R.id.button_open_new_activity)).perform(click());

        onView(withId(R.id.secondary)).check(matches(isDisplayed()));

        pressBack();

        onView(withId(R.id.main)).check(matches(isDisplayed()));

    }
}
