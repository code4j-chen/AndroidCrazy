package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

/**
 * Created by code4j on 2015/3/3.
 */
public class CustomView extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LinearLayout layout = (LinearLayout) findViewById(R.id.root);
        final DrawView draw = new DrawView(this);
        draw.setMinimumHeight(500);
        draw.setMinimumWidth(300);
        layout.addView(draw);
    }
}
