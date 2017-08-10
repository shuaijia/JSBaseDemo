package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jia.demo.R;
import com.jia.demo.fragment.LifeMethodFragment;
import com.jia.demo.fragment.LifeMethodTwoFragment;

/**
 * 研究Activity与Fragment生命周期方法
 */
public class LifeMehodThreeActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "LifeMethod";

    private LifeMethodFragment Afragment = new LifeMethodFragment();
    private LifeMethodTwoFragment Bfragment = new LifeMethodTwoFragment();

    private RelativeLayout rl_life_method;
    private TextView tv_three_life_first;
    private TextView tv_three_life_second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Log.e(TAG, "onCreate: " + " activity");
        setContentView(R.layout.activity_life_mehod_three);
        rl_life_method = (RelativeLayout) findViewById(R.id.rl_life_method);
        tv_three_life_first = (TextView) findViewById(R.id.tv_three_life_first);
        tv_three_life_first.setOnClickListener(this);
        tv_three_life_second = (TextView) findViewById(R.id.tv_three_life_second);
        tv_three_life_second.setOnClickListener(this);

        getFragmentManager().beginTransaction().add(R.id.rl_life_method,Afragment).commit();
        getFragmentManager().beginTransaction().add(R.id.rl_life_method,Bfragment).commit();

    }

    public LifeMehodThreeActivity() {
        super();
//        Log.e(TAG, "LifeMehodThreeActivity: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
//        Log.e(TAG, "onStart: " + " activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Log.e(TAG, "onResume: " + " activity");
    }

    @Override
    protected void onPause() {
        super.onPause();
//        Log.e(TAG, "onPause: " + " activity");
    }

    @Override
    protected void onStop() {
        super.onStop();
//        Log.e(TAG, "onStop: " + " activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Log.e(TAG, "onDestroy: " + " activity");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_three_life_first) {
//            getFragmentManager().beginTransaction().replace(R.id.rl_life_method, Afragment).commit();
            getFragmentManager().beginTransaction().hide(Bfragment).commitAllowingStateLoss();
            getFragmentManager().beginTransaction().show(Afragment).commitAllowingStateLoss();
        } else if (v.getId() == R.id.tv_three_life_second) {
//            getFragmentManager().beginTransaction().replace(R.id.rl_life_method, Bfragment).commit();
            getFragmentManager().beginTransaction().hide(Afragment).commitAllowingStateLoss();
            getFragmentManager().beginTransaction().show(Bfragment).commitAllowingStateLoss();
        }
    }
}
