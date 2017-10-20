package com.jia.demo.activity;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.florent37.camerafragment.CameraFragment;
import com.github.florent37.camerafragment.configuration.Configuration;
import com.github.florent37.camerafragment.listeners.CameraFragmentResultListener;
import com.github.florent37.camerafragment.listeners.CameraFragmentStateListener;
import com.github.florent37.camerafragment.widgets.CameraSettingsView;
import com.github.florent37.camerafragment.widgets.CameraSwitchView;
import com.github.florent37.camerafragment.widgets.FlashSwitchView;
import com.github.florent37.camerafragment.widgets.MediaActionSwitchView;
import com.github.florent37.camerafragment.widgets.RecordButton;
import com.jia.demo.R;

import java.io.File;

public class CameraActivity extends FragmentActivity implements View.OnClickListener {

    private CameraFragment cameraFragment;

    private FrameLayout fl_camera;

    // 拍摄
    private RecordButton bt_take_photo;
    // 照片、视频切换
    private MediaActionSwitchView bt_action_switch;
    // 闪光灯
    private FlashSwitchView bt_flash_switch;
    // 摄像头
    private CameraSwitchView bt_camera_switch;
    // 设置
    private CameraSettingsView bt_setting;


    private String fileName=".jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        fl_camera = (FrameLayout) findViewById(R.id.fl_camera);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        cameraFragment = CameraFragment.newInstance(new Configuration.Builder().build());

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_camera, cameraFragment, "tag")
                .commit();

        // 拍摄
        bt_take_photo = (RecordButton) findViewById(R.id.bt_take_photo);
        bt_take_photo.setOnClickListener(this);
        // 照片、视频切换
        bt_action_switch = (MediaActionSwitchView) findViewById(R.id.bt_action_switch);
        bt_action_switch.setOnClickListener(this);
        // 闪光灯
        bt_flash_switch = (FlashSwitchView) findViewById(R.id.bt_flash_switch);
        bt_flash_switch.setOnClickListener(this);
        // 摄像头
        bt_camera_switch = (CameraSwitchView) findViewById(R.id.bt_camera_switch);
        bt_camera_switch.setOnClickListener(this);
        // 设置
        bt_setting = (CameraSettingsView) findViewById(R.id.bt_setting);
        bt_setting.setOnClickListener(this);


        cameraFragment.setStateListener(new CameraFragmentStateListener() {
            @Override
            public void onCurrentCameraBack() {

            }

            @Override
            public void onCurrentCameraFront() {

            }

            @Override
            public void onFlashAuto() {

            }

            @Override
            public void onFlashOn() {

            }

            @Override
            public void onFlashOff() {

            }

            @Override
            public void onCameraSetupForPhoto() {

            }

            @Override
            public void onCameraSetupForVideo() {

            }

            @Override
            public void onRecordStateVideoReadyForRecord() {

            }

            @Override
            public void onRecordStateVideoInProgress() {

            }

            @Override
            public void onRecordStatePhoto() {

            }

            @Override
            public void shouldRotateControls(int degrees) {

            }

            @Override
            public void onStartVideoRecord(File outputFile) {

            }

            @Override
            public void onStopVideoRecord() {

            }
        });

        cameraFragment.setResultListener(new CameraFragmentResultListener() {
            @Override
            public void onVideoRecorded(String filePath) {
//                Log.e("TAG", "onVideoRecorded: "+filePath );
            }

            @Override
            public void onPhotoTaken(byte[] bytes, String filePath) {
//                Log.e("TAG", "onPhotoTaken: "+filePath );
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_take_photo:

                cameraFragment.takePhotoOrCaptureVideo(new CameraFragmentResultListener() {
                    @Override
                    public void onVideoRecorded(String filePath) {
                        Log.e("TAG", "onVideoRecorded: "+filePath );
                        Toast.makeText(CameraActivity.this,"视频录制完成",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onPhotoTaken(byte[] bytes, String filePath) {
                        Log.e("TAG", "onPhotoTaken: "+filePath );
                        Toast.makeText(CameraActivity.this,"照相完成",Toast.LENGTH_LONG).show();
                    }
                }, String.valueOf(Environment.getExternalStorageDirectory()),"aaa");

                break;
            case R.id.bt_action_switch:

                cameraFragment.switchActionPhotoVideo();

                break;
            case R.id.bt_flash_switch:

                cameraFragment.toggleFlashMode();

                break;
            case R.id.bt_camera_switch:

                cameraFragment.switchCameraTypeFrontBack();

                break;
            case R.id.bt_setting:

                cameraFragment.openSettingDialog();

                break;
        }
    }
}
