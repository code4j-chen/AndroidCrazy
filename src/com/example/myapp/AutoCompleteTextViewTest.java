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
public class AutoCompleteTextViewTest extends Activity {
    AutoCompleteTextView actv;
    MultiAutoCompleteTextView mauto;
    // 定义字符串数组，作为提示的文本
    String[] books = new String[]{
            "疯狂Java讲义",
            "疯狂Ajax讲义",
            "疯狂XML讲义",
            "疯狂Workflow讲义"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, books);
        actv = (AutoCompleteTextView) findViewById(R.id.auto);
        actv.setAdapter(adapter);
        mauto = (MultiAutoCompleteTextView) findViewById(R.id.mauto);
        mauto.setAdapter(adapter);
        mauto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
