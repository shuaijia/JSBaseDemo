package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jia.demo.R;
import com.jia.demo.base.BaseApplication;
import com.jia.demo.db.domain.AA;
import com.jia.demo.db.domain.AADao;

import java.util.List;

/**
 * Describtion: 数据库测试Activity
 * Created by jia on 2017/3/31 0031.
 * 人之所以能，是相信能
 */

/**
 * greendao中的注解
 * <p/>
 * (一) @Entity 定义实体
 *
 * @nameInDb 在数据库中的名字，如不写则为实体中类名
 * @indexes 索引
 * @createInDb 是否创建表，默认为true,false时不创建
 * @schema 指定架构名称为实体
 * @active 无论是更新生成都刷新
 * (二) @Id
 * (三) @NotNull 不为null
 * (四) @Unique 唯一约束
 * (五) @ToMany 一对多
 * (六) @OrderBy 排序
 * (七) @ToOne 一对一
 * (八) @Transient 不存储在数据库中
 * (九) @generated 由greendao产生的构造函数或方法
 */
public class DBActivity extends Activity {

    private TextView tv_db_content;
    private Button bt_db_add;
    private Button bt_db_delete;
    private Button bt_db_update;
    private Button bt_db_quaryone;
    private Button bt_db_quaryall;

    private AADao mAADao;
    private long i = 1;
    String con="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greendao);

        tv_db_content = (TextView) findViewById(R.id.tv_db_content);
        bt_db_add = (Button) findViewById(R.id.bt_db_add);
        bt_db_delete = (Button) findViewById(R.id.bt_db_delete);
        bt_db_update = (Button) findViewById(R.id.bt_db_update);
        bt_db_quaryone = (Button) findViewById(R.id.bt_db_quaryone);
        bt_db_quaryall = (Button) findViewById(R.id.bt_db_quaryall);

        // 获取Dao实例来操作数据库
        mAADao = BaseApplication.getInstances().getDaoSession().getAADao();

        mAADao.insert(new AA(i++, "haha"+i));
        mAADao.insert(new AA(i++, "haha"+i));
        mAADao.insert(new AA(i++, "haha"+i));


        bt_db_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData(new AA(i++, "add"+i));
            }
        });

        bt_db_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });

        bt_db_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

        bt_db_quaryone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quaryOne();
            }
        });

        bt_db_quaryall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quaryAll();
            }
        });
    }

    /**
     * 向数据库添加数据
     */
    private void addData(AA aa) {

        mAADao.insert(aa);

        quaryAll();
    }

    /**
     * 删除数据
     */
    private void delete() {
        mAADao.deleteByKey((long) 1);

        quaryAll();
    }

    /**
     * 修改数据
     */
    private void update() {
        AA aa = new AA((long) 2, "jia");
        mAADao.update(aa);

        quaryAll();
    }

    /**
     * 按条件查找
     */
    private void quaryOne() {
        List<AA> list = mAADao.queryBuilder()
                .where(AADao.Properties.Id.notEq(3))
                .build().list();

        if (list != null && list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                tv_db_content.setText(list.get(i).getNote() + "\n");
            }
        } else {
            tv_db_content.setText("数据库中没有数据");
        }

    }

    /**
     * 查询数据库
     */
    private void quaryAll() {

        List<AA> list = mAADao.loadAll();
        if (list != null && list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                con=con+list.get(i).getNote()+" ";
                tv_db_content.setText(con);
            }
        } else {
            tv_db_content.setText("数据库中没有数据");
        }
    }

}
