package org.fossasia.susi.ai.skills

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import android.view.WindowManager
import java.io.IOException
import org.fossasia.susi.ai.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import timber.log.Timber

/**
 * Created by collinx on 16-10-2017.
 */

@Suppress("DEPRECATION")
@RunWith(AndroidJUnit4::class)
@LargeTest
class SkillsActivityTest {

    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule(SkillsActivity::class.java)

    @Before
    @Throws(IOException::class, InterruptedException::class)
    fun unlockScreen() {
        Timber.d("running unlockScreen..")

        val activity = mActivityRule.activity
        val wakeUpDevice = Runnable {
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON or
                    WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                    WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        }
        activity.runOnUiThread(wakeUpDevice)
    }

    @Test
    fun testUIViews() {
        Timber.d("running testUIViews..")

        // checks if frame layout is displayed or not
        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()))
    }
}
