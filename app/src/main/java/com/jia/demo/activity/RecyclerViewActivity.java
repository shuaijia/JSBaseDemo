package com.jia.demo.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.View;

import com.jia.demo.R;
import com.jia.demo.adapter.PubuAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Describtion: 瀑布流测试类
 * Created by jia on 2017/6/22.
 * 人之所以能，是相信能
 */
public class RecyclerViewActivity extends Activity{

    private RecyclerView rv_pubu;
    private List<String> imgs=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        rv_pubu= (RecyclerView) findViewById(R.id.rv_pubu);
        final LinearLayoutManager ll=new LinearLayoutManager(RecyclerViewActivity.this);
        rv_pubu.setLayoutManager(ll);


        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498110887285&di=ae381e53991dc0c9303864ddcac3f3b8&imgtype=0&src=http%3A%2F%2Fcdnq.duitang.com%2Fuploads%2Fitem%2F201409%2F18%2F20140918231127_LZQjr.png");
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498110887284&di=a9c4f224893ad7f984bf9461eb7226ff&imgtype=0&src=http%3A%2F%2Fimg4q.duitang.com%2Fuploads%2Fitem%2F201409%2F30%2F20140930233607_mXYik.jpeg");
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498110887285&di=fded56651a706f60412c00177dfb3e09&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F9c16fdfaaf51f3defb13b4439eeef01f3a297977.jpg");
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498110887285&di=ae381e53991dc0c9303864ddcac3f3b8&imgtype=0&src=http%3A%2F%2Fcdnq.duitang.com%2Fuploads%2Fitem%2F201409%2F18%2F20140918231127_LZQjr.png");
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498110887285&di=fded56651a706f60412c00177dfb3e09&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F9c16fdfaaf51f3defb13b4439eeef01f3a297977.jpg");
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498110887285&di=2dabbc7b01140d9e9a97bedd8a2a2fd8&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Ffd039245d688d43f4c195ed5771ed21b0ef43b61.jpg");
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498110887283&di=f2210b8eb94211d055928c32553b7b2d&imgtype=0&src=http%3A%2F%2Ftupian.enterdesk.com%2F2012%2F0602%2Fyt%2F18%2F73869f30446c7978916445105b015d97.jpg");
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498110887285&di=2dabbc7b01140d9e9a97bedd8a2a2fd8&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Ffd039245d688d43f4c195ed5771ed21b0ef43b61.jpg");
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498110887283&di=f2210b8eb94211d055928c32553b7b2d&imgtype=0&src=http%3A%2F%2Ftupian.enterdesk.com%2F2012%2F0602%2Fyt%2F18%2F73869f30446c7978916445105b015d97.jpg");
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498110887283&di=1049938e2e341cfeb80475217c2fa580&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201508%2F28%2F20150828215515_wtuLm.jpeg");
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498110887283&di=1049938e2e341cfeb80475217c2fa580&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201508%2F28%2F20150828215515_wtuLm.jpeg");
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1498110887283&di=1049938e2e341cfeb80475217c2fa580&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201508%2F28%2F20150828215515_wtuLm.jpeg");

        PubuAdapter adapter=new PubuAdapter(imgs,this);
        rv_pubu.setAdapter(adapter);


    }
}
