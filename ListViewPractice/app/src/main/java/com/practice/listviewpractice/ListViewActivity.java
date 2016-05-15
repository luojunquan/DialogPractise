package com.practice.listviewpractice;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends ListActivity {
    private String[] mListStr = {"姓名：罗小贱","性别：男",
            "年龄：23","居住地：天津","邮箱：ljq906416@gmail.com"};
    ListView mListView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListView = getListView();
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mListStr));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "您选择了" + mListStr[position], Toast.LENGTH_LONG).show();
            }
        });
    }
}
