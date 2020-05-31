package com.example.android_app_easys_version4.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android_app_easys_version4.R;
import com.example.android_app_easys_version4.entities.Supplier;
import com.example.android_app_easys_version4.service.DataService;
import com.google.android.material.snackbar.Snackbar;

public class DeleteSupplierActivity extends AppCompatActivity {

    private DataService supplierDataService;
    
    Button cancelButton;
    Button deleteButton;
    EditText supplierIDEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_supplier);

        deleteButton = findViewById(R.id.deleteButton);
        cancelButton = findViewById(R.id.cancelButton);
        supplierIDEditText = findViewById(R.id.supplierIDEditText);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(v);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMainPageUserIntent = new Intent(DeleteSupplierActivity.this,OptionsPageActivity.class);

                startActivity(goToMainPageUserIntent);
            }
        });


    }

    private void delete(View v) {
        String id = supplierIDEditText.getText().toString();
        if(isSupplierEmpty(v, id))
            return;

        Supplier supplier = new Supplier();
        supplier.setId(Long.valueOf(id));
        boolean result = supplierDataService.delete(supplier);
        if(result)
            Snackbar.make(v,"Supplier id " + id + " was deleted", Snackbar.LENGTH_SHORT).show();
        else
            Snackbar.make(v,"Error, Supplier id " + id + " was not deleted.", Snackbar.LENGTH_SHORT).show();
    }

    private boolean isSupplierEmpty(View v, String id) {
        if(id.trim().isEmpty()){
            Snackbar.make(v,"You must input the supplier ID ", Snackbar.LENGTH_SHORT).show();
            supplierIDEditText.requestFocus();
            return true;
        }
        return false;
    }
}
