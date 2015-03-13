package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by code4j on 2015/3/10.
 */
public class MyGridViewTest extends Activity {
    private String[] images = new String[]{
            "http://imgciwenkids.qiniudn.com/xTb2AGEuvueZz7cGlVaTpuKeBFU=/liibms8c9R9NEwJpkvFNJ_jWf_Op?imageView2/2/w/120/h/120",
            "http://imgciwenkids.qiniudn.com/EMEiRhZkUSwbr3PEWP6ChHm1n2s=/lroMGYSGk5vfPp5C0SOsBWHLejCP?imageView2/2/w/120/h/120",
            "http://imgciwenkids.qiniudn.com/Ww0eRIl-C6hF0V-tHzMgvi2EEyE=/llPAxdz586FPmzNUTIQNXLbWrN82?imageView2/2/w/120/h/120",
            "http://imgciwenkids.qiniudn.com/poJsiU27sh1WiXgXr_o3Bcg25dA=/loh5MNCPeXX3vgJgFrnNZBAtYpOI?imageView2/2/w/120/h/120",
            "http://imgciwenkids.qiniudn.com/EMEiRhZkUSwbr3PEWP6ChHm1n2s=/lhUun0J_5O-blLBKTZrA0nmRvWv8?imageView2/2/w/120/h/120",
            "http://imgciwenkids.qiniudn.com/poJsiU27sh1WiXgXr_o3Bcg25dA=/lqD-Vhrhvx5ZPkwKdqfE0JuoyywD?imageView2/2/w/120/h/120",
            "http://imgciwenkids.qiniudn.com/4qBWI1e5vY8J6llbVf7PLIjCCjA=/lkkwqlebLe6KtuO6ZAgUltPuBax6?imageView2/2/w/120/h/120",
            "http://imgciwenkids.qiniudn.com/xTb2AGEuvueZz7cGlVaTpuKeBFU=/lmYr9J1hw1EKNUP6VWqfiEsZMXUH?imageView2/2/w/120/h/120",
            "http://imgciwenkids.qiniudn.com/CPNmd5WZcTJ5o8TcnCtoZ_qWHec=/lpWHjh0aWl14Vy_WagbslRCRNHbT?imageView2/2/w/120/h/120",
            "http://imgciwenkids.qiniudn.com/poJsiU27sh1WiXgXr_o3Bcg25dA=/lng4PvLOLLL3WcRBx5TlCqPC64vU?imageView2/2/w/120/h/120",
            "http://imgciwenkids.qiniudn.com/Ww0eRIl-C6hF0V-tHzMgvi2EEyE=/ljZ9ux_HDN4lhHl3_NgVX7VIw63h?imageView2/2/w/120/h/120",
            "http://imgciwenkids.qiniudn.com/EMEiRhZkUSwbr3PEWP6ChHm1n2s=/lsvcIK-DZJ62XnI_NuKqq2IxJnKG?imageView2/2/w/120/h/120",
    };
    private String[] text = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        GridView gridView = (GridView) findViewById(R.id.gridView);
        List<HashMap<String, String>> list = getimageList();
        gridView.setAdapter(new GridViewAdapter(this, list));
    }
    public List<HashMap<String, String>> getimageList() {
        ArrayList<HashMap<String, String>> imagelist = new ArrayList<HashMap<String, String>>();
        // 使用HashMap将图片添加到一个数组中，注意一定要是HashMap<String,Object>类型的，因为装到map中的图片要是资源ID，而不是图片本身
        // 如果是用findViewById(R.drawable.image)这样把真正的图片取出来了，放到map中是无法正常显示的
        for (int i = 0; i < 100; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("image", images[i%12]);
            map.put("text", text[i%12]);
            imagelist.add(map);
        }
        return imagelist;
    }
}
