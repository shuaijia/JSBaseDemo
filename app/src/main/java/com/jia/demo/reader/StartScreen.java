package com.jia.demo.reader;

import java.io.IOException;
import java.io.InputStream;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.epub.EpubReader;
import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

import com.jia.demo.R;

public class StartScreen extends Activity {
    /** Called when the activity is first created. */
	ViewPager mViewPager;
	Book book;
	boolean mComputed = false;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        mViewPager = (ViewPager)findViewById(R.id.pages);
        mViewPager.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			
			@Override
			public void onGlobalLayout() {
				Log.d("Reader", "Ready");
				if (mComputed) return;
				mComputed = true;
				
				Log.d("Reader", "Start");
				
				ComputeBook processor = new ComputeBook(StartScreen.this, book, mViewPager.getMeasuredWidth(), mViewPager.getMeasuredHeight());
				processor.compute(new ComputeBook.ComputeListener() {
					
					@Override
					public void finished(final int[] chapters, final int pages) {
						Log.d("Reader", "Pages: " + pages);
						
						runOnUiThread(new Runnable() {
							
							@Override
							public void run() {
								mViewPager.setAdapter(new EpubPageAdapter(StartScreen.this, book, pages, chapters));
								mViewPager.setCurrentItem(0);
							}
						});
						
					}
				});
			}
		});

        AssetManager assetManager = getAssets();
        
		InputStream epubInputStream;
		try {
			epubInputStream = assetManager.open("bbb.epub");
			book = (new EpubReader()).readEpub(epubInputStream);
		} catch (IOException e) {}
		
		

		Log.i("Reader", "Loading book");
		int[] cha={1,2,3};
		mViewPager.setAdapter(new EpubPageAdapter(this, book,5,cha));
		
		Log.i("Reader", "Loading chapter");
		mViewPager.setCurrentItem(0);
		Log.i("Reader", "Chapter loaded");

    }
    
}