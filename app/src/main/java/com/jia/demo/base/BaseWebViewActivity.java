package com.jia.demo.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.jia.demo.R;

/**
 * Describtion: 网页WebView的基类
 * Created by jia on 2017/3/24 0024.
 * 人之所以能，是相信能
 */
public class BaseWebViewActivity extends Activity {

    public final static String WEB_URL = "url";

    private TextView tv_title;

    private ImageView iv_back;

    private TextView tv_todo;

    private WebView webView;

    private ProgressBar progressbar;


    private String url = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 去除标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 锁定竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_web);

        // 获取传进来的url
        url = getIntent().getStringExtra(WEB_URL);

        initView();

        configWebView();
    }

    /**
     * 设置WebView
     */
    private void configWebView() {
        WebSettings wSet = webView.getSettings();
        //设置是否支持JS交互，不设置页面显示不出来
        wSet.setJavaScriptEnabled(true);
        //设置适应屏幕
        wSet.setUseWideViewPort(true);
        wSet.setLoadWithOverviewMode(true);
        //支持缩放
        wSet.setSupportZoom(true);
        wSet.setBuiltInZoomControls(true);
        //设置数据格式，这样能在一定程度上节省资源
        wSet.setDefaultTextEncodingName("UTF-8");
        wSet.setRenderPriority(WebSettings.RenderPriority.HIGH);
        //隐藏原生缩放控件
//        wSet.setDisplayZoomControls(false);
//        wSet.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        //设置 缓存模式
        wSet.setCacheMode(WebSettings.LOAD_DEFAULT);
        // 开启 DOM storage API 功能
        wSet.setDomStorageEnabled(true);
        //开启 database storage API 功能
        wSet.setDatabaseEnabled(true);
        String cacheDirPath = getFilesDir().getAbsolutePath();
        Log.i("BaseWebViewActivity", "cacheDirPath="+cacheDirPath);
        //设置数据库缓存路径
        wSet.setDatabasePath(cacheDirPath);
        //设置  Application Caches 缓存目录
        wSet.setAppCachePath(cacheDirPath);
        //开启 Application Caches 功能
        wSet.setAppCacheEnabled(true);

        wSet.setBuiltInZoomControls(false);


        wSet.setAllowContentAccess(true);

        webView.loadUrl("http://www.oschina.net/question/54100_34836");
//        webView.loadUrl(url);
//        "file:///mnt/sdcard/database/taobao.html"
        /**
         * 加载缓存到本地的html文件
         */
//        webView.loadUrl("file:///mnt/sdcard/test/ququ.html");

        webView.setWebChromeClient(new WebChromeClient() {

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                Log.e("Tag","");
                return super.onJsAlert(view, url, message, result);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                if (TextUtils.isEmpty(title)) {
                    tv_title.setText(title);
                }
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progressbar.setProgress(newProgress);
                if (100 == newProgress) {
                    progressbar.setVisibility(View.GONE);
                }
            }
        });

        webView.setWebViewClient(new WebViewClient() {



            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressbar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressbar.setVisibility(View.GONE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return true;
            }
        });
    }

    /**
     * 初始化布局ui
     */
    private void initView() {

        tv_title = (TextView) findViewById(R.id.tv_title);

        iv_back = (ImageView) findViewById(R.id.iv_back);

        tv_todo = (TextView) findViewById(R.id.tv_todo);

        webView = (WebView) findViewById(R.id.webview);

        progressbar = (ProgressBar) findViewById(R.id.progressbar);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(webView.canGoBack()){
                    webView.goBack();
                }else{
                    finish();
                }
            }
        });
    }
}
