package com.example.myapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

/**
 * Created by code4j on 2015/3/16.
 */
public class ArrayAdapter4OneListTest extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] arr1 = {"孙悟空", "猪八戒", "牛魔王"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, arr1);
        setListAdapter(adapter1);

    }
}
