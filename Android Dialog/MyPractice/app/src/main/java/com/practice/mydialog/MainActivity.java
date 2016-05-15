package com.practice.mydialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.*;
import java.util.ArrayList;

/*
@author 罗小贱
@date 2016年5月9日17:28:17
 */
public class MainActivity extends Activity {
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private Button bt5;
    private Button bt6;
    private Button bt7;
    private Button bt8;
    final String[] items = {"item0","item1","item2","item3","item4","item5","item6","item7"};
    int mSingleChoiceID = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = (Button) findViewById(R.id.bt_1);
        bt2 = (Button) findViewById(R.id.bt_2);
        bt3 = (Button) findViewById(R.id.bt_3);
        bt4 = (Button) findViewById(R.id.bt_4);
        bt5 = (Button) findViewById(R.id.bt_5);
        bt6 = (Button) findViewById(R.id.bt_6);
        bt7 = (Button) findViewById(R.id.bt_7);
        bt8 = (Button) findViewById(R.id.bt_8);
    }
    public void click1(View view){
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("你确定要离开吗?");
                builder.setIcon(R.drawable.in_icon);
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showDialog("你选择了取消");
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showDialog("你选择了确定");
                    }
                });
                builder.create().show();
            }
        });
    }
    public void click2(View view){
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.in_icon);
                builder.setTitle("投票");
                builder.setMessage("你认为什么样的内容能吸引你？");
                builder.setPositiveButton("有趣味的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showDialog("有趣味的");
                    }
                });
                builder.setNeutralButton("有思想的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showDialog("有思想的");
                    }
                });
                builder.setNegativeButton("主题强的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showDialog("主题强的");
                    }
                });
                //切记一定要创建并且show();
                builder.create().show();
            }
        });
    }
    public void click3(View view){
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("列表选择框");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showDialog(items[which]);
                    }
                });
                builder.create().show();
            }
        });
    }
    public void click4(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        mSingleChoiceID = -1;
        builder.setIcon(R.drawable.in_icon);
        builder.setTitle("单项选择");

        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mSingleChoiceID = which;
                showDialog("你选择的" + "id是" + items[mSingleChoiceID]);
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showDialog("你选择的是" + mSingleChoiceID);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showDialog("你选择的是" + mSingleChoiceID);
            }
        });
        builder.create().show();
    }
    public void click5(View view){
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setIcon(R.drawable.in_icon);
        progressDialog.setTitle("进度条窗口");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(100);
        progressDialog.setButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        progressDialog.setButton2("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        progressDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int Progress = 0;
                while (Progress < 100){
                    try {
                        Thread.sleep(100);
                        Progress++;
                        progressDialog.incrementProgressBy(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    //需要注意这个多项选择的点
    public void click6(View view){
//        MultiChoiceID 用于记录多选选中的id号 存在ArrayList中
//        选中后 add 进ArrayList
//        取消选中后 remove 出ArrayList。

        final ArrayList<Integer>MultiChoiceID = new ArrayList<Integer>();
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        MultiChoiceID.clear();
        builder.setIcon(R.drawable.in_icon);
        builder.setMultiChoiceItems(items, new boolean[]{false, false, false, false, false, false, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    MultiChoiceID.add(which);
                    showDialog("你选择的id为" + which + "," + items[which]);
                } else {
                    MultiChoiceID.remove(which);
                }
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "";
                int size = MultiChoiceID.size();
                for (int i = 0; i < size; i++) {
                    str += items[MultiChoiceID.get(i)] + ",";
                }
                showDialog("你选择的是" + str);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.create().show();
    }
    public void click7(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater factory = LayoutInflater.from(this);
        final View textEntryView = factory.inflate(R.layout.test,null);
        builder.setIcon(R.drawable.in_icon);
        builder.setTitle("自定义输入框");
        builder.setView(textEntryView);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText userName = (EditText) textEntryView.findViewById(R.id.etUserName);

                EditText password = (EditText) textEntryView.findViewById(R.id.etPassWord);

                showDialog("姓名 ：" + userName.getText().toString() + "密码：" + password.getText().toString());
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        builder.create().show();
    }
        public void click8(View view){
            ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("读取ing");
            progressDialog.setMessage("正在读取中请稍候");
            /*
            setIndeterminate(true)的意思就是不明确具体进度,进度条在最大值与最小值之间来回移动,
            形成一个动画效果,就是仅仅告诉你,我在工作,但是无法知道工作到那个阶段,而setIndeterminate(false)则相反,
            可能你会有疑问,为什么true的时候是不确定,false的时候反而是确定的呢?因为indeterminate本身是不确定,不明确的意思,负负得正知道吧?
             */
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(true);
            progressDialog.show();
        }

    private void showDialog(String str) {
        new AlertDialog.Builder(MainActivity.this).setMessage(str).show();
    }
}
