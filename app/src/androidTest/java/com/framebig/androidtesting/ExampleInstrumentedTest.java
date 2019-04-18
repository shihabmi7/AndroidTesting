package com.framebig.androidtesting;

import android.content.Context;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.framebig.androidtesting", appContext.getPackageName());
    }

    @Test
    public void greeterSaysHello() {

        onView(withId(R.id.editText_firstName)).perform(typeText("Shihab"));
        onView(withId(R.id.editText_lastName)).perform(typeText("Uddin"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView_message)).check(matches(withText("Welcome! Shihab Uddin")));


        //onView(withText("Hello Steve!")).check(matches(isDisplayed()));
    }


}
