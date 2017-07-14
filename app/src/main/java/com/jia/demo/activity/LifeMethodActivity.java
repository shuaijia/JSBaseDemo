package com.jia.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.playlog.internal.LogEvent;
import com.jia.demo.R;
import com.jia.demo.download.Person;

public class LifeMethodActivity extends Activity {

    private static final String TAG = "LifeMethod";

    private TextView tv_lifecycle_a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_method);
        Log.e(TAG, "onCreate: A");

        tv_lifecycle_a= (TextView) findViewById(R.id.tv_lifecycle_a);
        tv_lifecycle_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LifeMethodActivity.this,LifeMethodTwoActivity.class));
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: A");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: A");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: A");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: A");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: A");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: A");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG, "onRestoreInstanceState: A");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState: A");
    }

}
