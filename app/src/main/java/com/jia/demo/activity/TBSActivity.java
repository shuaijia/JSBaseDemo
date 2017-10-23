package com.jia.demo.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jia.demo.R;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/**
 * 腾讯浏览服务
 */
public class TBSActivity extends Activity {

    private static final String TAG = "TBSActivity";

    private TextView tv_title;

    private ImageView iv_back;

    private TextView tv_todo;

    private WebView webview;

    private ProgressBar progressbar;


    private String url = "http://blog.csdn.net/jiashuai94";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tbs);

        webview= (WebView) findViewById(R.id.webview);

        webview.loadUrl(url);

        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                Log.e(TAG, "shouldOverrideUrlLoading: "+s );
                return super.shouldOverrideUrlLoading(webView, s);
            }

            @Override
            public void onLoadResource(WebView webView, String s) {
                Log.e(TAG, "onLoadResource: "+s );
                super.onLoadResource(webView, s);
            }

            @Override
            public void onPageStarted(WebView webView, String s, Bitmap bitmap) {
                super.onPageStarted(webView, s, bitmap);
                Log.e(TAG, "onPageStarted: "+s );
            }

            @Override
            public void onPageFinished(WebView webView, String s) {
                super.onPageFinished(webView, s);
                Log.e(TAG, "onPageFinished: "+s );
            }
        });

        webview.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                Log.e(TAG, "onProgressChanged: "+i );
            }
        });
    }
}
