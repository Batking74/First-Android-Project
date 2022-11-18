package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;

import android.util.Log;

import android.view.View;

import android.widget.Button;

import android.widget.Switch;

import android.widget.TextView;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*        R: Resources
          layout: file name
          activity_main: The xml file inside the layout folder
          id: Targets a specific view id name/label
*/
        setContentView(R.layout.activity_main);
    }

    public void signIn(View view) {
        Switch mySwitch = findViewById(R.id.SwitchView);
        String username = ((TextView)findViewById(R.id.UsernameInputView)).getText().toString();
        String password = ((TextView)findViewById(R.id.PasswordInputView)).getText().toString();
        validateUserInput(username, password, mySwitch);
        }

    @SuppressLint("SetTextI18n")
    public void validateUserInput(String username, String password, Switch mySwitch) {
        if(username.isEmpty() && password.isEmpty()) {
            Toast.makeText(this, "Username and password is required!", Toast.LENGTH_LONG).show();
        }
        else if(username.isEmpty()) {
            Toast.makeText(this, "Username is required!", Toast.LENGTH_LONG).show();
        }
        else if(password.isEmpty()) {
            Toast.makeText(this, "Password is required!", Toast.LENGTH_LONG).show();
        }
        else {
            ((TextView)findViewById(R.id.TittleView)).setText("Welcome " + username + "!");
            findViewById(R.id.SignInButton).setEnabled(false);
            String [] message = {" Your Credentials Have Been Saved!", " Thank You, Your Credentials Will Not Be Remembered!", "Done!", "User Requested not to have their Credentials saved"};
            ((Button)findViewById(R.id.SignInButton)).setText(message[2]);
            validateSwitch(mySwitch, username, password, message[0], message[1], message[3]);
            Intent myIntent = new Intent(this, WelcomeActivity.class);
            startActivity(myIntent);
        }
    }

    public void validateSwitch(@SuppressLint("UseSwitchCompatOrMaterialCode") Switch rememberMeSwitch, String username, String password, String saveCredentialMessage, String ignoreCredentialMessage, String ignoreCredentialMessageTwo) {
        if(rememberMeSwitch.isChecked()) {
            Log.e("User Info", "Username is: " + username);
            Log.e("User Info", "Password is: " + password);
            Toast.makeText(this, "Hello " + username + saveCredentialMessage, Toast.LENGTH_LONG).show();
        }
        else {
            Log.i("Program", ignoreCredentialMessageTwo);
            Log.i("Program", ignoreCredentialMessage);
            Toast.makeText(this, "Hello " + username + ignoreCredentialMessage, Toast.LENGTH_LONG).show();
        }
    }
}