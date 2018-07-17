package com.jia.demo.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.jia.demo.bean.Student;

import java.util.Random;

/**
 * Description:
 * Created by jia on 2018/7/17.
 * 人之所以能，是相信能。
 */

public class StudentViewModel extends ViewModel implements BaseViewModel<Student> {

    private static final String TAG = "StudentViewModel";

    private MutableLiveData<Student> liveStudent;

    public MutableLiveData<Student> getData() {
        if (liveStudent == null) {
            liveStudent = new MutableLiveData<>();
        }
        liveStudent.setValue(loadData());
        return liveStudent;
    }

    @Override
    public Student loadData() {
        Student stu = new Student();
        Random random = new Random();
        stu.setId(random.nextInt(1000));
        stu.setAge(random.nextInt(100));
        stu.setName(random.nextInt(10) + "haha");
        return stu;
    }

    @Override
    public void clearData() {
        if (liveStudent != null)
            liveStudent = null;
    }

    @Override
    public void changeData() {
        if(liveStudent != null){
            liveStudent.setValue(loadData());
        }
    }
}
