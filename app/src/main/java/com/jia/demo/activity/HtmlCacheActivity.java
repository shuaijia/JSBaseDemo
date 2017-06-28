package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.jia.demo.R;
import com.jia.demo.utils.WebViewUtils;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Describtion:
 * Created by jia on 2017/3/24 0024.
 * 人之所以能，是相信能
 */
public class HtmlCacheActivity extends Activity {


    private TextView tv;

    private String url="http://ququ.lovek12.com/";

    private Handler mHandler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html_cache);
        tv= (TextView) findViewById(R.id.tv_html_cache);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                   final String content=WebViewUtils.testGetHtml(url);




                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            writeFileToSD(content);
                            tv.setText(content);
                        }
                    });


                } catch (Exception e) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText("未获取到");
                        }
                    });
                }
            }
        }).start();

    }

    private void writeFileToSD(String content) {
        String sdStatus = Environment.getExternalStorageState();
        if(!sdStatus.equals(Environment.MEDIA_MOUNTED)) {
            Log.d("TestFile", "SD card is not avaiable/writeable right now.");
            return;
        }
        try {
            String pathName="/sdcard/test/";
            String fileName="ququ.html";
            File path = new File(pathName);
            File file = new File(pathName + fileName);
            if( !path.exists()) {
                Log.d("TestFile", "Create the path:" + pathName);
                path.mkdir();
            }
            if( !file.exists()) {
                Log.d("TestFile", "Create the file:" + fileName);
                file.createNewFile();
            }
            FileOutputStream stream = new FileOutputStream(file);
            byte[] buf = content.getBytes();
            stream.write(buf);
            stream.close();
            Toast.makeText(HtmlCacheActivity.this,"保存成功",Toast.LENGTH_LONG).show();
        } catch(Exception e) {
            Log.e("TestFile", "Error on writeFilToSD."+e.toString());
            e.printStackTrace();
        }
    }
}
