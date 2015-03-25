package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.EditText;
import android.widget.Toast;


public class ActivityMenu extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu subMenu = menu.addSubMenu("启动程序");
        subMenu.setHeaderIcon(R.drawable.tools);
        subMenu.setHeaderTitle("选择你要启动的程序");
        MenuItem item = subMenu.add("查看经典Java EE");
        item.setIntent(new Intent(this, OtherActivity.class));
        return super.onCreateOptionsMenu(menu);
    }
}

