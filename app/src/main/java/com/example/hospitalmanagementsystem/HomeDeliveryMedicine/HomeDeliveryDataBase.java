package com.example.hospitalmanagementsystem.HomeDeliveryMedicine;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HomeDeliveryDataBase extends SQLiteOpenHelper {
public static final int VERSION=1;
public static final String CreateDataBaseName="HomeDeliveryDB";
    public HomeDeliveryDataBase(Context context) {
        super(context,CreateDataBaseName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table HomeDelivery(id integer primary key,name text,email text,location text,phone text,gender text,experience text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists HomeDelivery");
    }
    public boolean InsertHomeDelivery(String name,String email,String location,String phone,String gender,String experience){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("location",location);
        contentValues.put("phone",phone);
        contentValues.put("gender",gender);
        contentValues.put("experience",experience);
      long l = sqLiteDatabase.insert("HomeDelivery",null,contentValues);
      if (l>0){
          return true;
      }else {
          return false;
      }
    }
    public Cursor GetAllDetails(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from HomeDelivery",null);
        return cursor;
    }
}
