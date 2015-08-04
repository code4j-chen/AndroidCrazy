package com.example.ActivityListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityListener extends Activity implements View.OnClickListener {
    /**
     * Called when the activity is first created.
     */

    EditText show;
    Button bn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        show = (EditText) findViewById(R.id.show);
        bn = (Button) findViewById(R.id.bn);
        // 直接使用Activity作为事件监听器
        bn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        show.setText("bn按钮被单击了！");
    }
}
