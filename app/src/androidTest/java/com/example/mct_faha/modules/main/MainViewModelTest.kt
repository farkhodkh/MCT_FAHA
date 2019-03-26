package com.example.mct_faha.modules.main

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.mct_faha.MainActivity
import com.example.mct_faha.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainViewModelTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(
        MainActivity::class.java
    )

    @Test
    fun onTextEdited() {

        onView(withId(R.id.searchTextView))
            .check(matches(withText("")))

        onView(withId(R.id.searchTextView))
            .perform(typeText("jim jones"))

        onView(withId(R.id.searchTextView))
            .check(matches(withText("Jim jones")))

        onView((withId(R.id.loading)))
            .check(matches(isDisplayed()))

    }

    @Test
    fun loadRepositories() {
        var mainModule = MainViewModel()

        onView(withId(R.id.searchTextView))
            .perform(typeText("jim jones"))

        mainModule.loadRepositories("jim+jones")

//        onView((withId(R.id.repository_rv)))
//            .check(matches(isDisplayed()))
//            .perform(RecyclerViewActions.actionOnItemAtPosition<RepositoryRecyclerViewAdapter.ViewHolder>(0, click()))
    }
}

