package com.jia.demo.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jia.demo.R;
import com.jia.demo.bean.Student;
import com.jia.demo.viewmodel.StudentViewModel;

public class LiveDataActivity extends LifecycleActivity implements View.OnClickListener {

    private StudentViewModel studentViewModel;

    private TextView tv_student1;
    private TextView tv_student2;
    private Button bt_change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        tv_student1 = (TextView) findViewById(R.id.tv_student1);
        tv_student2 = (TextView) findViewById(R.id.tv_student2);
        bt_change = (Button) findViewById(R.id.bt_change);
        bt_change.setOnClickListener(this);

        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        studentViewModel.getData().observe(this, new Observer<Student>() {
            @Override
            public void onChanged(@Nullable Student student) {
                if (student != null) {
                    tv_student1.setText(student.toString());
                    tv_student2.setText(student.toString());
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_change) {
            if (studentViewModel != null) {
                studentViewModel.changeData();
            }
        }
    }
}

/**
 * LiveData 是一种持有可被观察数据的类（an observable data holder class）。
 * 和其他可被观察的类不同的是，LiveData是有生命周期感知能力的（lifecycle-aware,），
 * 这意味着它可以在 activities,  fragments, 或者 services 生命周期是活跃状态时更新这些组件。
 */
