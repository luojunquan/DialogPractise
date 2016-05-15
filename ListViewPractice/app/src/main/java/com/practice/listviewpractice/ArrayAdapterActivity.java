package com.practice.listviewpractice;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ArrayAdapterActivity extends ListActivity {
    private String[] mListTitle = {"姓名","性别","年龄","居住地","邮箱"};
    private String[] mListStr = {"罗小贱","男","23","天津","ljq906416@gmail.com"};
    ListView mListView = null;
    MyListAdapter myListAdapter = null;
    ArrayList arrayList = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListView = getListView();
        myListAdapter = new MyListAdapter(this,R.layout.activity_arrayadapter);
        setListAdapter(myListAdapter);
    }
    class MyListAdapter extends ArrayAdapter<Object>{
        int mTextViewResourceID= 0;
        private Context mContext;
        public MyListAdapter(Context context, int resource) {
            super(context, resource);
            mTextViewResourceID = resource;
            mContext = context;
        }
        private int[] colors = new int[]{0xff626569, 0xff4f5257 };
        public int getCount() {
            return mListStr.length;
        }
        @Override
        public boolean areAllItemsEnabled() {
            return false;
        }
        public Object getItem(int position) {
            return position;
        }
        public long getItemId(int position) {
            return position;
        }
        public View getView(final int position, View convertView, ViewGroup parent){
            ImageView image = null;
            TextView title = null;
            TextView text = null;
            Button button = null;
            if (convertView == null){
                convertView = LayoutInflater.from(mContext).inflate(mTextViewResourceID,null);
                image = (ImageView) convertView.findViewById(R.id.image);
                title = (TextView) convertView.findViewById(R.id.title);
                text = (TextView) convertView.findViewById(R.id.text);
                button = (Button) convertView.findViewById(R.id.bt);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ArrayAdapterActivity.this, "您点击的第" + position + "个按钮",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
            int colorPos = position % colors.length;
            convertView.setBackgroundColor(colors[colorPos]);
            title.setText(mListTitle[position]);
            text.setText(mListStr[position]);
            if (colorPos == 0){
                image.setImageResource(R.drawable.in_icon);
            }else {
                image.setImageResource(R.drawable.image);
            }
            return convertView;
        }
    }
}
