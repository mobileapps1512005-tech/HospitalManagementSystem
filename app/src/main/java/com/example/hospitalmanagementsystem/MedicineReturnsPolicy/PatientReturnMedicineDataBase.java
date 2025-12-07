package com.example.hospitalmanagementsystem.MedicineReturnsPolicy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class PatientReturnMedicineDataBase extends SQLiteOpenHelper {
public static final int VERSION=1515;
public static final String CreateDataBaseName="ReturnMedicinesDB";

    public PatientReturnMedicineDataBase(Context context) {
        super(context,CreateDataBaseName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table ReturnMedicines(id integer primary key autoincrement,name text,condition text,phone text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists ReturnMedicines");
    }
    public boolean InsertMedicineData(String name,String condition,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("condition",condition);
        contentValues.put("phone",phone);
      long l = sqLiteDatabase.insert("ReturnMedicines",null,contentValues);
      if (l>0){
          return true;
      }else {
          return false;
      }
    }

    public Cursor GetAllDetails(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from ReturnMedicines",null);
        return cursor;
    }

    public void GetAllDetailss(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete("ReturnMedicines","id=?",new String[]{String.valueOf(id)});
    }
}
