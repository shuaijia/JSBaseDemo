package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jia.demo.R;
import com.jia.demo.adapter.ItemAnimAdapter;
import com.jia.demo.view.itemAnimator.FadeItemAnimator;
import com.jia.demo.view.itemAnimator.SlideItemAnimator;

/**
 * recyclerView动画
 */
public class ItemAnimatorActivity extends Activity implements View.OnClickListener {

    private RecyclerView rv_animator;
    private TextView tv_add;
    private TextView tv_delete;
    private TextView tv_update;

    private ItemAnimAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_animator);
        rv_animator = (RecyclerView) findViewById(R.id.rv_animator);
        tv_add = (TextView) findViewById(R.id.tv_add);
        tv_delete = (TextView) findViewById(R.id.tv_delete);
        tv_update = (TextView) findViewById(R.id.tv_update);

        tv_add.setOnClickListener(this);
        tv_delete.setOnClickListener(this);
        tv_update.setOnClickListener(this);

        adapter=new ItemAnimAdapter(this);
        rv_animator.setLayoutManager(new LinearLayoutManager(this));
        rv_animator.setItemAnimator(new SlideItemAnimator());
        rv_animator.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_add:

                adapter.addData();

                break;
            case R.id.tv_delete:

                adapter.deleteData();

                break;
            case R.id.tv_update:

                adapter.updateData();

                break;
        }
    }
}
