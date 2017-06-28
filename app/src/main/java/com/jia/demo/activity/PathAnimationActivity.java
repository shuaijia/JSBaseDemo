package com.jia.demo.activity;

import android.app.Activity;
import android.graphics.Path;
import android.os.Bundle;

import com.jia.demo.R;
import com.mcxtzhang.pathanimlib.PathAnimView;
import com.mcxtzhang.pathanimlib.StoreHouseAnimView;
import com.mcxtzhang.pathanimlib.res.StoreHousePath;
import com.mcxtzhang.pathanimlib.utils.PathParserUtils;
import com.mcxtzhang.pathanimlib.utils.SvgPathParser;

import java.text.ParseException;

/**
 * Describtion:
 * Created by jia on 2017/6/26.
 * 人之所以能，是相信能
 */
public class PathAnimationActivity extends Activity {

    private PathAnimView pathAnimView;
    private StoreHouseAnimView storeHouseAnimView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_animation);
        pathAnimView= (PathAnimView) findViewById(R.id.pathAnimView);
        storeHouseAnimView= (StoreHouseAnimView) findViewById(R.id.storeHouseAnimView);

        Path sPath = new Path();
        sPath.moveTo(0, 0);
        sPath.addCircle(40, 40, 30, Path.Direction.CW);

        pathAnimView.setSourcePath(sPath);

        pathAnimView.startAnim();

        storeHouseAnimView.setSourcePath(PathParserUtils.getPathFromArrayFloatList(StoreHousePath.getPath("WHATY", 1.5f, 15)));


        storeHouseAnimView.startAnim();
    }
}
