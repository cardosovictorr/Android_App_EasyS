package com.example.android_app_easys_version4.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.android_app_easys_version4.R;
import com.example.android_app_easys_version4.entities.Supplier;
import com.example.android_app_easys_version4.recyclerview.SupplierRecyclerViewAdapter;
import com.example.android_app_easys_version4.service.DataService;

import java.util.ArrayList;
import java.util.List;

public class SuppliersRecyclerViewActivity extends AppCompatActivity {

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

        suppliers = supplierDataService.getSupplier();

        SupplierRecyclerViewAdapter adapter = new SupplierRecyclerViewAdapter(suppliers, this);

        supplierRecyclerView.setAdapter(adapter);
    }
}
