package com.example.SendSms;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by code4j on 2015/3/26.
 */
public class SendSmsListener implements View.OnLongClickListener {

    private Activity act;
    private EditText address;
    private EditText content;

    public SendSmsListener(Activity act, EditText address, EditText content) {
        this.act = act;
        this.address = address;
        this.content = content;
    }

    @Override
    public boolean onLongClick(View v) {
        String addressStr = this.address.getText().toString();
        String contentStr = content.getText().toString();
        SmsManager manager = SmsManager.getDefault();
        PendingIntent sendIntent = PendingIntent.getBroadcast(act, 0, new Intent(), 0);
        manager.sendTextMessage(addressStr, null, contentStr, sendIntent, null);
        Toast.makeText(act, "短信发送成功！", Toast.LENGTH_LONG).show();
        return false;
    }
}
