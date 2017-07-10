package com.jia.demo.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.TextView;

import com.jia.demo.MainActivity;
import com.jia.demo.R;

import java.io.File;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_notification_normal;

    private TextView tv_notification_progress;

    private NotificationManager notificationManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE); // 获取系统提供的通知管理服务

        tv_notification_normal = (TextView) findViewById(R.id.tv_notification_normal);
        tv_notification_normal.setOnClickListener(this);
        tv_notification_progress = (TextView) findViewById(R.id.tv_notification_progress);
        tv_notification_progress.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 自定义普通通知
            case R.id.tv_notification_normal:

                notifyFirstNotification();

                break;
            // 自定义进度条通知
            case R.id.tv_notification_progress:


                break;
        }
    }
    private void notifyFirstNotification()
    {
        Intent intent = new Intent(this, MainActivity.class);
        /*
         * 调用PendingIntent的静态放法创建一个 PendingIntent对象用于点击通知之后执行的操作，
         * PendingIntent可以理解为延时的Intent，在这里即为点击通知之后执行的Intent
         * 这里调用getActivity(Context context, int requestCode, Intent intent, int flag)方法
         * 表示这个PendingIntent对象启动的是Activity，类似的还有getService方法、getBroadcast方法
         */
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);

        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("通知1") // 创建通知的标题
                .setContentText("这是第一个通知") // 创建通知的内容
                .setSmallIcon(R.mipmap.back) // 创建通知的小图标
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                        R.mipmap.course_default_bg)) // 创建通知的大图标
        /*
         * 首先，无论你是使用自定义视图还是系统提供的视图，上面4的属性一定要设置，不然这个通知显示不出来
         */
                .setWhen(System.currentTimeMillis()) // 设定通知显示的时间
                .setContentIntent(pi) // 设定点击通知之后启动的内容，这个内容由方法中的参数：PendingIntent对象决定
                .setPriority(NotificationCompat.PRIORITY_MAX) // 设置通知的优先级
                .setAutoCancel(true) // 设置点击通知之后通知是否消失

        /*
         * 设置震动，用一个 long 的数组来表示震动状态，这里表示的是先震动1秒、静止1秒、再震动1秒，这里以毫秒为单位
         * 如果要设置先震动1秒，然后停止0.5秒，再震动2秒则可设置数组为：long[]{1000, 500, 2000}。
         * 别忘了在AndroidManifest配置文件中申请震动的权限
         */
                .setVibrate(new long[]{1000, 0, 1000})
        /*
         * 设置手机的LED灯为蓝色并且灯亮2秒，熄灭1秒，达到灯闪烁的效果，不过这些效果在模拟器上是看不到的，
         * 需要将程序安装在真机上才能看到对应效果，如果不想设置这些通知提示效果，
         * 可以直接设置：setDefaults(Notification.DEFAULT_ALL);
         * 意味将通知的提示效果设置为系统的默认提示效果
         */
                .setLights(Color.BLUE, 2000, 1000)
                .build(); // 创建通知（每个通知必须要调用这个方法来创建）
        /*
         * 使用从系统服务获得的通知管理器发送通知，第一个参数是通知的id，不同的通知应该有不同的id，
         * 这样当我们要取消哪条通知的时候我们调用notificationManager（通知管理器）.cancel(int id)
         * 方法并传入发送通知时的对应id就可以了。在这里如果我们要取消这条通知，
         * 我们调用notificationManager.cancel(1);就可以了
         * 第二个参数是要发送的通知对象
         */
        notificationManager.notify(1, notification);
    }
}
