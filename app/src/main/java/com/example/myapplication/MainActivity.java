package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

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

    public void validateMainActivity(View view) {
        Switch mySwitch = findViewById(R.id.SwitchView);
        String usersUsername = ((TextView)findViewById(R.id.UsernameInputView)).getText().toString();
        String usersPassword = ((TextView)findViewById(R.id.PasswordInputView)).getText().toString();
        String [] userData = {usersUsername, usersPassword};
        String [] message = {" Your Credentials Have Been Saved!", " Thank You, Your Credentials Will Not Be Remembered!", "Done!", "User Requested not to have their Credentials saved"};
        ((TextView)findViewById(R.id.TittleView)).setText("Welcome " + usersUsername + "!");
        findViewById(R.id.SignInButton).setEnabled(false);
        ((Button)findViewById(R.id.SignInButton)).setText(message[2]);
        validateSwitch(mySwitch, userData[0], userData[1], message[0], message[1], message[3]);
    }

    public void validateSwitch(Switch rememberMeSwitch, String username, String password, String saveCredentialMessage, String ignoreCredentialMessage, String ignoreCredentialMessageTwo) {
        if(rememberMeSwitch.isChecked()) {
            Log.i("User Info", "Username is: " + username);
            Log.i("User Info", "Password is: " + password);
            Toast.makeText(this, "Hello " + username + saveCredentialMessage, Toast.LENGTH_LONG).show();
        }
        else {
            Log.i("Program", ignoreCredentialMessageTwo);
            Log.i("Program", ignoreCredentialMessage);
            Toast.makeText(this, "Hello " + username + ignoreCredentialMessage, Toast.LENGTH_LONG).show();
        }
    }
}