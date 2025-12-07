package com.example.hospitalmanagementsystem.AddBodyCheckUpCost;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CheckUpBookingDataBase extends SQLiteOpenHelper {
    public static final int VERSION=1;
    public static final String CreateDataBaseName="ChecksBook.DB";

    public CheckUpBookingDataBase(Context context) {
        super(context,CreateDataBaseName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table CheckUpBook(id integer primary key autoincrement,name text,part text,price text,discounts text,phone text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists CheckUpBook");
    }

    public boolean InsertData(String name,String part,String price,String discounts,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("part",part);
        contentValues.put("price",price);
        contentValues.put("discounts",discounts);
        contentValues.put("phone",phone);
        long l = sqLiteDatabase.insert("CheckUpBook",null,contentValues);
        if (l>0){
            return true;
        }else {
            return false;
        }
    }

    public Cursor AllGetDetails(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from CheckUpBook",null);
        return cursor;
    }

//    public boolean UpdateData(int id,String name,String part,String price,String discounts,String phone){
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name",name);
//        contentValues.put("part",part);
//        contentValues.put("price",price);
//        contentValues.put("discounts",discounts);
//        contentValues.put("phone",phone);
//        long l = sqLiteDatabase.update("CheckUpBook",contentValues,"id=?",new String[]{String.valueOf(id)});
//        if (l==-1){
//            return false;
//        }else {
//            return true;
//        }
//    }

    public void GetDeleteCheckDelete(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        sqLiteDatabase.delete("CheckUpBook","id=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }
}
