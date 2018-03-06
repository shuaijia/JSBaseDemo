package com.jia.demo.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jia.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 嵌套滚动的界面
 * Created by jia on 2017/11/17.
 * 人之所以能，是相信能
 */
public class NestedScrollingActivity extends AppCompatActivity {

    private RecyclerView recycler_view;

    private TabLayout mTabLayout;

    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nestedscrolling);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("CollapsingToolbarLayout");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);

        adapter=new MyAdapter();
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.setAdapter(adapter);
    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView view = new TextView(NestedScrollingActivity.this);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            ((TextView) holder.itemView).setText(position + "");
        }


        @Override
        public int getItemCount() {
            return 70;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            public MyViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
