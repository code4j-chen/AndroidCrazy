package com.example.myapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

/**
 * Created by code4j on 2015/3/17.
 */
public class BaseAdapterTest extends Activity {
    ListView myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        myList = (ListView) findViewById(R.id.myList);
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return 40;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LinearLayout line = new LinearLayout(BaseAdapterTest.this);
                line.setOrientation(0);
                ImageView image = new ImageView(BaseAdapterTest.this);
                image.setImageResource(R.drawable.ic_launcher);
                TextView text = new TextView(BaseAdapterTest.this);
                text.setText("第" + (position + 1) + "个列表项");
                text.setTextSize(20);
                text.setTextColor(Color.RED);
                line.addView(image);
                line.addView(text);
                return line;
            }
        };
        myList.setAdapter(adapter);
    }
}
