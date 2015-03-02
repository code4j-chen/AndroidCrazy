package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("create===================");
        setContentView(R.layout.main);
    }

    public void clickHandler(View view) {
        TextView tv = (TextView) findViewById(R.id.show);
        tv.setText("Hello Android-"+ new Date());
        
    }
}
