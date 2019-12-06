package com.framebig.androidtesting;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4ClassRunner.class)
public class SecondActivityTest {

    @Rule
    public ActivityTestRule<SecondActivity> rule = new ActivityTestRule<>(SecondActivity.class);

    @Test
    public void haveRecyclerView() {
        onView(withId(R.id.secondary)).check(matches(isDisplayed()));
    }
}