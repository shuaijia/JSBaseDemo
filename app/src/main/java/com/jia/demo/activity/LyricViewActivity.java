package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.jia.demo.R;
import com.jia.demo.music.LyricInfo;
import com.jia.demo.music.LyricParser;

import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义  歌词显示 View
 */
public class LyricViewActivity extends Activity {

    private TextView tv_lyric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyric_view);

        tv_lyric = (TextView) findViewById(R.id.tv_lyric);

        try {
            InputStream is = getAssets().open("beijing.lrc");
            LyricInfo lyricInfo = LyricParser.initLyric(is, "utf-8");
            StringBuffer stringBuffer = new StringBuffer();
            if(lyricInfo != null && lyricInfo.getLines() != null) {
                int size = lyricInfo.getLines().size();
                for (int i = 0; i < size; i ++) {
                    stringBuffer.append(lyricInfo.getLines().get(i).getContent() + "\n");
                }
                tv_lyric.setText(stringBuffer.toString());
            }else{
                tv_lyric.setText("解析失败");
            }

        } catch (IOException e) {
            e.printStackTrace();
            tv_lyric.setText("解析失败");
        }
    }
}
