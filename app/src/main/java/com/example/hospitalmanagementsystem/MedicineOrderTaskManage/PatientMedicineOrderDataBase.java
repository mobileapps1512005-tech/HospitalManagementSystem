package com.example.hospitalmanagementsystem.MedicineOrderTaskManage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PatientMedicineOrderDataBase extends SQLiteOpenHelper {
public static final int  VERSION=1;
public static final String CreateDataBaseName="MedicineOrder.DB";

    public PatientMedicineOrderDataBase(Context context) {
        super(context,CreateDataBaseName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table MedicineOrder(id integer primary key autoincrement,name text,email text,Phone text,Location text,deliveryLocation text,medicineName text,orders text,requiredDate text,requiredTime text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         db.execSQL("drop table if exists MedicineOrder");
    }
    public boolean InsertMedicineDetails(String name,String email,String Phone,String Location,String deliveryLocation,String medicineName,String orders,String requiredDate,String requiredTime){
      SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
      ContentValues contentValues = new ContentValues();
      contentValues.put("name",name);
      contentValues.put("email",email);
      contentValues.put("Phone",Phone);
      contentValues.put("Location",Location);
      contentValues.put("deliveryLocation",deliveryLocation);
      contentValues.put("medicineName",medicineName);
      contentValues.put("orders",orders);
      contentValues.put("requiredDate",requiredDate);
      contentValues.put("requiredTime",requiredTime);
      long l = sqLiteDatabase.insert("MedicineOrder",null,contentValues);
      if (l>0){
          return true;
      }else {
          return false;
      }
    }


    public boolean UpdateMedicineDetails(int id,String name,String email,String Phone,String Location,String deliveryLocation,String medicineName,String orders,String requiredDate,String requiredTime){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("Phone",Phone);
        contentValues.put("Location",Location);
        contentValues.put("deliveryLocation",deliveryLocation);
        contentValues.put("medicineName",medicineName);
        contentValues.put("orders",orders);
        contentValues.put("requiredDate",requiredDate);
        contentValues.put("requiredTime",requiredTime);
        long l = sqLiteDatabase.update("MedicineOrder",contentValues,"id=?",new String[]{String.valueOf(id)});
        if (l==-1){
            return false;
        }else {
            return true;
        }
    }


    public Cursor GetAllDetails(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from MedicineOrder",null);
        return cursor;
    }

    public void GetDeleteMedicineDetails(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        sqLiteDatabase.delete("MedicineOrder","id=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }

}
