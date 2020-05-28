package com.example.android_app_easys_version4.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.android_app_easys_version4.entities.Supplier;

import java.util.ArrayList;
import java.util.List;

public class SupplierDatabaseHelper extends SQLiteOpenHelper {

    //constant for database (name, version and table name that will be used)
    private static final String DATABASE_NAME = "supplier.db";
    private static final Integer DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "supplier";

    //creating the constants to use in the create statement
    //I will use even the mobile number as string...
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "NAME";
    private static final String COL_CATEGORY = "CATEGORY";
    private static final String COL_MOBILE = "MOBILE";
    private static final String COL_EMAIL = "EMAIL";
    private static final String COL_IMAGE = "IMAGE";

    private static final String DROP_TABLE_ST = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String GET_ALL_ST = "SELECT * FROM " + TABLE_NAME;

    private static SupplierDatabaseHelper mInstance = null;

    public static synchronized SupplierDatabaseHelper getInstance(Context ctx){
        if(mInstance == null){
            mInstance = new SupplierDatabaseHelper(ctx.getApplicationContext());
        }
        return mInstance;
    }

    //the constant below is to create the database. That will avoid type mistakes
    private static final String CREATE_TABLE_ST = "CREATE TABLE" + " " + TABLE_NAME + "(" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NAME + " TEXT, " +
            COL_CATEGORY + " TEXT, " +
            COL_MOBILE + " TEXT, " +
            COL_EMAIL + " TEXT, "  +
            COL_IMAGE + " TEXT " +
            ")";

    private SupplierDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //sql statement to create the database (id autoincrement, new ColumnDatatype, new etc...
        db.execSQL(CREATE_TABLE_ST);
    }

    //that is used to upgrade the version of the database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_ST);
        onCreate(db);
    }

    public Long insert(String name, String category, String mobile, String email){
        // create an instance of SQLLITE database
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_CATEGORY, category);
        contentValues.put(COL_MOBILE, mobile);
        contentValues.put(COL_EMAIL, email);
        //need the IMAGE PART

        long result = db.insert(TABLE_NAME,null, contentValues);
        db.close();

        return result;
    }

    //create here a method to get Image!!

    public boolean update(Long id, String name, String category, String mobile, String email){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_ID, id);
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_CATEGORY, category);
        contentValues.put(COL_MOBILE, mobile);
        contentValues.put(COL_EMAIL, email);

        int numOfRowsUpdated = db.update(TABLE_NAME, contentValues,"ID = ?", new String[]{id.toString()} );
        db.close();
        return numOfRowsUpdated == 1;
    }

    public boolean delete( Long id){
        SQLiteDatabase db = this.getWritableDatabase();
        //new String[]{}
        String valueArray[] = new String[1];
        valueArray[1] = id.toString();

        int numOfRowsDeleted = db.delete(TABLE_NAME, "ID = ?", valueArray);
        db.close();

        boolean res = false;
        if(numOfRowsDeleted == 1)
            res = true;
        else
            res = false;
        return res;
    }

    public List<Supplier> getSupplier(){
        List<Supplier> suppliers = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(GET_ALL_ST, null);

        if(cursor.getCount() > 0){
            Supplier supplier;
            while(cursor.moveToNext()){
                Long id = cursor.getLong(0);
                String name = cursor.getString(1);
                String category = cursor.getString(2);
                String mobile = cursor.getString(3);
                String email = cursor.getString(4);
                String imageFileName = cursor.getString(5);

                supplier = new Supplier(id, name, category, mobile, email, imageFileName);
                suppliers.add(supplier);
            }
        }
        cursor.close();
        return suppliers;

    }

}
