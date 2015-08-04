package com.example.PopupMenuTest;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class PopupMenuTest extends Activity {
    /**
     * Called when the activity is first created.
     */
    PopupMenu popupMenu = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }


    public void onPopupButtonClick(View view) {
        popupMenu = new PopupMenu(this, view);
        getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.exit:
                        // ���ظöԻ���
                        popupMenu.dismiss();
                        break;
                    default:
                        // ʹ��Toast��ʾ�û�����Ĳ˵���
                        Toast.makeText(PopupMenuTest.this,
                                "您单击了【" + item.getTitle() + "】菜单项"
                                , Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        popupMenu.show();
    }
}
