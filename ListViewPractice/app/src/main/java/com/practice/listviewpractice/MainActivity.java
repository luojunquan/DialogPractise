package com.practice.listviewpractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button bt1,bt2,bt3,bt4,bt5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = (Button) findViewById(R.id.bt_1);
        bt2 = (Button) findViewById(R.id.bt_2);
        bt3 = (Button) findViewById(R.id.bt_3);
        bt4 = (Button) findViewById(R.id.bt_4);
        bt5 = (Button) findViewById(R.id.bt_5);
    }
    public void click1(View view){
        Intent intent = new Intent(this,ListViewActivity.class);
        startActivity(intent);
    }
    public void click2(View view){
        Intent intent = new Intent(this,TitleListViewActivity.class);
        startActivity(intent);
    }
    public void click3(View view){
        Intent intent = new Intent(this,PhotoListViewActivity.class);
        startActivity(intent);
    }
    public void click4(View view){
        Intent intent = new Intent(this,BaseAdapterActivity.class);
        startActivity(intent);
    }
    public void click5(View view){
        Intent intent = new Intent(this,ArrayAdapterActivity.class);
        startActivity(intent);
    }
}
