package com.practice.viewavtivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;
import android.widget.Toast;

/**
 * Created by 赖上罗小贱 on 2016/5/10.
 */
public class ButtonActivity extends Activity {
    private Button bt;
    private ImageButton ib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttonview);
        bt = (Button) findViewById(R.id.bt_1);
        ib = (ImageButton) findViewById(R.id.ib_1);
    }
    public void click1(View view){
            Toast.makeText(this, "您点击了一个按钮", Toast.LENGTH_LONG).show();
        }
    public void click2(View view){
        Toast.makeText(this, "您点击了图片按钮", Toast.LENGTH_LONG).show();
    }
}
