package com.example.android_app_easys_version4.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_app_easys_version4.R;

public class UpdateSupplierActivity extends AppCompatActivity {

    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_supplier);

        cancelButton = findViewById(R.id.cancelButton);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMainPageUserIntent = new Intent(UpdateSupplierActivity.this,OptionsPageActivity.class);

                startActivity(goToMainPageUserIntent);
            }
        });

    }
}
