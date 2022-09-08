package com.felix.gorenganku.ui.home


import androidx.test.espresso.DataInteraction
import androidx.test.espresso.ViewInteraction
import androidx.test.filters.LargeTest
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent

import androidx.test.InstrumentationRegistry.getInstrumentation
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*

import com.felix.gorenganku.R

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.hamcrest.Matchers.`is`

@LargeTest
@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun navigationTest() {
         // Added a sleep statement to match the app's execution delay.
 // The recommended way to handle such scenarios is to use Espresso idling resources:
  // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
Thread.sleep(500)

        val recyclerView = onView(
allOf(withId(R.id.rv_favorite),
childAtPosition(
withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
2)))
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(0, click()))

         // Added a sleep statement to match the app's execution delay.
 // The recommended way to handle such scenarios is to use Espresso idling resources:
  // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
Thread.sleep(700)

        val appCompatImageView = onView(
allOf(withId(R.id.iv_back),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()))
        appCompatImageView.perform(click())

         // Added a sleep statement to match the app's execution delay.
 // The recommended way to handle such scenarios is to use Espresso idling resources:
  // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
Thread.sleep(700)

        val recyclerView2 = onView(
allOf(withId(R.id.rv_show_detail),
childAtPosition(
withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
4)))
        recyclerView2.perform(actionOnItemAtPosition<ViewHolder>(0, click()))

         // Added a sleep statement to match the app's execution delay.
 // The recommended way to handle such scenarios is to use Espresso idling resources:
  // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
Thread.sleep(700)

        val appCompatImageView2 = onView(
allOf(withId(R.id.iv_back),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()))
        appCompatImageView2.perform(click())

         // Added a sleep statement to match the app's execution delay.
 // The recommended way to handle such scenarios is to use Espresso idling resources:
  // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
Thread.sleep(700)

        val recyclerView3 = onView(
allOf(withId(R.id.rv_favorite),
childAtPosition(
withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
2)))
        recyclerView3.perform(actionOnItemAtPosition<ViewHolder>(22, click()))

         // Added a sleep statement to match the app's execution delay.
 // The recommended way to handle such scenarios is to use Espresso idling resources:
  // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
Thread.sleep(700)

        val appCompatImageView3 = onView(
allOf(withId(R.id.iv_back),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()))
        appCompatImageView3.perform(click())

         // Added a sleep statement to match the app's execution delay.
 // The recommended way to handle such scenarios is to use Espresso idling resources:
  // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
Thread.sleep(700)

        val recyclerView4 = onView(
allOf(withId(R.id.rv_show_detail),
childAtPosition(
withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
4)))
        recyclerView4.perform(actionOnItemAtPosition<ViewHolder>(15, click()))

         // Added a sleep statement to match the app's execution delay.
 // The recommended way to handle such scenarios is to use Espresso idling resources:
  // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
Thread.sleep(700)

        val appCompatImageView4 = onView(
allOf(withId(R.id.iv_back),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()))
        appCompatImageView4.perform(click())
        }

    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
    }
