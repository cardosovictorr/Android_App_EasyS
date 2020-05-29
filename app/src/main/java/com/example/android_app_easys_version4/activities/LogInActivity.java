package com.example.android_app_easys_version4.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.android_app_easys_version4.R;

public class LogInActivity extends AppCompatActivity {

    Button loginButton;
    Button siginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        loginButton = findViewById(R.id.logInButton);
        siginButton = findViewById(R.id.signInButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToOptionsPageIntent = new Intent(LogInActivity.this,OptionsPageActivity.class);

                startActivity(goToOptionsPageIntent);
            }
        });

        siginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSignUpPage = new Intent(LogInActivity.this, SignUpActivity.class);

                startActivity(goToSignUpPage);
            }
        });

    }
}
