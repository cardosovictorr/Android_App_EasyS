package com.example.android_app_easys_version4.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toolbar;

import com.example.android_app_easys_version4.MainActivity;
import com.example.android_app_easys_version4.R;
import com.example.android_app_easys_version4.entities.Supplier;
import com.example.android_app_easys_version4.service.DataService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import static com.example.android_app_easys_version4.entities.Constants.ADD_SUPPLIER_ACTIVITY_CODE;


public class OptionsPageActivity extends AppCompatActivity {

    private DataService supplierDataService;
    private View rootView;

    ImageButton backButton;
    Button createListSupplierButton;
    Button seeYourListButton;
    Button deleteSupplierButton;
    Button updateSupplierButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_page);

        rootView = findViewById(android.R.id.content).getRootView();

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
                addNewSupplier();
            }
        });


        //Button, if clicked, to see the list of the suppliers the user has added
        seeYourListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //viewAll(v);

                Intent goToSeeSupplierPageIntent = new Intent(OptionsPageActivity.this, SuppliersRecyclerViewActivity.class);

                startActivity(goToSeeSupplierPageIntent);
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

        supplierDataService = new DataService();
        supplierDataService.init(OptionsPageActivity.this);

    }

    private void viewAll(View v) {

        /*
        List<Supplier> suppliers = supplierDataService.getSupplier();
        String text = "";

        if (suppliers.size() > 0){
            for(Supplier supplier : suppliers){
                text = text.concat(supplier.toString());
            }
            showMessage("Data", text);
        }else{
            showMessage("Records", "Nothing found");
        }

         */
    }

    private void addNewSupplier() {

        Intent goToAddSupplierPageIntent = new Intent(OptionsPageActivity.this,AddSuppliersScrollingActivity.class);

        startActivityForResult(goToAddSupplierPageIntent, ADD_SUPPLIER_ACTIVITY_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADD_SUPPLIER_ACTIVITY_CODE){
            if(resultCode == RESULT_OK){
                addSupplier(data);
            }
        }
    }

    private void addSupplier(Intent data) {
        String message;

        Supplier supplier = (Supplier) data.getSerializableExtra(Supplier.SUPPLIER_KEY);

        Long result = supplierDataService.add(supplier);
        //that result will hold the id of the supplier. So if comes a positve number, it created the monster, if is -1 is an error
        if(result > 0){
            message = "Your supplier was created with the id: " + result;
        } else{
            message = "There was an error, please try again";
        }
        Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show();
    }

    private void showMessage(String data, String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(data);
        builder.setMessage(text);

        builder.show();
    }

}
