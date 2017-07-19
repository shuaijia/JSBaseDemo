package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;

import com.jia.demo.R;
import com.joanzapata.pdfview.PDFView;

/**
 * Describtion:pdf阅读
 * Created by jia on 2017/7/18.
 * 人之所以能，是相信能
 */
public class PDFActivity extends Activity {

    private PDFView pdfview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        pdfview= (PDFView) findViewById(R.id.pdfview);
        pdfview.fromAsset("aaa.pdf")
                .pages(0,1,2)
                .defaultPage(0)
                .showMinimap(false)
                .enableSwipe(true)
//                .onDraw(onDrawListener)
//                .onLoad(onLoadCompleteListener)
//                .onPageChange(onPageChangeListener)
                .load();
//        pdfView.fromAsset("aaa.pdf")
//                .pages() // all pages are displayed by default
//                .enableSwipe(true) // allows to block changing pages using swipe
//                .swipeHorizontal(false)
//                .enableDoubletap(true)
//                .defaultPage(0)
//                // allows to draw something on the current page, usually visible in the middle of the screen
////                .onDraw(onDrawListener)
////                // allows to draw something on all pages, separately for every page. Called only for visible pages
////                .onDrawAll(onDrawListener)
////                .onLoad(onLoadCompleteListener) // called after document is loaded and starts to be rendered
////                .onPageChange(onPageChangeListener)
////                .onPageScroll(onPageScrollListener)
////                .onError(onErrorListener)
////                .onRender(onRenderListener) // called after document is rendered for the first time
//                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
//                .password(null)
//                .scrollHandle(null)
//                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
//                // spacing between pages in dp. To define spacing color, set view background
//                .spacing(0)
//                .load();
    }
}
