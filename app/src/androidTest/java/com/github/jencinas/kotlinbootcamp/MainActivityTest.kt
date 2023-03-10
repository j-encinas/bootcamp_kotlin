package com.github.jencinas.kotlinbootcamp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.core.AllOf.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun testButtonChangesActivity(){
        onView(withId(R.id.mainGoButton)).perform(click())
        intended(allOf(IntentMatchers.hasComponent(GreetingActivity::class.java.name)))
    }

    @Test
    fun testGreetingUpdatesCorrectly(){
        onView(withId(R.id.mainName)).perform(
            ViewActions.replaceText("Steve"),
            ViewActions.closeSoftKeyboard())
        onView(withId(R.id.mainName)).check(ViewAssertions.matches(ViewMatchers.withText("Steve")))
    }

}