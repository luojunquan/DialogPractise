package com.practice.downselect;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {
    private EditText editText;
    private ImageView iv_select;

    private ArrayList<String> list = new ArrayList<String>();
    private MyAdapter adapter;
    private ListView listView;

    private int popupWindowHeight = 300;
    private PopupWindow popupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();
        initData();
    }

    private void initListener() {
        iv_select.setOnClickListener(this);
    }
    private void initView() {
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        iv_select = (ImageView) findViewById(R.id.iv_select);
    }

    private void initData() {
        for (int i = 0; i < 15; i++) {
            list.add(900000+i+"");
        }

        initListView();
    }

    private void initListView(){
        listView = new ListView(this);

        listView.setBackgroundResource(R.drawable.listview_background);
        listView.setVerticalScrollBarEnabled(false);//隐藏listview滚动条

        adapter = new MyAdapter();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                editText.setText(list.get(position));
                popupWindow.dismiss();
            }
        });
    }

    private void showNumberList(){
        if(popupWindow==null){
            popupWindow = new PopupWindow(listView,
                    editText.getWidth(), popupWindowHeight);
        }
        //要让其中的view获取焦点，必须设置为true
        popupWindow.setFocusable(true);
        //还必须设置一个背景图片
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //设置点击外部消失
        popupWindow.setOutsideTouchable(true);

        popupWindow.showAsDropDown(editText, 0, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_select:
                showNumberList();
                break;
        }

    }


    class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return list.size();
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final View view = View.inflate(MainActivity.this, R.layout.adapter_list, null);
            TextView tv_number = (TextView) view.findViewById(R.id.tv_number);
            ImageButton iv_delete = (ImageButton) view.findViewById(R.id.iv_delete);

            tv_number.setText(list.get(position));
            iv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(position);
                    notifyDataSetChanged();

                    int listviewHeight = view.getHeight()*list.size();
                    popupWindow.update(editText.getWidth(), listviewHeight>popupWindowHeight
                            ?popupWindowHeight:listviewHeight);

                    if(list.size()==0){
                        popupWindow.dismiss();
                        iv_select.setVisibility(View.GONE);
                    }
                }
            });

            return view;
        }

    }

}
