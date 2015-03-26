package com.example.EventQs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EventQs extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn = (Button) findViewById(R.id.bn);
        btn.setOnClickListener(new MyClickListener());
    }

    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            EditText et = (EditText) findViewById(R.id.txt);
            et.setText("btn 被单击了！");
        }
    }
}
