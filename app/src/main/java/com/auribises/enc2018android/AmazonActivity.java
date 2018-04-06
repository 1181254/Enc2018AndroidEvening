package com.auribises.enc2018android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AmazonActivity extends AppCompatActivity {

    WebView webView;
    WebViewClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amazon);

        webView = findViewById(R.id.webView);

        client = new WebViewClient();

        webView.setWebViewClient(client);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.amazon.in/");
    }
}
