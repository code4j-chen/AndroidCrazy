package com.example.myapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

/**
 * Created by code4j on 2015/3/6.
 */
public class ToastTest extends Activity {
    private ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button simple = (Button) findViewById(R.id.simple);
        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(ToastTest.this, "简单的提示", Toast.LENGTH_SHORT);
                toast.show();

            }
        });

        Button bn = (Button) findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(ToastTest.this);
                toast.setGravity(Gravity.CENTER, 0, 0);
                // 创建一个ImageView
                ImageView image = new ImageView(ToastTest.this);
                image.setImageResource(R.drawable.tools);
                // 创建一个LinearLayout容器
                LinearLayout ll = new LinearLayout(ToastTest.this);
                // 向LinearLayout中添加图片、原有的View
                ll.addView(image);
                // 创建一个ImageView
                TextView textView = new TextView(ToastTest.this);
                textView.setText("带图片的提示信");
                // 设置文本框内字体的大小和颜色
                textView.setTextSize(30);
                textView.setTextColor(Color.MAGENTA);
                ll.addView(textView);
                // 设置Toast显示自定义View
                toast.setView(ll);
                // 设置Toast的显示时间
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

}
