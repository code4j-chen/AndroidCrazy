package com.example.myapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

/**
 * Created by code4j on 2015/3/6.
 */
public class AdapterViewFlipperTest extends Activity {
    int[] imageIds = new int[]
            {
                    R.drawable.shuangzi, R.drawable.shuangyu,
                    R.drawable.chunv, R.drawable.tiancheng, R.drawable.tianxie,
                    R.drawable.sheshou, R.drawable.juxie, R.drawable.shuiping,
                    R.drawable.shizi, R.drawable.baiyang, R.drawable.jinniu,
                    R.drawable.mojie };
    AdapterViewFlipper flipper;
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        flipper = (AdapterViewFlipper) findViewById(R.id.flipper);
        // 创建一个BaseAdapter对象，该对象负责提供Gallery所显示的列表项
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView = new ImageView(AdapterViewFlipperTest.this);
                imageView.setImageResource(imageIds[position]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                // 为imageView设置布局参数
                imageView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };
        flipper.setAdapter(adapter);
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void prev(View source)
    {
        // 显示上一个组件
        flipper.showPrevious();
        // 停止自动播放
        flipper.stopFlipping();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void next(View source)
    {
        // 显示下一个组件。
        flipper.showNext();
        // 停止自动播放
        flipper.stopFlipping();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void auto(View source)
    {
        // 开始自动播放
        flipper.startFlipping();
    }
}
