package com.example.android_app_easys_version4.service;

import android.content.Context;

import com.example.android_app_easys_version4.database.SupplierDatabaseHelper;
import com.example.android_app_easys_version4.entities.Supplier;

import java.util.List;

public class DataService {
    //connecting to the database class
    private SupplierDatabaseHelper sqlite;

    public void connect(){

    }

    public void disconnect(){
    }

    public void init(Context context){ sqlite = sqlite.getInstance(context);}

    //adding a Supplier in the list (database)
    public Long add(Supplier supplier){
        return sqlite.insert(supplier.getName(), supplier.getCategory(), supplier.getMobile(), supplier.getEmail());
    }

    //deleting a supplier from the database according to its Id
    public boolean delete(Supplier supplier){

        return sqlite.delete(supplier.getId());
    }

    public boolean update(Supplier supplier){
        return sqlite.update(supplier.getId(), supplier.getName(), supplier.getCategory(), supplier.getMobile(), supplier.getEmail());
    }

    public List<Supplier> getSupplier(){
        List<Supplier> suppliers = sqlite.getSupplier();
        return suppliers;
    }
}
