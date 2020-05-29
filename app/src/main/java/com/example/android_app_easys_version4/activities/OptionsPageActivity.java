package com.example.android_app_easys_version4.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toolbar;

import com.example.android_app_easys_version4.MainActivity;
import com.example.android_app_easys_version4.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class OptionsPageActivity extends AppCompatActivity {

    ImageButton backButton;
    Button createListSupplierButton;
    Button seeYourListButton;
    Button deleteSupplierButton;
    Button updateSupplierButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_page);



        backButton = findViewById(R.id.backImageButton);
        createListSupplierButton = findViewById(R.id.createListSupplierButton);
        seeYourListButton = findViewById(R.id.seeYourListButton);
        deleteSupplierButton = findViewById(R.id.deleteSupplierButton);
        updateSupplierButton = findViewById(R.id.updateSupplierButton);

        //Button to get back to login page
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToLoginPageIntent = new Intent(OptionsPageActivity.this, MainActivity.class);

                startActivity(goToLoginPageIntent);

            }
        });


        //Button, if clicked, go to form to add new suppliers
        createListSupplierButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAddSupplierPageIntent = new Intent(OptionsPageActivity.this,AddSuppliersScrollingActivity.class);

                startActivity(goToAddSupplierPageIntent);
            }
        });


        //Button, if clicked, to see the list of the suppliers the user has added
        seeYourListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent goToSeeSupplierListPageIntent = new Intent(OptionsPageActivity.this, SeeListSupplierScrollingActivity.class);

                //startActivity(goToSeeSupplierListPageIntent);
            }
        });

        //Button to go to delete screen
        deleteSupplierButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDeleteSupplierPageIntent = new Intent(OptionsPageActivity.this, DeleteSupplierActivity.class);

                startActivity(goToDeleteSupplierPageIntent);
            }
        });


        //Button to Search Screen
        updateSupplierButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSearchSupplierPageIntent = new Intent(OptionsPageActivity.this, UpdateSupplierActivity.class);

                startActivity(goToSearchSupplierPageIntent);
            }

        });

    }

}
