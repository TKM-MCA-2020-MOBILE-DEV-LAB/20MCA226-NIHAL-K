package com.example.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public static final String Constant = "CUST";
    public static final String id = "id";
    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String ACTIVE = "active";

    public Database(@Nullable Context context) {
        super(context, "Customer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String detail= "CREATE TABLE " + Constant + "(" + id + " integer primary key autoincrement," + NAME + " Text," + AGE + " integer," + ACTIVE + " Boolean)";
        sqLiteDatabase.execSQL(detail);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public Boolean enter(Customer customer)
    {
        SQLiteDatabase db1=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(id,customer.getId());
        cv.put(NAME,customer.getCustomerName());
        cv.put(AGE,customer.getAge());
        long insert= db1.insert(Constant,null,cv);
        if(insert==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }


}
