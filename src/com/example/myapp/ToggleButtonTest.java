package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

/**
 * Created by code4j on 2015/3/6.
 */
public class ToggleButtonTest extends Activity {
    ToggleButton toggle;
    Switch switcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        toggle = (ToggleButton) findViewById(R.id.toggle);
        switcher = (Switch) findViewById(R.id.switcher);
        final LinearLayout test = (LinearLayout)findViewById(R.id.test);
        OnCheckedChangeListener listener = new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    test.setOrientation(LinearLayout.VERTICAL);
                } else {
                    test.setOrientation(LinearLayout.HORIZONTAL);
                }
            }
        };
        toggle.setOnCheckedChangeListener(listener);
        switcher.setOnCheckedChangeListener(listener);
    }
}
