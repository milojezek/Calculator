package eu.milo4apps.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import androidx.test.espresso.assertion.ViewAssertions.matches

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class CalculatorTests {

    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testAddition() {
        onView(withId(R.id.button_four))
            .perform(click())
        onView(withId(R.id.button_add))
            .perform(click())
        onView(withId(R.id.button_six))
            .perform(click())
        onView(withId(R.id.button_equal))
            .perform(click())
        onView(withId(R.id.textview_input))
            .check(matches(withText(containsString("10"))))
    }

    @Test
    fun testSubtraction() {
        onView(withId(R.id.button_eight))
            .perform(click())
        onView(withId(R.id.button_five))
            .perform(click())
        onView(withId(R.id.button_subtract))
            .perform(click())
        onView(withId(R.id.button_two))
            .perform(click())
        onView(withId(R.id.button_five))
            .perform(click())
        onView(withId(R.id.button_equal))
            .perform(click())
        onView(withId(R.id.textview_input))
            .check(matches(withText(containsString("60"))))
    }

    @Test
    fun testMultiplication() {
        onView(withId(R.id.button_four))
            .perform(click())
        onView(withId(R.id.button_multiply))
            .perform(click())
        onView(withId(R.id.button_six))
            .perform(click())
        onView(withId(R.id.button_equal))
            .perform(click())
        onView(withId(R.id.textview_input))
            .check(matches(withText(containsString("24"))))
    }

    @Test
    fun testDivision() {
        onView(withId(R.id.button_eight))
            .perform(click())
        onView(withId(R.id.button_five))
            .perform(click())
        onView(withId(R.id.button_divide))
            .perform(click())
        onView(withId(R.id.button_five))
            .perform(click())
        onView(withId(R.id.button_equal))
            .perform(click())
        onView(withId(R.id.textview_input))
            .check(matches(withText(containsString("17"))))
    }

    @Test
    fun testClearButton() {
        onView(withId(R.id.button_four))
            .perform(click())
        onView(withId(R.id.button_multiply))
            .perform(click())
        onView(withId(R.id.button_six))
            .perform(click())
        onView(withId(R.id.button_clear))
            .perform(click())
        onView(withId(R.id.textview_input))
            .check(matches(withText(containsString(""))))
    }

    @Test
    fun testDecimals() {
        onView(withId(R.id.button_two))
            .perform(click())
        onView(withId(R.id.button_zero))
            .perform(click())
        onView(withId(R.id.button_zero))
            .perform(click())
        onView(withId(R.id.button_decimal))
            .perform(click())
        onView(withId(R.id.button_five))
            .perform(click())
        onView(withId(R.id.button_multiply))
            .perform(click())
        onView(withId(R.id.button_one))
            .perform(click())
        onView(withId(R.id.button_decimal))
            .perform(click())
        onView(withId(R.id.button_five))
            .perform(click())
        onView(withId(R.id.button_equal))
            .perform(click())
        onView(withId(R.id.textview_input))
            .check(matches(withText(containsString("300.75"))))
    }
}