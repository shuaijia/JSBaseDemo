package com.jia.demo.activity;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jia.demo.R;
import com.jia.demo.view.pickerview.PickerPopupWindow;

public class PickerViewActivity extends AppCompatActivity {

    private ConstraintLayout main;

    private Button bt_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker_view);

        main = (ConstraintLayout) findViewById(R.id.main);
        bt_show= (Button) findViewById(R.id.bt_show);

        bt_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });

    }

    private void show() {

        PickerPopupWindow mChangeAddressPopwindow = new PickerPopupWindow(PickerViewActivity.this);
        mChangeAddressPopwindow.setCurrentData("每月", 3+"日");
        mChangeAddressPopwindow.showAtLocation(main, Gravity.BOTTOM, 0, 0);
        mChangeAddressPopwindow
                .setAddresskListener(new PickerPopupWindow.OnAddressCListener() {

                    @Override
                    public void onClick(String province, String city, String area) {
                        // TODO Auto-generated method stub
                        Toast.makeText(PickerViewActivity.this,
                                province + "-" + city ,
                                Toast.LENGTH_LONG).show();

                    }
                });
    }
}
