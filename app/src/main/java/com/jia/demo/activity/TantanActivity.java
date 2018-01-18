package com.jia.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.jia.demo.R;
import com.jia.demo.adapter.TanTanAdapter;
import com.mcxtzhang.layoutmanager.swipecard.CardConfig;
import com.mcxtzhang.layoutmanager.swipecard.OverLayCardLayoutManager;
import com.mcxtzhang.layoutmanager.swipecard.RenRenCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * 仿探探卡片
 */
public class TantanActivity extends AppCompatActivity {

    private RecyclerView rv_tantan;

    private TanTanAdapter adapter;

    private List<String> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tantan);

        rv_tantan= (RecyclerView) findViewById(R.id.rv_tantan);

        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516267681618&di=a2c8566c98702c3323e5b25a7c11f476&imgtype=jpg&src=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D4118604426%2C3060447613%26fm%3D214%26gp%3D0.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516267678996&di=0f5ad49657ff21d6230c0ad6cbca15da&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2F2015%2Fa1%2F140%2Fd%2F82.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516267675843&di=607dc544d3ac85d3e98f06d61e4bcd61&imgtype=0&src=http%3A%2F%2Fimage142-c.poco.cn%2Fmypoco%2Fmyphoto%2F20130716%2F21%2F5570301820130716210707071.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516267752938&di=8efdda980885fced5bac05d4d11ae2b7&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2F2015%2Fa1%2F78%2Fd%2F248.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516267747558&di=777c2dde5575aa517e5194079e803f3b&imgtype=0&src=http%3A%2F%2Fwww.bz55.com%2Fuploads%2Fallimg%2F150421%2F140-150421112R8.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516267743520&di=fd16d699c769ba856757eea97af7a916&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2F2015%2Fa1%2F95%2Fd%2F149.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516267740338&di=df3b5437c0b4deb342cbea914dca5957&imgtype=0&src=http%3A%2F%2Fimg3.xiazaizhijia.com%2Fwalls%2F20150929%2F1024x768_95391b8b9392d41.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516267736684&di=e1da94406a0656c60b92840965080642&imgtype=0&src=http%3A%2F%2Fimg05.tooopen.com%2Fimages%2F20140902%2Fsy_70028195254.jpg");


        adapter=new TanTanAdapter(this,list);

        rv_tantan.setLayoutManager(new OverLayCardLayoutManager());

        rv_tantan.setAdapter(adapter);

        CardConfig.initConfig(this);
        ItemTouchHelper.Callback callback = new RenRenCallback(rv_tantan, adapter, list);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(rv_tantan);
    }

}
