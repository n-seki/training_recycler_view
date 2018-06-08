package com.example.seki.training_recycler_view

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class) @LargeTest
class MainScreenTest {

    @Rule @JvmField val mainActivityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test fun `タイトルラベルが表示されていること`() {
        onView(withId(R.id.label_title))
                .check(matches(withText(R.string.title)))
                .check(matches(isDisplayed()))
    }

    @Test fun `説明ラベルが表示されていること`() {
        onView(withId(R.id.label_description))
                .check(matches(isDisplayed()))
                .check(matches(withText(R.string.description)))
    }

    @Test fun `タイトルが非表示であること`() {
        onView(withId(R.id.selected_title))
                .check(matches(not(isDisplayed())))
    }

    @Test fun `説明が非表示であること`() {
        onView(withId(R.id.selected_description))
                .check(matches(not(isDisplayed())))
    }

    @Test fun `1つめの項目をクリックしたときにタイトルと説明が表示されること`() {
        onView(withId(R.id.list))
                .perform(RecyclerViewActions.actionOnItemAtPosition<ListAdapter.ViewHolder>(0, click()))

        onView(withId(R.id.selected_title))
                .check(matches(isDisplayed()))
                .check(matches(withText("1")))

        onView(withId(R.id.selected_description))
                .check(matches(isDisplayed()))
                .check(matches(withText("first")))
    }
}