package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

/**
 * Created by code4j on 2015/3/9.
 */
public class ChonometerTest extends Activity {
    Chronometer ch;
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ch = (Chronometer) findViewById(R.id.test);
        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch.setBase(SystemClock.elapsedRealtime());
                ch.start();
                start.setEnabled(false);
            }
        });
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime() - ch.getBase() > 20 * 1000) {
                    ch.stop();
                    start.setEnabled(true);
                }
            }
        });
    }
}
