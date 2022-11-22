package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class GitHubActivity extends AppCompatActivity {

    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);
        web = findViewById(R.id.WebView);
//        Whenever a user clicks on the webview in my activity the defult behavior for android is to lauch an application that handles urls. Usually the defult web browser opens and loads the destination url.
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
//        I'm overridng the defult behavior of my webview so that links open within my webview on my activity page.
        web.setWebViewClient(new Callback());
//        web.loadUrl("http://127.0.0.1:5555/HTML/index.html");
        web.loadUrl("https://github.com/Batking74");
    }

    private class Callback extends WebViewClient {
//        I'm telling android that this is my website so do not overwrite. let webview load the page.
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return false;
        }
    }
    public void BackToWelcomeActivity(View view) {
        Intent i = new Intent(this, WelcomeActivity.class);
        startActivity(i);
    }
}