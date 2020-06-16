package com.example.android_app_easys_version4.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_app_easys_version4.R;
import com.example.android_app_easys_version4.entities.Supplier;

public class SupplierDetailActivity extends AppCompatActivity {

    Supplier supplier;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_detail);
    }

    //ImageView supplierImageView = findViewById(R.id.supplierImageView);
    TextView supplierName = findViewById(R.id.supplierNameRecyclerTextView);
    TextView supplierCategory = findViewById(R.id.supplierCategoryRecyclerTextView);
    TextView supplierMobile = findViewById(R.id.supplierMobileRecyclerTextView);
    TextView supplierEMail = findViewById(R.id.supplierEmailRecyclerTextView);

    //Intent intentThatCalled = getIntent();
    //if(intentThatCalled.)
}
