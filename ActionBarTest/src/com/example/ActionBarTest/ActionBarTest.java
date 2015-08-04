package com.example.ActionBarTest;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class ActionBarTest extends Activity {
    /**
     * Called when the activity is first created.
     */

    ActionBar actionBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        actionBar = getActionBar();
    }

    public void showActionBar(View view) {
        actionBar.show();
    }

    public void hideActionBar(View view) {
        actionBar.hide();
    }
}
