package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;

/**
 * Created by code4j on 2015/3/5.
 */
public class GridLayoutTest extends Activity {
    GridLayout gridLayout;
    String[] chars = new String[]{
            "7", "8", "9", "÷",
            "4", "5", "6", "x",
            "1", "2", "3", "-",
            ".", "0", "=", "+",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gridLayout = (GridLayout) findViewById(R.id.root);
        for (int i = 0; i < chars.length; i++) {
            Button btn = new Button(this);
            btn.setText(chars[i]);
            btn.setTextSize(40);
            GridLayout.Spec rowSpec = GridLayout.spec(i / 4 + 2);
            GridLayout.Spec columnSpec = GridLayout.spec(i % 4);
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(rowSpec, columnSpec);
            layoutParams.setGravity(Gravity.FILL);
            gridLayout.addView(btn, layoutParams);
        }
    }
}
