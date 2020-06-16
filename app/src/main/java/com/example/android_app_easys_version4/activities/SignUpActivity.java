package com.example.android_app_easys_version4.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_app_easys_version4.MainActivity;
import com.example.android_app_easys_version4.R;

public class SignUpActivity extends AppCompatActivity {

    Button cancelButton;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        cancelButton = findViewById(R.id.cancelButton);
        signUp = findViewById(R.id.signUpButton);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLoginPageUserIntent = new Intent(SignUpActivity.this, MainActivity.class);

                startActivity(goToLoginPageUserIntent);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLOptionPageIntent = new Intent(SignUpActivity.this, OptionsPageActivity.class);

                startActivity(goToLOptionPageIntent);
            }
        });

    }
}
