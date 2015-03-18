package com.example.myapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

/**
 * Created by code4j on 2015/3/6.
 */
public class CalendarViewTest extends Activity {
    private CalendarView cv;
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        cv = (CalendarView) findViewById(R.id.calendarView);
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(CalendarViewTest.this, "你的生日是：" + year + "年" + month + "月" + dayOfMonth + "日", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
