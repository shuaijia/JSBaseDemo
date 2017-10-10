package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jia.demo.R;
import com.jia.demo.view.JsPasswordInputView;

/**
 * 仿微信、支付宝的密码输入框
 */
public class PasswordEditTextActivity extends Activity {

    private JsPasswordInputView pwd_input;

    private Button bt_get_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_edit_text);
        pwd_input= (JsPasswordInputView) findViewById(R.id.pwd_input);
        bt_get_content= (Button) findViewById(R.id.bt_get_content);


        bt_get_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PasswordEditTextActivity.this,pwd_input.getText(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
