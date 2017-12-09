package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.jia.demo.R;

/**
 * 浮动按钮界面
 */
public class FabActivity extends Activity implements View.OnClickListener {

    private FloatingActionButton menu_item1;
    private FloatingActionButton menu_item2;
    private FloatingActionButton menu_item3;
    private FloatingActionButton menu_item4;
    private FloatingActionButton menu_item5;
    private FloatingActionButton menu_item6;
    private FloatingActionButton menu_item7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);
        initView();
    }

    private void initView() {
        menu_item1 = (FloatingActionButton) findViewById(R.id.menu_item1);
        menu_item2 = (FloatingActionButton) findViewById(R.id.menu_item2);
        menu_item3 = (FloatingActionButton) findViewById(R.id.menu_item3);
        menu_item4 = (FloatingActionButton) findViewById(R.id.menu_item4);
        menu_item5 = (FloatingActionButton) findViewById(R.id.menu_item5);
        menu_item6 = (FloatingActionButton) findViewById(R.id.menu_item6);
        menu_item7 = (FloatingActionButton) findViewById(R.id.menu_item7);

        menu_item1.setOnClickListener(this);
        menu_item2.setOnClickListener(this);
        menu_item3.setOnClickListener(this);
        menu_item4.setOnClickListener(this);
        menu_item5.setOnClickListener(this);
        menu_item6.setOnClickListener(this);
        menu_item7.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_item1:
                Toast.makeText(this,"我的考试",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item2:
                Toast.makeText(this,"通知",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item3:
                Toast.makeText(this,"我的讨论",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item4:
                Toast.makeText(this,"我的自测",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item5:
                Toast.makeText(this,"我的作业",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item6:
                Toast.makeText(this,"大家疑问",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item7:
                Toast.makeText(this,"共享笔记",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
