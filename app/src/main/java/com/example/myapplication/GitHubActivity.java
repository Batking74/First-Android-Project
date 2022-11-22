package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class GitHubActivity extends AppCompatActivity {

    WebView web;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);
        web = findViewById(R.id.WebView);
//        Whenever a user clicks on the web-view in my activity the default behavior for android is to launch an application that handles urls. Usually the default web browser opens and loads the destination url.
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
//        I'm overriding the default behavior of my web-view so that links open within my web-view on my activity page.
        web.setWebViewClient(new Callback());
//        web.loadUrl("http://127.0.0.1:5555/HTML/index.html");
        web.loadUrl("https://github.com/Batking74");
    }

    private static class Callback extends WebViewClient {
//        I'm telling android that this is my website so do not overwrite. let web-view load the page.
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