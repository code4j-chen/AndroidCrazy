package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

/**
 * Created by code4j on 2015/3/6.
 */
public class ExpandableListViewTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        BaseExpandableListAdapter adapter = new BaseExpandableListAdapter() {
            int[] logos = new int[]
                    {
                            R.drawable.p,
                            R.drawable.z,
                            R.drawable.t
                    };
            private String[] armTypes = new String[]
                    { "神族兵种", "虫族兵种", "人族兵种"};
            private String[][] arms = new String[][]
                    {
                            { "狂战士", "龙骑士", "黑暗圣堂", "电兵" },
                            { "小狗", "刺蛇", "飞龙", "自爆飞机" },
                            { "机枪兵", "护士MM" , "幽灵" }
                    };
            // 获取指定组位置、指定子列表项处的子列表项数据
            @Override
            public int getGroupCount() {
                return armTypes.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return arms[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return armTypes[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return arms[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout ll = new LinearLayout(ExpandableListViewTest.this);
                ll.setOrientation(0);
                ImageView logo = new ImageView(ExpandableListViewTest.this);
                logo.setImageResource(logos[groupPosition]);
                ll.addView(logo);
                TextView textView = new TextView(ExpandableListViewTest.this);
                textView.setText(getGroup(groupPosition).toString());
                ll.addView(textView);
                return ll;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView textView = getTextView();
                textView.setText(getChild(groupPosition, childPosition).toString());
                return textView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {

                return true;
            }
            private TextView getTextView()
            {
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, 64);
                TextView textView = new TextView(ExpandableListViewTest.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextSize(20);
                return textView;
            }
        };

        ExpandableListView view = (ExpandableListView) findViewById(R.id.list);
        view.setAdapter(adapter);
    }
}
