package com.example.myapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class GridViewAdapter extends BaseAdapter {
    private List<HashMap<String, String>> list;
    private Context context;

    public GridViewAdapter(Context context, List<HashMap<String, String>> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        MyView tag;
        if (convertView == null) {
            View v = LayoutInflater.from(context).inflate(
                    R.layout.image_items, null);
            tag = new MyView();
            tag.imageView = (ImageView) v.findViewById(R.id.image);
            tag.textView = (TextView) v.findViewById(R.id.title);
            v.setTag(tag);
            convertView = v;
        } else {
            tag = (MyView) convertView.getTag();
        }
        String image_path = list.get(position).get("image");
        String text = list.get(position).get("text");
        Bitmap bm = getBitMap(context, image_path);
        if (bm == null) {
            bm = BitmapFactory.decodeResource(context.getResources(),
                    R.drawable.error);
            Log.i("BitmapPicture", "picture is null!!");
        }
        Display display = parent.getDisplay();
        int width2 = display.getWidth();
        int dstW = bm.getWidth();
        int dstH = bm.getHeight();
        if (bm.getWidth() < width2) {
            dstW = width2;
            dstH = (int) (width2 * (bm.getHeight() * 1.0 / bm.getWidth()));
        }

        Bitmap newBit = Bitmap.createScaledBitmap(bm, dstW, dstH, true);
        tag.imageView.setImageBitmap(newBit);
        tag.textView.setText(text);
        return convertView;
    }

    public synchronized Bitmap getBitMap(Context c, String url) {
        URL myFileUrl;
        Bitmap bitmap = null;
        try {
            myFileUrl = new URL(url);
        } catch (MalformedURLException e) {
            bitmap = BitmapFactory.decodeResource(c.getResources(),
                    R.drawable.error); // 当网络连接异常后,给个默认图片
            return bitmap;
        }
        try {
            // 打开网络连接
            HttpURLConnection conn = (HttpURLConnection) myFileUrl.openConnection();
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream(); // 把得到的内容转换成流
            bitmap = BitmapFactory.decodeStream(is);

        } catch (IOException e) {
            bitmap = BitmapFactory.decodeResource(c.getResources(),
                    R.drawable.error);
            return bitmap;
        }

        return bitmap;
    }

}

class MyView {
    ImageView imageView;
    TextView textView;

}