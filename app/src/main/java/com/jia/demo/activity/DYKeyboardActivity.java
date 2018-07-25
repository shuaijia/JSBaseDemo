package com.jia.demo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jia.demo.R;
import com.jia.demo.view.DyKeyBoardView;

import org.jetbrains.annotations.NotNull;

public class DYKeyboardActivity extends AppCompatActivity {

    private DyKeyBoardView keyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dykeyboard);
        keyboard= (DyKeyBoardView) findViewById(R.id.keyboard);

        keyboard.setOnTextChangedListener(new DyKeyBoardView.OnTextChangedListener() {
            @Override
            public void onAfterChanged(@NotNull String content) {
                Log.e("jia", "onAfterChanged: "+content );
            }

            @Override
            public void onChanged(@NotNull String content) {
                Log.e("jia", "onChanged: "+content );
            }
        });
    }
}
