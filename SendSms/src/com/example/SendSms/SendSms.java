package com.example.SendSms;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SendSms extends Activity {
    /**
     * Called when the activity is first created.
     */

    EditText address;
    EditText content;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        address = (EditText) findViewById(R.id.address);
        content = (EditText) findViewById(R.id.content);
        Button btn = (Button) findViewById(R.id.send);
        btn.setOnLongClickListener(new SendSmsListener(this, address, content));
    }
}
