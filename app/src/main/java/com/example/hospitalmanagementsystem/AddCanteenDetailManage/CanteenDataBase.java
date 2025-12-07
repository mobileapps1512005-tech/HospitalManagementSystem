package com.example.hospitalmanagementsystem.AddCanteenDetailManage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;


public class CanteenDataBase extends SQLiteOpenHelper {
    public static final int VERSION=1;
    public static final String CreateDataBaseName="Canteen.DB";

    public CanteenDataBase(Context context) {
        super(context,CreateDataBaseName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query = "create table canteen(id integer primary key autoincrement,menu text,half text,halfPrice text,fullPlate text,fullPrice text,discount text,combo text,phone text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists canteeen");
    }
    public boolean InsertDataCanteen(String menu,String half,String halfPrice,String fullPlate,String fullPrice,String discount,String combo,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("menu",menu);
        contentValues.put("half",half);
        contentValues.put("halfPrice",halfPrice);
        contentValues.put("fullPlate",fullPlate);
        contentValues.put("fullPrice",fullPrice);
        contentValues.put("discount",discount);
        contentValues.put("combo",combo);
        contentValues.put("phone",phone);
     long l = sqLiteDatabase.insert("canteen",null,contentValues);
     if (l>0){
         return true;
      }else {
        return false;
        }
    }
    public boolean UpdateDataCanteen(int id,String menu,String half,String halfPrice,String fullPlate,String fullPrice,String discount,String combo,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("menu",menu);
        contentValues.put("half",half);
        contentValues.put("halfPrice",halfPrice);
        contentValues.put("fullPlate",fullPlate);
        contentValues.put("fullPrice",fullPrice);
        contentValues.put("discount",discount);
        contentValues.put("combo",combo);
        contentValues.put("phone",phone);
        long l = sqLiteDatabase.update("canteen",contentValues,"id=?",new String[]{String.valueOf(id)});
        if (l==-1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor GetAllCanteenData(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from canteen",null);
        return cursor;
    }
}
