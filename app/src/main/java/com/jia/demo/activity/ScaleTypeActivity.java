package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jia.demo.R;

public class ScaleTypeActivity extends Activity {

    public static final String IMG_URL = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503981352255&di=2c9ee62939e285279b14ed4ed90c49e3&imgtype=0&src=http%3A%2F%2Fimgq.duitang.com%2Fuploads%2Fitem%2F201503%2F08%2F20150308122926_PiQ2K.jpeg";

    private ImageView iv_default;
    private ImageView iv_fitCenter;
    private ImageView iv_center;
    private ImageView iv_centerCrop;
    private ImageView iv_centerInside;
    private ImageView iv_fitEnd;
    private ImageView iv_fitXY;
    private ImageView iv_matrix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_type);

        iv_default = (ImageView) findViewById(R.id.iv_default);
        iv_fitCenter = (ImageView) findViewById(R.id.iv_fitCenter);
        iv_center = (ImageView) findViewById(R.id.iv_center);
        iv_centerCrop = (ImageView) findViewById(R.id.iv_centerCrop);
        iv_centerInside = (ImageView) findViewById(R.id.iv_centerInside);
        iv_fitEnd = (ImageView) findViewById(R.id.iv_fitEnd);
        iv_fitXY = (ImageView) findViewById(R.id.iv_fitXY);
        iv_matrix = (ImageView) findViewById(R.id.iv_matrix);

        Log.e("Tag", "onCreate: " + iv_default.getScaleType());

        Glide.with(this)
                .load(IMG_URL)
                .into(iv_default);

        Glide.with(this)
                .load(IMG_URL)
                .into(iv_fitCenter);

        Glide.with(this)
                .load(IMG_URL)
                .into(iv_center);

        Glide.with(this)
                .load(IMG_URL)
                .into(iv_centerCrop);

        Glide.with(this)
                .load(IMG_URL)
                .into(iv_centerInside);

        Glide.with(this)
                .load(IMG_URL)
                .into(iv_fitEnd);

        Glide.with(this)
                .load(IMG_URL)
                .into(iv_fitXY);

        Glide.with(this)
                .load(IMG_URL)
                .into(iv_matrix);

    }
}
