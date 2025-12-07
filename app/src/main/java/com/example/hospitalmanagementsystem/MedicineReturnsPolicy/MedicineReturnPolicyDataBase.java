package com.example.hospitalmanagementsystem.MedicineReturnsPolicy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class MedicineReturnPolicyDataBase extends SQLiteOpenHelper {
public static final int VERSION=1515;
public static final String CreateDataBaseName="MedicineReturn.DB";
    public MedicineReturnPolicyDataBase(Context context) {
        super(context,CreateDataBaseName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query = "create table MedicineReturn(id integer primary key autoincrement,name text,condition text,phone text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("drop table if exists MedicineReturn");
    }

    public boolean InsertDataPolicy(String name,String condition,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("condition",condition);
        contentValues.put("phone",phone);
     long l = sqLiteDatabase.insert("MedicineReturn",null,contentValues);
     if (l>0) {
         return true;
       }else {
        return false;
        }
    }

    public boolean UpdateDataPolicy(int id,String name,String condition,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("condition",condition);
        contentValues.put("phone",phone);
        long l = sqLiteDatabase.update("MedicineReturn",contentValues,"id=?",new String[]{String.valueOf(id)});
        if (l==-1){
            return false;
        }else {
            return true;
        }
    }


    public Cursor GetAllPolicyDetails(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from MedicineReturn",null);
        return cursor;
    }
    public void DeleteMedicineDetails(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        sqLiteDatabase.delete("MedicineReturn","id=?",new String[]{String.valueOf(id)});
    }
    public void GetDeleteMedicine(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete("MedicineReturn","id=?",new String[]{String.valueOf(id)});
    }
}
