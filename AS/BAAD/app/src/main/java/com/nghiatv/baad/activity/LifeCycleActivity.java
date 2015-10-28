package com.nghiatv.baad.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.nghiatv.baad.R;

public class LifeCycleActivity extends AppCompatActivity {
    private static final String TAG = LifeCycleActivity.class.getSimpleName();

    private static final int REQUEST_CODE = 100;
    private static final String URL_AMAZON = "http://www.amazon.com";
    private static final String TEL_NUMBER = "tel:+651234567";
    private static final String GEO_LAT_LONG = "geo:37.827500,-122.481670";

    private Button mBtnShowDialog;
    private Button mBtnShowWebBrowser;
    private Button mBtnMakeCalls;
    private Button mBtnShowMap;
    private Button mBtnChooseContact;

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
        mBtnShowWebBrowser = (Button) findViewById(R.id.mBtnShowWebBrowser);
        mBtnMakeCalls = (Button) findViewById(R.id.mBtnMakeCalls);
        mBtnShowMap = (Button) findViewById(R.id.mBtnShowMap);
        mBtnChooseContact = (Button) findViewById(R.id.mBtnChooseContact);
    }

    private void listener() {
        mBtnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessageDialog(getString(R.string.life_cycle_dialog_title));
            }
        });
        mBtnShowWebBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_AMAZON));
                startActivity(i);
            }
        });
        mBtnMakeCalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse(TEL_NUMBER));
                startActivity(i);
            }
        });
        mBtnShowMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(GEO_LAT_LONG));
                startActivity(i);
            }
        });
        mBtnChooseContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setType(ContactsContract.Contacts.CONTENT_TYPE);
                startActivityForResult(i, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(data.getData().toString()));
                startActivity(i);
            }
        }
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
