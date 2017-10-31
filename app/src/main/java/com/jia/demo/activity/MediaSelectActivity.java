package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;



/**
 * 多媒体（照片、视频）选择
 */
public class MediaSelectActivity extends Activity {

//    private List<MediaEntity> mPickList = new ArrayList<>();
//    private MediaAdapter adapter;

    private RecyclerView rv_media_pick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_media_select);
//
//        rv_media_pick= (RecyclerView) findViewById(R.id.rv_media_pick);

//        Phoenix.with()
//                .theme(PhoenixOption.THEME_DEFAULT)// theme
//                .fileType(MimeType.ofAll())//Display file type images, video, image and video
//                .maxPickNumber(10)// Maximum number of options
//                .minPickNumber(0)// Minimum number of options
//                .spanCount(4)// The number of displays per row
//                .pickMode(PhoenixConstant.MULTIPLE)// Multiple choice/option
//                .enablePreview(true)// Whether to open a preview
//                .enableCamera(true)// Whether to open a photo or not
//                .enableAnimation(true)// Select interface image to click effect
//                .enableCompress(true)// Open compression
//                .thumbnailHeight(160)// Select the image height of the interface
//                .thumbnailWidth(160)// Select interface image width
//                .enableClickSound(true)//ƒ Whether to turn on the click sound
//                .pickedMediaList(pickList)// Selected image data
//                .videoSecond(0)//Show video within seconds
//                .onPickerListener(new OnPickerListener() {
//                    @Override
//                    public void onPickSuccess(List<MediaEntity> pickList) {
//                        adapter.setList(pickList);
//                        adapter.notifyDataSetChanged();
//                    }
//
//                    @Override
//                    public void onPickFailed(String errorMessage) {
//
//                    }
//                })//Open function, TYPE_PICK_MEDIA - select the image/video/audio TYPE_TAKE_PICTURE - to take a picture
//                .start(MediaSelectActivity.this, PhoenixOption.TYPE_PICK_MEDIA);
    }
}
