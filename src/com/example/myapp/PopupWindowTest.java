package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

public class PopupWindowTest extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        View root = this.getLayoutInflater().inflate(R.layout.popup, null);
        final PopupWindow popupWindow = new PopupWindow(root, 280, 360);
        Button bn = (Button) findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 以下拉方式显示。
//				popupWindow.showAsDropDown(v);
                //将PopupWindow显示在指定位置
                popupWindow.showAtLocation(findViewById(R.id.bn), Gravity.CENTER, 20,
                        20);
            }
        });
        root.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

}

