package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by code4j on 2015/3/3.
 */
public class MixView extends Activity {
    int[] images = new int[]{
            R.drawable.java,
            R.drawable.ee,
            R.drawable.classic,
            R.drawable.ajax,
            R.drawable.xml
    };
    int currentImg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LinearLayout main = (LinearLayout) findViewById(R.id.root);
        final ImageView image = new ImageView(this);
        main.addView(image);
        image.setImageResource(images[0]);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentImg == images.length) {
                    currentImg = 0;
                }
                image.setImageResource(images[++currentImg % images.length]);
            }
        });
    }
}
