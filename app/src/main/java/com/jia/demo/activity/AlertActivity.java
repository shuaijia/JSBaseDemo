package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jia.demo.R;

/**
 * 顶部 提示 框
 */
public class AlertActivity extends Activity implements View.OnClickListener{

    private Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        bt1= (Button) findViewById(R.id.bt1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1:

//                Alerter.create(this)
//                        .setTitle("Alert Title")
//                        .setText("Alert text...")
//                        .show();

                break;
        }
    }
}
