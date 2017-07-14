package com.jia.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jia.demo.R;

public class LifeMethodTwoActivity extends Activity {

    private static final String TAG = "LifeMethod";

    private TextView tv_lifecycle_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_method_two);
        Log.e(TAG, "onCreate: B");
        tv_lifecycle_b= (TextView) findViewById(R.id.tv_lifecycle_b);
        tv_lifecycle_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LifeMethodTwoActivity.this,LifeMethodActivity.class));
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: B");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.e(TAG, "onStart: B");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: B");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: B");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: B");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: B");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState: B");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.e(TAG, "onRestoreInstanceState: B");
    }
}
