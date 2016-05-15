package com.practice.viewpractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
public class MainActivity extends Activity {
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = (Button) findViewById(R.id.bt_1);
        bt2 = (Button) findViewById(R.id.bt_2);
        bt3 = (Button) findViewById(R.id.bt_3);
        bt4 = (Button) findViewById(R.id.bt_4);
    }
    public void click1(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
    public void click2(View view){
        Intent intent = new Intent(this,Geometry.class);
        startActivity(intent);
    }
    public void click3(View view){
        Intent intent = new Intent(this,ImageActivity.class);
        startActivity(intent);
    }
    public void click4(View view){
        Intent intent = new Intent(this,FramAnimation.class);
        startActivity(intent);
    }
}
