package com.nghiatv.baad.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.nghiatv.baad.R;

public class LifeCycleActivity extends AppCompatActivity {
    private static final String TAG = LifeCycleActivity.class.getSimpleName();

    private Button mBtnShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d(TAG, "----> onCreate:");
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
        mBtnShowDialog = (Button) findViewById(R.id.mBtnShowDialog);
    }

    private void listener() {
        mBtnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessageDialog(getString(R.string.life_cycle_dialog_title));
            }
        });
    }

    private void showMessageDialog(String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(LifeCycleActivity.this);
        builder.setMessage(title);
        builder.setPositiveButton(R.string.life_cycle_dialog_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
