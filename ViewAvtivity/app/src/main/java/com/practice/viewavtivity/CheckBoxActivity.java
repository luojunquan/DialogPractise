package com.practice.viewavtivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.ArrayList;

public class CheckBoxActivity extends Activity {
    private CheckBox cb1,cb2,cb3,cb4;
//    Button bt;
    ArrayList<String> item = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        cb1 = (CheckBox) findViewById(R.id.cb_1);
        cb2 = (CheckBox) findViewById(R.id.cb_2);
        cb3 = (CheckBox) findViewById(R.id.cb_3);
        cb4 = (CheckBox) findViewById(R.id.cb_4);
        final Button button = (Button) findViewById(R.id.bt);
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton button, boolean arg1) {
        String str = button.getText().toString();
        if (button.isChecked()) {
            item.add(str);
        } else {
            item.remove(str);
             }
        }
    });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton button, boolean arg1) {
                String str = button.getText().toString();
                if (button.isChecked()) {
                    item.add(str);
                } else {
                    item.remove(str);
                }
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton button, boolean arg1) {
                String str = button.getText().toString();
                if (button.isChecked()) {
                    item.add(str);
                } else {
                    item.remove(str);
                }
            }
        });
        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton button, boolean arg1) {
                String str = button.getText().toString();
                if (button.isChecked()) {
                    item.add(str);
                } else {
                    item.remove(str);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = item.toString();
                Toast.makeText(CheckBoxActivity.this, "您选中了" + str, Toast.LENGTH_LONG).show();
            }
        });
    }
}
