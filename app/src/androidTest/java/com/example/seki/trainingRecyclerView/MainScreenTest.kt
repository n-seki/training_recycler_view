package com.example.seki.trainingRecyclerView

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class) class MainScreenTest {

    @Rule @JvmField
    val mainActivityTestRule =
            ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test fun `タイトル、説明が表示されていること`() {
        onView(withId(R.id.label_title)).check(matches(isDisplayed()))
        onView(withId(R.id.label_description)).check(matches(isDisplayed()))
    }
}