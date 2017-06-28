package com.jia.demo.base;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.jia.demo.db.domain.DaoMaster;
import com.jia.demo.db.domain.DaoSession;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Describtion:
 * Created by jia on 2017/4/5 0005.
 * 人之所以能，是相信能
 */

/**
 * DaoMaster:
 * DaoMaster保存了数据库对象和管理DAO类的classes，
 * 其提供了一些静态方法创建和删除表，内部类OpenHelper
 * 和DevOpenHelper 实现了SQLiteOpenHelper并创建数据库的框架。
 * DaoSession：
 * 管理所有可用的DAO对象，可以通过getter方法获得。DaoSession
 * 还提供了一些通用的持久性方法比如插入、加载、更新,刷新和删除实体。
 * DAOs:
 * 数据访问对象，每一个实体类都有对应的greenDAO对象。
 * Entities：
 * 实体类对象
 */
public class BaseApplication extends Application {

    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    public static BaseApplication instances;

    private static Context mContext;

    public static BaseApplication getInstances(){
        return instances;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;

        mContext=this;

        setGreenDaoConfig();

    }

    /**
     * 配置数据库
     */
    private void setGreenDaoConfig(){
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        mHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
    public SQLiteDatabase getDb() {
        return db;
    }

    public static Context getApplicationcontext(){
        return mContext;
    }
}
