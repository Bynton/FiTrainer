package com.bignerdranch.android.fitrainer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Benton on 4/24/2017.
 */

public class UserDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "CUSTOMERINFO.DB";
    private static final int DATABASE_VERSION = 1;
    private  static final  String CREATE_QUERY =
            "CREATE TABLE " + NewCustomer.NewCustomerInfo.TABLE_NAME + "(" + NewCustomer.NewCustomerInfo.NAME + " TEXT,"
            + NewCustomer.NewCustomerInfo.AGE + " TEXT," + NewCustomer.NewCustomerInfo.WEIGHT + " TEXT," + NewCustomer.NewCustomerInfo.GOAL + " TEXT);";

    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPPERATIONS", "Database made and opened..");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABEASE OPERATIONS","Database made..");
    }

    public void addInfo(String name, String age, String weight, String goal, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NewCustomer.NewCustomerInfo.NAME, name);
        contentValues.put(NewCustomer.NewCustomerInfo.AGE, age);
        contentValues.put(NewCustomer.NewCustomerInfo.WEIGHT, weight);
        contentValues.put(NewCustomer.NewCustomerInfo.GOAL, goal);
        db.insert(NewCustomer.NewCustomerInfo.TABLE_NAME, null, contentValues);
        Log.e("DATABEASE OPERATIONS","Row created..");
    }

    public Cursor getInfo(SQLiteDatabase db) {
        Cursor cursor;
        String[] projections = {NewCustomer.NewCustomerInfo.NAME, NewCustomer.NewCustomerInfo.AGE, NewCustomer.NewCustomerInfo.WEIGHT, NewCustomer.NewCustomerInfo.GOAL};
        cursor = db.query(NewCustomer.NewCustomerInfo.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
