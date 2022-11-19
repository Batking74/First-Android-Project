package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Intent i = getIntent();
        String greetUser = i.getStringExtra("Greet User");
        ((TextView)findViewById(R.id.GreetUser)).setText(greetUser);
//        setTitle("Hello");
    }

    public void launchSettings(View view) {
        Intent i = new Intent(this, Settings.class);
        startActivity(i);
    }
}