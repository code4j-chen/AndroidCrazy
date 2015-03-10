package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.QuickContactBadge;

/**
 * Created by code4j on 2015/3/6.
 */
public class QuickContackBadgeTest extends Activity {
    QuickContactBadge badge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        badge = (QuickContactBadge) findViewById(R.id.badge);
        badge.assignContactFromPhone("01064300768", false);
    }
}
