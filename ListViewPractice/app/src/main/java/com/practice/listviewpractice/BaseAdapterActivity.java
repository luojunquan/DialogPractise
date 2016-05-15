package com.practice.listviewpractice;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class BaseAdapterActivity extends ListActivity {
    private ImageView image;
    private TextView title;
    private TextView text;
    private Context mContext;
    private String[] mListTitle = {"姓名","性别","年龄","居住地","邮箱"};
    private String[] mListStr = {"罗小贱","男","23","天津","ljq906416@gmail.com"};
    ListView mListView = null;
    MyListAdapter myListAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListView = getListView();
        myListAdapter = new MyListAdapter(this);
        setListAdapter(myListAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View v = parent.getChildAt(position);
                v.setBackgroundColor(Color.RED);
                Toast.makeText(BaseAdapterActivity.this, "您选择了" + mListStr[position], Toast.LENGTH_LONG).show();
            }
        });
    }
    class MyListAdapter extends BaseAdapter{
        private int[] colors = new int[] { 0xff626569, 0xff4f5257 };
        public MyListAdapter(Context context){
            mContext = context;
        }
        @Override
        public int getCount() {
            return mListStr.length;
        }
        public boolean areAllItemsEnabled() {

            return false;

        }
        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//            image = (ImageView) findViewById(R.id.image);
//            title = (TextView) findViewById(R.id.title);
//            text = (TextView) findViewById(R.id.text);
            ImageView iamge = null;
            TextView title = null;
            TextView text = null;
//            ContentValues contentValues = new ContentValues();
            if (convertView == null){
                convertView = LayoutInflater.from(mContext).inflate(R.layout.activity_baseadapter,null);
                image = (ImageView) convertView.findViewById(R.id.image);
                title = (TextView) convertView.findViewById(R.id.title);
                text = (TextView) convertView.findViewById(R.id.text);
                int colorPos = position % colors.length;
                convertView.setBackgroundColor(colors[colorPos]);
                title.setText(mListTitle[position]);
                text.setText(mListStr[position]);
                image.setImageResource(R.drawable.in_icon);
                return convertView;
            }
            return null;
        }
    }
}
