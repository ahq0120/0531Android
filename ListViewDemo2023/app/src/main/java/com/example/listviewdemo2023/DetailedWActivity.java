package com.example.listviewdemo2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DetailedWActivity extends AppCompatActivity {

    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detailed_w);

        wv = (WebView) findViewById(R.id.wondersWebView);
        wv.setWebViewClient(new WebViewClient());
        WebSettings webSettings = wv.getSettings();
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(true);
        wv.getSettings().setJavaScriptEnabled(true);


        String wondersName = getIntent().getStringExtra("wondersName");
        String wondersURL = getIntent().getStringExtra("wondersURL");
        getSupportActionBar().setTitle(wondersName);
        wv.loadUrl(wondersURL);
    }
    public  boolean onKeyDown(int keyCode, KeyEvent event){
        if ((keyCode == KeyEvent.KEYCODE_BACK)&&(wv.canGoBack()))
        {
            wv.goBack();
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}