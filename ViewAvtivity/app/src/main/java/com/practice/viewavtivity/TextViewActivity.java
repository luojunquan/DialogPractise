package com.practice.viewavtivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * Created by 赖上罗小贱 on 2016/5/10.
 */
public class TextViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        代码里呈现TextView
        TextView textView = new TextView(this);
        textView.setText("从代码中添加一个TextView");
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(18);
        textView.setBackgroundColor(Color.BLUE);
        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
//        布局文件里呈现TextView
        setContentView(R.layout.activity_textview);
        LinearLayout ll = (LinearLayout) findViewById(R.id.textviewll);
        ll.addView(textView);
    }
}
