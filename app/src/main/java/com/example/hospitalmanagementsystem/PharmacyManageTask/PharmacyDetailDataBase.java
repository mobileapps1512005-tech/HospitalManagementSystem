package com.example.hospitalmanagementsystem.PharmacyManageTask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class PharmacyDetailDataBase extends SQLiteOpenHelper {
public static final int VERSION=1;
public static final String CreateDataBaseName="Pharmacy.DB";

    public PharmacyDetailDataBase(@Nullable Context context) {
        super(context,CreateDataBaseName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table Pharmacy(id integer primary key autoincrement,name text,email text,phone text,location text,pharmacyName text,qualification text,EmergencyService text,discount text,returns text,EmergencyTime text,home text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          db.execSQL("drop table if exists Pharmacy");
    }
    public boolean InsertPharmacyDetails(String name,String email,String phone,String location,String pharmacyName,String qualification,String EmergencyService,String discount,String returns,String EmergencyTime,String home){
       SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("pharmacyName",pharmacyName);
        contentValues.put("phone",phone);
        contentValues.put("location",location);
        contentValues.put("qualification",qualification);
        contentValues.put("EmergencyService",EmergencyService);
        contentValues.put("discount",discount);
        contentValues.put("returns",returns);
        contentValues.put("EmergencyTime",EmergencyTime);
        contentValues.put("home",home);
      long l = sqLiteDatabase.insert("Pharmacy",null,contentValues);
      if (l>0){
          return true;
      }else {
          return false;
       }
    }

    public boolean InsertUpdateDetails(int id,String name,String email,String phone,String location,String pharmacyName,String qualification,String EmergencyService,String discount,String returns,String EmergencyTime,String home){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("pharmacyName",pharmacyName);
        contentValues.put("phone",phone);
        contentValues.put("location",location);
        contentValues.put("qualification",qualification);
        contentValues.put("EmergencyService",EmergencyService);
        contentValues.put("discount",discount);
        contentValues.put("returns",returns);
        contentValues.put("EmergencyTime",EmergencyTime);
        contentValues.put("home",home);
        long l = sqLiteDatabase.update("Pharmacy",contentValues,"id=?",new String[]{String.valueOf(id)});
        if (l==-1){
            return false;
        }else {
            return true;
        }
    }
    public Cursor GetAllPharmacyDetail(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Pharmacy",null);
        return cursor;
    }
    public void DeletePharmacyDetails(int id){
       SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
       sqLiteDatabase.delete("Pharmacy","id=?",new String[]{String.valueOf(id)});
       sqLiteDatabase.close();
    }
}
