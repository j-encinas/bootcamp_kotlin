package com.github.jencinas.kotlinbootcamp

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GreetingActivityTest {

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun testCorrectGreetingDisplayed() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = Intent(context, GreetingActivity::class.java)
        intent.putExtra("EXTRA_USERNAME", "John")
        ActivityScenario.launch<Activity>(intent)
        Espresso.onView(withId(R.id.greetingMessage))
            .check(ViewAssertions.matches(ViewMatchers.withText("Hello " + intent.getStringExtra("EXTRA_USERNAME"))))


    }

}
