package com.example.hospitalmanagementsystem.AddCanteenDetailManage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OwnerConfirmationDataBase extends SQLiteOpenHelper {
    public static final int VERSION=1;
    public static final String CreateDataBase="OwnerFoodOrder.DB";

    public OwnerConfirmationDataBase(Context context) {
        super(context,CreateDataBase,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query = "create table OwnerFoodOrder(id integer primary key autoincrement,name text,menuItem text,quantity text,floor text,bed text,phone text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists OwnerFoodOrder");
    }
    public boolean OwnerInsertBookingData(String name,String menuItem,String quantity,String floor,String bed,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("menuItem",menuItem);
        contentValues.put("quantity",quantity);
        contentValues.put("floor",floor);
        contentValues.put("bed",bed);
        contentValues.put("phone",phone);
        long l = sqLiteDatabase.insert("OwnerFoodOrder",null,contentValues);
        if (l>0){
            return true;
        }else {
            return false;
        }
    }
    public Cursor getOwnerAllData(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from OwnerFoodOrder",null);
        return cursor;
    }

}
