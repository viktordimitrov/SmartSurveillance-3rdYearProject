package com.example.buckybarnes.test;

/**
 * Created by Dailin Luo on 2017/11/26.
 * Personal contributed class, with some reference from website:
 * https://developer.android.com/guide/webapps/webview.html
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class webview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        //open up the browser with the video streaming website
        String url = "http://192.168.0.104:6543";
        WebView view = (WebView) this.findViewById(R.id.webview);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);
    }
}