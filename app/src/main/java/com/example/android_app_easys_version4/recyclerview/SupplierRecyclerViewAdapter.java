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
    private OnSupplierListener onSupplierListener;

    public SupplierRecyclerViewAdapter(List<Supplier> suppliers, Context context, OnSupplierListener onSupplierListener) {
        this.suppliers = suppliers;
        this.context = context;
        this.onSupplierListener = onSupplierListener;
    }

    @NonNull
    @Override
    public SupplierViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View supplierViewItem= inflater.inflate(R.layout.recycler_item_view, parent, false);

        SupplierViewHolder supplierViewHolder = new SupplierViewHolder(supplierViewItem, onSupplierListener);

        return supplierViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SupplierViewHolder holder, int position) {
        //call the data from the list
        Supplier supplier = suppliers.get(position);
        //call the method to set the values in the SupplieView Holeder
        holder.updateSupplier(supplier);
        holder.bind(supplier, onSupplierListener);
    }

    //the folloeing will give the count of the list size, how many row it has
    @Override
    public int getItemCount() {

        return suppliers.size();
    }
}
