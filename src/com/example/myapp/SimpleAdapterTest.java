package com.example.myapp;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by code4j on 2015/3/16.
 */
public class SimpleAdapterTest extends Activity {
    private String[] names = {"虎头", "弄玉", "李清照", "李白"};
    private String[] descs = {"可爱的小孩", "一个擅长音乐的女孩", "一个擅长文学的女性", "浪漫主义诗人"};
    private int[] imageIds = new int[]
            { R.drawable.tiger , R.drawable.nongyu
                    , R.drawable.qingzhao , R.drawable.libai};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("header", imageIds[i]);
            item.put("personName", names[i]);
            item.put("desc", descs[i]);
            listItems.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.simple_item,
                new String[]{"personName", "header", "desc"}, new int[]{R.id.name, R.id.header, R.id.desc});
        ListView listView = (ListView) findViewById(R.id.mylist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(names[position] + "被单击了");
            }
        });

        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(names[position] + "被选中了");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
