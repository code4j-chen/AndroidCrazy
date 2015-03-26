package com.example.CallbackHandler;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Button;

/**
 * Created by code4j on 2015/3/26.
 */
public class MyButton extends Button {


    public MyButton(Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode, event);
        Log.v("-com.example-", "the OnKeyDown in myButton");
        System.out.println("111");
        return true;
    }
}
