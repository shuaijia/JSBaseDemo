package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.jia.demo.bean.ZQBanner;
import com.jia.demo.bean.ZQLive;
import com.jia.demo.bean.ZQLogin;
import com.jia.demo.bean.ZQLoginNew;
import com.jia.demo.bean.ZQRemen;
import com.jia.demo.bean.ZQTuijian;
import com.jia.demo.retrofit.BaseService;
import com.jia.demo.retrofit.HttpMethod;
import com.jia.demo.retrofit.ProgressSubscriber;
import com.jia.demo.retrofit.UrlConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;

/**
 * Describtion: Retrofit界面
 *
 * 调用subscriber的unsubscribe方法取消请求
 *
 * Created by jia on 2017/6/6.
 * 人之所以能，是相信能
 */
public class RetrofitActivity extends Activity {

    public static final String TAG="RetrofitActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        callServer();

//        callServerRxJava();

//        fengzhuangRetrofitRxjava();

//        getRemenData();

//        getBanner();

//        getLive();

//        loginNew();

//        getTuijian();

        fengzhuangRetrofitRxjava();
    }

    /**
     * retrofit
     */
    private void callServer(){
        // 创建retrofit对象
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(UrlConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) // gson解析
                .build();

        BaseService service= retrofit.create(BaseService.class);

        Call<ZQLogin> call=service.login("13693510929","123456");
        call.enqueue(new Callback<ZQLogin>() {
            @Override
            public void onResponse(Call<ZQLogin> call, Response<ZQLogin> response) {
                ZQLogin model=response.body();
                Log.e(TAG, "onResponse: "+response.body().toString());
            }

            @Override
            public void onFailure(Call<ZQLogin> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });
    }

    /**
     * retrofit+rxjava
     */
//    private void callServerRxJava(){
//        // 创建retrofit对象
//        Retrofit retrofit=new Retrofit.Builder()
//                .baseUrl(UrlConfig.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create()) // gson解析
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 支持rxjava
//                .build();
//
//        BaseService service= retrofit.create(BaseService.class);
//
//        service.loginWithRxjava("13693510929","123456")
//                .subscribeOn(Schedulers.io()) // 子线程执行
//                .observeOn(AndroidSchedulers.mainThread())  // 主线程回调
//                .subscribe(new Subscriber<ZQLogin>() {  // 回调
//                    @Override
//                    public void onCompleted() {
//                        Log.e(TAG, "onCompleted: ");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "onError: "+e.getMessage() );
//                    }
//
//                    @Override
//                    public void onNext(ZQLogin zqLogin) {
//                        Log.e(TAG, "onNext: "+zqLogin.toString() );
//                    }
//                });
//    }

    /**
     * 封装retrofit+rxjava
     */
    private void fengzhuangRetrofitRxjava(){
        HttpMethod.getInstance().login("13693510929", "123456", new Subscriber<ZQLogin>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "onCompleted: " );
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: "+e.getMessage() );
            }

            @Override
            public void onNext(ZQLogin zqLogin) {
                Log.e(TAG, "onNext: "+zqLogin.toString() );
            }
        });
    }

    /**
     * 获取热门数据
     */
    private void getRemenData(){
        HttpMethod.getInstance().getRemenData(new Subscriber<ZQRemen>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "remen onCompleted: " );
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "remen onError: "+e.getMessage() );
            }

            @Override
            public void onNext(ZQRemen zqRemen) {
                Log.e(TAG, " remen onNext: "+zqRemen.toString() );
            }
        });
    }

    /**
     * 预处理errorCode与errorMsg
     */
    private void getBanner(){
        HttpMethod.getInstance().getBanner(new Subscriber<ZQBanner>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "banner onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "banner onError: "+e.getMessage() );
            }

            @Override
            public void onNext(ZQBanner zqBanner) {
                Log.e(TAG, "banner onNext: "+zqBanner.toString() );
            }
        });
    }

    /**
     * 获取直播数据
     */
    private void getLive(){
        HttpMethod.getInstance().getLive(new ProgressSubscriber<ZQLive>() {
            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: "+e.getMessage() );
            }

            @Override
            public void onNext(ZQLive zqLive) {
                Log.e(TAG, "onNext: "+zqLive.toString() );
            }
        });
    }

    /**
     * 新的登录方法
     */
    private void loginNew(){
        HttpMethod.getInstance().loginNew("13693510929", "000000", new ProgressSubscriber<List<ZQLoginNew>>() {
            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: "+e.getMessage() );
            }

            @Override
            public void onNext(List<ZQLoginNew> zqLoginNews) {
                Log.e(TAG, "onNext: "+zqLoginNews.size() );
            }
        });
    }

    /**
     * 获取推荐
     */
    private void getTuijian(){
        HttpMethod.getInstance().getTuijian(new ProgressSubscriber<ZQTuijian>() {
            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: "+e.getMessage() );
            }

            @Override
            public void onNext(ZQTuijian zqTuijian) {
                Log.e(TAG, "onNext: "+zqTuijian.toString() );
            }
        });
    }
}
