package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.jia.demo.R;
import com.jia.demo.view.WaveProgressView;

public class WaterWaveProgressActivity extends Activity {

    private WaveProgressView pv;
    private static final int FLAG_ONE = 0X0001;
    private int max_progress = 100;
    private int progress;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progress++;
            switch (msg.what) {
                case FLAG_ONE:
                    if (progress <= max_progress){
                        pv.setCurrent(progress, progress + "%");
                        sendEmptyMessageDelayed(FLAG_ONE, 100);
                    }else {
                        return;
                    }
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_wave_progress);
        pv= (WaveProgressView) findViewById(R.id.pv);

        pv.setWaveColor("#FF0397FF");
        handler.sendEmptyMessageDelayed(FLAG_ONE, 1000);
    }
}
