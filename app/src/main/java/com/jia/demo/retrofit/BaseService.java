package com.jia.demo.retrofit;


import com.jia.demo.bean.ZQBanner;
import com.jia.demo.bean.ZQLive;
import com.jia.demo.bean.ZQLogin;
import com.jia.demo.bean.ZQLoginNew;
import com.jia.demo.bean.ZQRemen;
import com.jia.demo.bean.ZQTuijian;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Describtion:
 * Created by jia on 2017/6/6.
 * 人之所以能，是相信能
 */
public interface BaseService {

    @POST("mobile/login_mobileLogin.action")
    Call<ZQLogin> login(@Query("loginId") String username, @Query("passwd") String password);

    @POST("mobile/login_mobileLogin.action")
    Observable<ZQLogin> loginWithRxjava(@Query("loginId") String username, @Query("passwd") String password);

    @POST("/usesql/noLoginuserdef/newUserDefined_getBySql.action?queryId=AppHotMain&page.pageSize=4&page.curPage=1&data=info&page.searchItem.showSql=true")
    Observable<ZQRemen> getRemenData();

    @POST("/usesql/noLoginuserdef/newUserDefined_getBySql.action?queryId=siku&page.pageSize=5&page.curPage=1&data=info&page.searchItem.showSql=true")
    Observable<HttpResult<ZQBanner>> getBannerData();

    @POST("/usesql/noLoginuserdef/newUserDefined_getBySql.action?queryId=appZhibo&page.pageSize=10&page.curPage=1&data=info&page.searchItem.showSql=true")
    Observable<HttpResult<ZQLive>> getLive();

    @POST("mobile/login_mobileLogin.action")
    Observable<HttpResult<List<ZQLoginNew>>> loginNew(@Query("loginId") String username, @Query("passwd") String password);

    @POST("/entity/mobile/newUserDefined_getBySql.action?queryId=AppCommend&page.pageSize=4&page.curPage=1&data=info&page.searchItem.showSql=true")
    Observable<HttpResult<ZQTuijian>> getTuijian();
}
