package com.nghiatv.robolectric;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * SignInActivity
 */
public class SignInActivity extends AppCompatActivity {

    private EditText mEdtUsername;
    private EditText mEdtPassword;
    private Button mBtnLogin;
    private TextView mTvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mEdtUsername = (EditText) findViewById(R.id.edtUsername);
        mEdtPassword = (EditText) findViewById(R.id.edtPassword);
        mBtnLogin = (Button) findViewById(R.id.btnLogin);
        mTvMessage = (TextView) findViewById(R.id.tvMessage);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnLogin.setClickable(false);
                checkLogin(mEdtUsername.getText().toString(), mEdtPassword.getText().toString());
            }
        });
    }

    private void checkLogin(String username, String password) {
        if (username.equals("abc") && password.equals("123")) {
            doLogin(getString(R.string.activity_sign_in_tv_success));
        } else {
            doLogin(getString(R.string.activity_sign_in_tv_fail));
        }
    }

    private void doLogin(String message) {
        mEdtUsername.setText(null);
        mEdtPassword.setText(null);
        mTvMessage.setText(message);
        mBtnLogin.setClickable(true);
    }
}
