package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jia.demo.R;
import com.jia.demo.event.EventDemo;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Describtion:
 * Created by jia on 2017/3/31 0031.
 * 人之所以能，是相信能
 */
public class EventBusSecondActivity extends Activity {

    private Button bt_event_second;
    private TextView tv_event_second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_second);


        tv_event_second= (TextView) findViewById(R.id.tv_event_second);
        bt_event_second= (Button) findViewById(R.id.bt_event_second);
        bt_event_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EventBus.getDefault().post(new EventDemo("我来自第二页"));

                /**
                 * postSticky发送StickyEvent，StickyEvent在内存中保存最新的消息，
                 * 取消原有消息，执行最新消息，只有在注册后才会执行，如果没有注册，
                 * 消息会一直保留来内存中
                 * 可以处理有关 "进度" 的问题
                 */
//                EventBus.getDefault().postSticky(new EventDemo("Hello everyone!"));

                /**
                 * 中断传递消息
                 */
//                EventBus.getDefault().cancelEventDelivery(new EventDemo("Hello everyone!")) ;
            }
        });
    }

}
