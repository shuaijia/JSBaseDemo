package com.jia.demo.activity;

import android.app.Activity;
import android.os.Bundle;

import com.jia.demo.R;
import com.jia.demo.view.JsRadarChart;

import java.util.ArrayList;
import java.util.List;

/**
 * 雷达 分析  界面
 */
public class RadarActivity extends Activity {

    private JsRadarChart radar_chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radar);

        radar_chart = (JsRadarChart) findViewById(R.id.radar_chart);


        List<JsRadarChart.RadarEntry> list = new ArrayList<>();

        JsRadarChart.RadarEntry entry1 = new JsRadarChart.RadarEntry("力量", 100);
        JsRadarChart.RadarEntry entry2 = new JsRadarChart.RadarEntry("经验", 100);
        JsRadarChart.RadarEntry entry3 = new JsRadarChart.RadarEntry("防守", 100);
        JsRadarChart.RadarEntry entry4 = new JsRadarChart.RadarEntry("发球", 100);
        JsRadarChart.RadarEntry entry5 = new JsRadarChart.RadarEntry("技术", 100);
        JsRadarChart.RadarEntry entry6 = new JsRadarChart.RadarEntry("速度", 100);

        list.add(entry1);
        list.add(entry2);
        list.add(entry3);
        list.add(entry4);
        list.add(entry5);
        list.add(entry6);

        radar_chart.setRadatEntries(list);
    }
}
