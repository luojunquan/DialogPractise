package com.practice.viewavtivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
public class EditViewActivity extends Activity {
    private EditText etName;
    private EditText etPassWord;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editview);
        etName = (EditText) findViewById(R.id.et_name);
        etPassWord = (EditText) findViewById(R.id.et_pwd);
        bt = (Button) findViewById(R.id.bt);
    }
    public void click1(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("用户名：" + etName.getText().toString() +
                "密码" + etPassWord.getText().toString()).show();
    }
}
