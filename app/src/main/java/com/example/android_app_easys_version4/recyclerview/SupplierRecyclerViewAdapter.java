package com.example.android_app_easys_version4.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_app_easys_version4.R;
import com.example.android_app_easys_version4.entities.Supplier;

import java.util.List;

public class SupplierRecyclerViewAdapter extends RecyclerView.Adapter<SupplierViewHolder>{

    List<Supplier> suppliers;
    private Context context;

    public SupplierRecyclerViewAdapter(List<Supplier> supplier, Context context) {
        this.suppliers = suppliers;
        this.context = context;
    }

    @NonNull
    @Override
    public SupplierViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View supplierViewItem= inflater.inflate(R.layout.recycler_item_view, parent, false);

        SupplierViewHolder supplierViewHolder = new SupplierViewHolder(supplierViewItem);

        return supplierViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SupplierViewHolder holder, int position) {
        Supplier supplier = suppliers.get(position);
        holder.updateSupplier(supplier);

    }

    @Override
    public int getItemCount() {

        return suppliers.size();
    }
}
