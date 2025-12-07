package com.example.hospitalmanagementsystem.AddCanteenDetailManage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class FoodOrderPatientDataBase extends SQLiteOpenHelper {
public static final int VERSION=1;
public static final String CreateDataBase="FoodOrder.DB";

    public FoodOrderPatientDataBase(Context context) {
        super(context,CreateDataBase,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query = "create table FoodOrder(id integer primary key autoincrement,name text,menuItem text,quantity text,floor text,bed text,phone text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("drop table if exists FoodOrder");
    }
    public boolean InsertBookingData(String name,String menuItem,String quantity,String floor,String bed,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("menuItem",menuItem);
        contentValues.put("quantity",quantity);
        contentValues.put("floor",floor);
        contentValues.put("bed",bed);
        contentValues.put("phone",phone);
     long l = sqLiteDatabase.insert("FoodOrder",null,contentValues);
        if (l>0){
            return true;
        }else {
            return false;
        }
    }
    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from FoodOrder",null);
        return cursor;
    }
    public void DeleteGetAll(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        sqLiteDatabase.delete("FoodOrder","id=?",new String[]{String.valueOf(id)});
    }
}
