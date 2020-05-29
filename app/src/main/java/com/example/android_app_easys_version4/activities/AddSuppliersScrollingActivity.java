package com.example.android_app_easys_version4.activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android_app_easys_version4.R;

import static com.example.android_app_easys_version4.entities.Constants.ADD_SUPPLIER_ACTIVITY_CODE;

public class AddSuppliersScrollingActivity extends AppCompatActivity {

    private EditText supplierNameEditText;
    private EditText supplierCategoryEditText;
    private EditText supplierMobileEditText;
    private EditText supplierEmailEditText;
    private Button addSupplier;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_suppliers_scrolling);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        supplierNameEditText = findViewById(R.id.supplierNameEditText);
        supplierCategoryEditText = findViewById(R.id.supplierCategoryEditText);
        supplierMobileEditText = findViewById(R.id.supplierMobileEditText);
        supplierEmailEditText = findViewById(R.id.supplierEmailEditText);
        addSupplier = findViewById(R.id.createListSupplierButton);
        cancelButton = findViewById(R.id.cancelButton);


        /*
        addSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

         */

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToOptionsPageIntent = new Intent(AddSuppliersScrollingActivity.this, OptionsPageActivity.class);

                startActivity(goToOptionsPageIntent);
            }
        });

    }

/*
    private void cancel(View v) {
    }

 */

/*
    private void add(View v) {
        String name = supplierNameEditText.getText().toString();
        if(name.trim().isEmpty()){
            Snackbar.make(v,"Name is required", Snackbar.LENGTH_SHORT).show();
            supplierNameEditText.getText().clear();
            supplierNameEditText.requestFocus();
            return;
        }
    }

 */

}
