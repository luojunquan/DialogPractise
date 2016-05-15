package com.practice.viewavtivity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by 赖上罗小贱 on 2016/5/10.
 */
public class WebViewActivity extends Activity{
    private WebView web1;
    static final String MIME_TYPE = "text/html";
    static final String ENCODING = "utf-8";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        web1 = (WebView) findViewById(R.id.web_1);
        web1.loadDataWithBaseURL(null,"<a href='http://blog.csdn.net/xys289187120'>欢迎访问雨松MOMO的博客</a>",
                MIME_TYPE,ENCODING,null);
    }
}
