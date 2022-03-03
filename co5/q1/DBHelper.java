package com.example.co5_q1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "User.DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table userdata(name Text primary key, address TEXT, number TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists userdata");
    }
    public Boolean insertuserDB(String name,String address, String number){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("address",address);
        cv.put("number",number);
        long result = DB.insert("userdata",null,cv);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public Boolean UpdateuserDB(String name,String address, String number){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("address",address);
        cv.put("number",number);
        Cursor cursor = DB.rawQuery("Select * from userdata where name = ?",new String[]{name});
        if(cursor.getCount()>0){
        long result = DB.update("userdata",cv,"name=?",new String[]{name});
        if(result==-1){
            return false;
        }
        else{
            return true;
        }

       }
        else{
            return false;
        }
}
    public Boolean DeleteuserDB(String name){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from userdata where name = ?",new String[]{name});
        if(cursor.getCount()>0){
            long result = DB.delete("userdata","name=?",new String[]{name});
            if(result==-1){
                return false;
            }
            else{
                return true;
            }

        }
        else{
            return false;
        }
    }
    public Cursor getuserDB(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from userdata",null);
        return cursor;
    }

}
