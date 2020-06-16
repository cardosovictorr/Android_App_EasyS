package com.example.android_app_easys_version4.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_app_easys_version4.R;
import com.example.android_app_easys_version4.entities.Supplier;

public class SupplierViewHolder extends RecyclerView.ViewHolder {

    public ImageView supplierImageView = null;
    public TextView supplierNameTextView = null;
    public TextView supplierCategoryTextView = null;
    public TextView supplierMobileTextView = null;
    public TextView supplierEmailTextView = null;

    private OnSupplierListener onSupplierListener;

    //maps the UI compnents to the XML layout
    public SupplierViewHolder(@NonNull View itemView, OnSupplierListener onSupplierListener) {
        super(itemView);

        supplierImageView = itemView.findViewById(R.id.supplierImageView);
        supplierNameTextView = itemView.findViewById(R.id.supplierNameRecyclerTextView);
        supplierCategoryTextView = itemView.findViewById(R.id.supplierCategoryRecyclerTextView);
        supplierMobileTextView = itemView.findViewById(R.id.supplierMobileRecyclerTextView);
        supplierEmailTextView = itemView.findViewById(R.id.supplierEmailRecyclerTextView);

        this.onSupplierListener = onSupplierListener;
    }

    //making the data to my Vuew holder
    public void updateSupplier(Supplier supplier){

        //View rootView = supplierImageView.getRootView();
        supplierNameTextView.setText(supplier.getName());
        supplierCategoryTextView.setText(supplier.getCategory());
        supplierMobileTextView.setText(supplier.getMobile());
        supplierEmailTextView.setText(supplier.getEmail());
        //int resId = rootView.getResources().getIdentifier(supplier.getImageFileName(), "drawable", rootView.getContext().getPackageName());
        //supplierImageView.setImageResource(resId);
    }

    //Bind every Supplier with a listener, to click in a separete supplier

    public void bind(final Supplier supplier, final OnSupplierListener onSupplierListener){
        this.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSupplierListener.onSupplierClick(supplier);
            }
        });
    }

}
