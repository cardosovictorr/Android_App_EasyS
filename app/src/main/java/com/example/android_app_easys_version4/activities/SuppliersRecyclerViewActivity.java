package com.example.android_app_easys_version4.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.android_app_easys_version4.R;
import com.example.android_app_easys_version4.entities.Supplier;
import com.example.android_app_easys_version4.recyclerview.OnSupplierListener;
import com.example.android_app_easys_version4.recyclerview.SupplierRecyclerViewAdapter;
import com.example.android_app_easys_version4.service.DataService;

import java.util.ArrayList;
import java.util.List;

import static com.example.android_app_easys_version4.entities.Constants.DETAIL_SUPPLIER_ACTIVITY_CODE;

public class SuppliersRecyclerViewActivity extends AppCompatActivity implements OnSupplierListener {

    private DataService supplierDataService;
    private Supplier supplier;
    private View rootView;
    private List<Supplier> suppliers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suppliers_recycler_view);

        RecyclerView supplierRecyclerView = findViewById(R.id.supplierRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        supplierRecyclerView.setLayoutManager(linearLayoutManager);

        //load the data
        supplierDataService = new DataService();
        supplierDataService.init(this);
        //database created finde Deviced File Explores

        //Load Data from the database
        suppliers = supplierDataService.getSupplier();
        //create adapter passing the data, and the context
        SupplierRecyclerViewAdapter adapter = new SupplierRecyclerViewAdapter(suppliers, this, this);
        //attach the adapter to  to the Recycler View
        supplierRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onSupplierClick(Supplier supplier) {
        showSupplierDetail(supplier);
    }

    private void showSupplierDetail(Supplier supplier) {
        Intent goToSuppliersDetail = new Intent(this, SupplierDetailActivity.class);
        goToSuppliersDetail.putExtra(Supplier.SUPPLIER_KEY,supplier);

        startActivityForResult(goToSuppliersDetail, DETAIL_SUPPLIER_ACTIVITY_CODE);
    }
}
