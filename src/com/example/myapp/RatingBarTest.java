package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;

/**
 * Created by code4j on 2015/3/6.
 */
public class RatingBarTest extends Activity {
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        image = (ImageView) findViewById(R.id.image);
        image = (ImageView) findViewById(R.id.image);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.rating);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            // 当拖动条的滑块位置发生改变时触发该方法
            @Override
            public void onRatingChanged(RatingBar arg0, float rating,
                                        boolean fromUser) {
                // 动态改变图片的透明度，其中255是星级评分条的最大值
                // 5个星星就代表最大值255
                image.setAlpha((int) (rating * 255 / 5));
            }
        });

    }

}
