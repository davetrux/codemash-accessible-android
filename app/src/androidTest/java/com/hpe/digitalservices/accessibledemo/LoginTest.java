package com.hpe.digitalservices.accessibledemo;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import android.support.test.espresso.contrib.AccessibilityChecks;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * @author trux
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule(LoginActivity.class);

    // Accessibility Feature
    @BeforeClass
    public static void enableAccessibilityChecks() {
        // https://www.ebayinc.com/stories/blogs/tech/android-accessibility-automation-with-espresso/
        AccessibilityChecks.enable();
    }

    @Test
    public void testEmailError() {
        // Type text and then press the button.
        onView(withId(R.id.email))
                .perform(typeText("badEmailAddress"), closeSoftKeyboard());
        onView(withId(R.id.email_sign_in_button)).perform(click());

        // Check that the text was changed.
        String expectedMessage = getResourceString(R.string.error_invalid_email);
        onView(withId(R.id.email)).check(matches(hasErrorText(expectedMessage)));
    }

    private String getResourceString(int id) {
        Context targetContext = InstrumentationRegistry.getTargetContext();
        return targetContext.getResources().getString(id);
    }
}
