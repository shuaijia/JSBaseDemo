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
public class LifeMethodFragment extends Fragment {

    private static final String TAG = "LifeMethod";

    public LifeMethodFragment() {
        super();
        Log.e(TAG, "LifeMethodFragment: " );
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG, "onAttach: "+" fragment"+" A" );
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: "+" fragment"+" A" );
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView: "+" fragment"+" A" );
        TextView view=new TextView(getContext());
        view.setText("第一个fragment");
        view.setBackgroundColor(Color.GRAY);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, "onViewCreated: "+" fragment" +" A");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated: "+" fragment"+" A" );
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: "+" fragment" +" A");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: "+" fragment" +" A");
    }


    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: "+" fragment" +" A");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: "+" fragment" +" A");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "onDestroyView: "+" fragment" +" A");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: "+" fragment" +" A");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "onDetach: "+" fragment"+" A" );
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e(TAG, "onHiddenChanged: A"+hidden );
    }
}
