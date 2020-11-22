package com.example.fypdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
// This code was used from a YouTube tutorial "https://www.youtube.com/watch?v=hDSVInZ2JCs"
public class DataBase extends SQLiteOpenHelper {

    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String COLUMN_CUSTOMER_NAME = "CUSTOMER_NAME";
    public static final String COLUMN_CUSTOMER_AGE = "CUSTOMER_AGE";
    public static final String COLUMN_ID = "ID";

    public DataBase(@Nullable Context context) {
        super(context, "customer.db", null, 1);
    }

    //Called first time database is accessed. Should be code to create DB here
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + CUSTOMER_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CUSTOMER_NAME + " TEXT, " + COLUMN_CUSTOMER_AGE + " INT )";

        db.execSQL(createTableStatement);

    }

    //Called if DB version number changes. Prevents previous users apps breaking
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addOne(CustomerDetail customerDetail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CUSTOMER_NAME, customerDetail.getName());
        cv.put(COLUMN_CUSTOMER_AGE, customerDetail.getAge());

        long insert = db.insert(CUSTOMER_TABLE, null, cv);
        if (insert == -1) {
            return false;
        }

        return true;
    }

    public List<CustomerDetail> getEveryone() {

    List<CustomerDetail> returnList = new ArrayList<>();

    //get data from DB

        String queryString = "SELECT * FROM " + CUSTOMER_TABLE;

        //better to choose readable database as more processes can be carried out

        SQLiteDatabase db = this.getReadableDatabase();

     // cursor is the result set
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            // loop through cursor and create new customer object put into return list
            do {
                int customerID = cursor.getInt( 0);
                String customerName = cursor.getString( 1);
                int customerAge = cursor.getInt( 2);

                CustomerDetail newCustomer = new CustomerDetail(customerID, customerName, customerAge);
                returnList.add(newCustomer);

             //proceed through DB one at a time
            } while (cursor.moveToNext());

        }
        else {
            // do not add anything to list

        }
        // close cursor and the DB when finished
        cursor.close();
        db.close();
        return returnList;

    }
}
