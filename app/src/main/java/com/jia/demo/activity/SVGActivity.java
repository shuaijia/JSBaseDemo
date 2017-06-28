package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.jia.demo.R;

/**
 * Describtion: SVG格式图片，缩放后而不失真，缩放是相对于svg的xml文件中的大小
 * Created by jia on 2017/6/26.
 * 人之所以能，是相信能
 */
public class SVGActivity extends Activity {

    private ImageView iv1;
    private ImageView iv3;
    private ImageView iv2;
    private ImageView iv4_svg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg);
//        iv1= (ImageView) findViewById(R.id.iv1_svg);
//        iv3= (ImageView) findViewById(R.id.iv3_svg);
//        iv2= (ImageView) findViewById(R.id.iv2_svg);
//        iv4_svg= (ImageView) findViewById(R.id.iv4_svg);
//
//        // 加载AndroidStudio工具生成的svg图片
//        iv1.setImageResource(R.drawable.svg_as_material);
//        iv3.setImageResource(R.drawable.svg_as_material);
//
//        // 加载网络工具生成的svg动画
//        iv2.setImageResource(R.drawable.svg_loading);
//
//        iv4_svg.setImageResource(R.drawable.svg_yun);
    }
}
