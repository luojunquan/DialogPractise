package com.practice.viewavtivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioGroupActivity extends Activity {
    private RadioGroup rg1;
    private RadioGroup rg2;
    private RadioButton rb1,rb2,rb3,rb4,rb5,rb6;
    String[] items = {"item0","item1","item2"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiogroup);
        rg1 = (RadioGroup) findViewById(R.id.rg_1);
        rg2 = (RadioGroup) findViewById(R.id.rg_2);
        rb1 = (RadioButton) findViewById(R.id.rb_1);
        rb2 = (RadioButton) findViewById(R.id.rb_2);
        rb3 = (RadioButton) findViewById(R.id.rb_3);
        rb4 = (RadioButton) findViewById(R.id.rb_4);
        rb5 = (RadioButton) findViewById(R.id.rb_5);
        rb6 = (RadioButton) findViewById(R.id.rb_6);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_1:
                        Toast.makeText(RadioGroupActivity.this,"你选中了"+rb1.getText().toString(),Toast.LENGTH_SHORT).show();
                    case R.id.rb_2:
                        Toast.makeText(RadioGroupActivity.this,"你选中了"+rb2.getText().toString(),Toast.LENGTH_SHORT).show();
                    case R.id.rb_3:
                        Toast.makeText(RadioGroupActivity.this,"你选中了"+rb3.getText().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_4:
                        Toast.makeText(RadioGroupActivity.this,"你选中了"+rb4.getText().toString(),Toast.LENGTH_SHORT).show();
                    case R.id.rb_5:
                        Toast.makeText(RadioGroupActivity.this,"你选中了"+rb5.getText().toString(),Toast.LENGTH_SHORT).show();
                    case R.id.rb_6:
                        Toast.makeText(RadioGroupActivity.this,"你选中了"+rb6.getText().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
