package com.jia.demo.fragment;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Describtion:
 * Created by jia on 2017/8/1.
 * 人之所以能，是相信能
 */
public class LifeMethodTwoFragment extends Fragment {
    private static final String TAG = "LifeMethod";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG, "onAttach: "+" fragment" +" B");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: "+" fragment" +" B");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView: "+" fragment" +" B");
        TextView view=new TextView(getContext());
        view.setText("第二个fragment");
        view.setBackgroundColor(Color.BLUE);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, "onViewCreated: "+" fragment" +" B");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated: "+" fragment" +" B");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: "+" fragment" +" B");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: "+" fragment" +" B");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: "+" fragment" +" B");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: "+" fragment" +" B");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "onDestroyView: "+" fragment" +" B");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: "+" fragment" +" B");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "onDetach: "+" fragment" +" B");
    }

    public LifeMethodTwoFragment() {
        super();
        Log.e(TAG, "LifeMethodTwoFragment: " );
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e(TAG, "onHiddenChanged: B"+hidden );
    }
}
