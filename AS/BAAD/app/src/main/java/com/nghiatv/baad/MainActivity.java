package com.nghiatv.baad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.nghiatv.baad.activity.LifeCycleActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private Button mBtnGoToLifeCycleActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        listener();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "----> onStart:");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "----> onResume:");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "----> onPause:");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "----> onStop:");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "----> onRestart:");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "----> onRestart:");
    }

    private void init() {
        mBtnGoToLifeCycleActivity = (Button) findViewById(R.id.mBtnGoToLifeCycleActivity);
    }

    private void listener() {
        mBtnGoToLifeCycleActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//              Linking activities using intents
                Intent intent = new Intent(MainActivity.this, LifeCycleActivity.class);
                startActivity(intent);

//               <activity android:name=”.Activity2”
//                ​​​​​​​​​android:label=”Activity 2”>
//                  <intent-filter>
//                ​​    <action android:name=”net.learn2develop.ACTIVITY2” />
//                ​​​​​​<category android:name=”android.intent.category.DEFAULT” />
//                ​​</intent-filter>
//               </activity>
            }
        });
    }
}
