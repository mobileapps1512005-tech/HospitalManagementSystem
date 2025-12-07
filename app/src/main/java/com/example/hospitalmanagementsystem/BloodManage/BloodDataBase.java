package com.example.hospitalmanagementsystem.BloodManage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class BloodDataBase extends SQLiteOpenHelper {
public static final int VERSION=1515;
public static final String CreateDataBaseName="BloodDB";

    public BloodDataBase(Context context) {
        super(context,CreateDataBaseName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="Create table Blood(id integer primary key autoincrement,hospital text,bloodType text,bloodQuantity text,phone text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("drop table if exists Blood");
    }

    public boolean InsertBloodDetails(String hospital,String bloodType,String bloodQuantity,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hospital",hospital);
        contentValues.put("bloodType",bloodType);
        contentValues.put("bloodQuantity",bloodQuantity);
        contentValues.put("phone",phone);
        long l = sqLiteDatabase.insert("Blood",null,contentValues);
        if (l>0) {
            return true;
        }else {
            return false;
        }
    }

    public boolean UpdateBloodDetails(int id,String hospital,String bloodType,String bloodQuantity,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hospital",hospital);
        contentValues.put("bloodType",bloodType);
        contentValues.put("bloodQuantity",bloodQuantity);
        contentValues.put("phone",phone);
        long l = sqLiteDatabase.update("Blood",contentValues,"id=?",new String[]{String.valueOf(id)});
        if (l==-1) {
            return false;
        }else {
            return true;
        }
    }
    public void GetDeleteDetails(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        sqLiteDatabase.delete("Blood","id=?",new String[]{String.valueOf(id)});
    }
    public Cursor GetAllDetails(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Blood",null);
        return cursor;
    }
}
