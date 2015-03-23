package com.example.myapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.TextView;

public class AlertDialogTest extends Activity {

    TextView show;
    String[] items = new String[]{
            "疯狂Java讲义", "疯狂Ajax讲义",
            "轻量级Java EE企业应用实战",
            "疯狂Android讲义"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        show = (TextView) findViewById(R.id.show);
    }

    public void simple(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("简单对话框")
                .setIcon(R.drawable.tools)
                .setMessage("对话框的测试内容\n第二行内容");
        setPositiveButton(builder);
        setNegativeButton(builder).create().show();
    }

    private AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder) {
        return builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("单击了【取消】按钮！");
            }
        });
    }

    private AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder) {
        return builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("单击了【确定】按钮！");
            }
        });
    }

    public void simpleList(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("简单列表项对话框").setIcon(R.drawable.tools).setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("你选中了《" + items[which] + "》");
            }
        });
        setPositiveButton(builder);
        setNegativeButton(builder).create().show();
    }

    public void singleChoice(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder// 设置对话框标题
                .setTitle("单选列表项对话框")
                        // 设置图标
                .setIcon(R.drawable.tools).setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("你选中了《" + items[which] + "》");
            }
        });
        // 为AlertDialog.Builder添加【确定】按钮
        setPositiveButton(builder);
        // 为AlertDialog.Builder添加【取消】按钮
        setNegativeButton(builder)
                .create()
                .show();
    }

    public void multiChoice(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder// 设置对话框标题
                .setTitle("多选列表项对话框")
                        // 设置图标
                .setIcon(R.drawable.tools).setMultiChoiceItems(items, new boolean[]{false, true, false, true}, null);
        // 为AlertDialog.Builder添加【确定】按钮
        setPositiveButton(builder);
        // 为AlertDialog.Builder添加【取消】按钮
        setNegativeButton(builder)
                .create()
                .show();
    }

    public void customList(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                // 设置对话框标题
                .setTitle("自定义列表项对话框")
                        // 设置图标
                .setIcon(R.drawable.tools)
                        // 设置自定义列表项
                .setAdapter(new ArrayAdapter<String>(this, R.layout.array_item, items), null);
        // 为AlertDialog.Builder添加【确定】按钮
        setPositiveButton(builder);
        // 为AlertDialog.Builder添加【取消】按钮
        setNegativeButton(builder)
                .create()
                .show();
    }

    public void customView(View view) {
        TableLayout loginForm = (TableLayout) getLayoutInflater().inflate(R.layout.login, null);
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.tools)
                        // 设置对话框的标题
                .setTitle("自定义View对话框")
                        // 设置对话框显示的View对象
                .setView(loginForm)
                        // 为对话框设置一个“确定”按钮
                .setPositiveButton("登录" , new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which)
                    {
                        // 此处可执行登录处理
                    }
                })
                        // 为对话框设置一个“取消”按钮
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        // 取消登录，不做任何事情。
                    }
                })
                        // 创建、并显示对话框
                .create()
                .show();
    }
}

