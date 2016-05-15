package com.practice.viewavtivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = (Button) findViewById(R.id.bt_1);
    }
    public void click1(View view){
        Intent intent = new Intent(this,TextViewActivity.class);
        startActivity(intent);
    }
    public void click2(View view){
        Intent intent = new Intent(this,WebViewActivity.class);
        startActivity(intent);
    }
    public void click3(View view){
        Intent intent = new Intent(this,MenuActivity.class);
        startActivity(intent);
    }
    public void click4(View view){
        Intent intent = new Intent(this,ButtonActivity.class);
        startActivity(intent);
    }
    public void click5(View view){
        Intent intent = new Intent(this,EditViewActivity.class);
        startActivity(intent);
    }
    public void click6(View view){
        Intent intent = new Intent(this,RadioGroupActivity.class);
        startActivity(intent);
    }
    public void click7(View view){
        Intent intent = new Intent(this,CheckBoxActivity.class);
        startActivity(intent);
    }
}
