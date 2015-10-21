package com.nghiatv.robolectric;

import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * MainActivityTest
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
// @Before => JUnit 4 annotation that specifies this method should run before each test is run
public class MainActivityTest {
    private MainActivity mActivity;

    // Useful to do setup for objects that are needed in the test
    @Before
    public void setup() throws Exception {
        // Convenience method to run MainActivity through the Activity Lifecycle methods:
        // onCreate(...) => onStart() => onPostCreate(...) => onResume()
        mActivity = Robolectric.buildActivity(MainActivity.class).create().get();
    }

    // @Test => JUnit 4 annotation specifying this is a test to be run
    // The test simply checks that our TextView exists and has the text "Hello world!"
    @Test
    public void validateTextViewContent() {
        TextView tvHello = (TextView) mActivity.findViewById(R.id.tvHello);
        assertNotNull("TextView could not be found", tvHello);
        assertTrue("TextView contains incorrect text",
                "Hello".equals(tvHello.getText().toString()));
    }
}
