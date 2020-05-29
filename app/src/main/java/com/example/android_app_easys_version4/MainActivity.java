package com.example.android_app_easys_version4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_app_easys_version4.activities.LogInActivity;

public class MainActivity extends AppCompatActivity {

    Button startApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startApp = findViewById(R.id.startButton);

        startApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLoginScreenIntent = new Intent(MainActivity.this, LogInActivity.class);

                startActivity(goToLoginScreenIntent);
            }
        });

    }

}
