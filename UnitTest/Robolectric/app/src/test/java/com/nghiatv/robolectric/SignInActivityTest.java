package com.nghiatv.robolectric;

import android.widget.Button;
import android.widget.EditText;
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
 * SignInActivityTest
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class SignInActivityTest {
    private SignInActivity mSignInActivity;
    private EditText mEdtUsername;
    private EditText mEdtPassword;
    private Button mBtnLogin;
    private TextView mTvMessage;

    @Before
    public void setup() throws Exception {
        mSignInActivity = Robolectric.buildActivity(SignInActivity.class).create().get();
        mEdtUsername = (EditText) mSignInActivity.findViewById(R.id.edtUsername);
        mEdtPassword = (EditText) mSignInActivity.findViewById(R.id.edtPassword);
        mBtnLogin = (Button) mSignInActivity.findViewById(R.id.btnLogin);
        mTvMessage = (TextView) mSignInActivity.findViewById(R.id.tvMessage);
    }

    @Test
    public void testClickLoginButton() {
        assertNotNull("TextView could not be found", mTvMessage);
        assertTrue("TextView contains incorrect text",
                "Success".equals(mTvMessage.getText().toString()));
    }
}
