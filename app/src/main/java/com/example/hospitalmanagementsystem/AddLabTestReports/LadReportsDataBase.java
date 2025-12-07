package com.example.hospitalmanagementsystem.AddLabTestReports;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class LadReportsDataBase extends SQLiteOpenHelper {
public static final int VERSION=1;
public static final String CreateDataBaseName="LabReportsDB";

    public LadReportsDataBase(Context context) {
        super(context,CreateDataBaseName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query = "create table LabReport(id integer primary key autoincrement,name text,part text,cost text,phone text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          db.execSQL("drop table if exists LabReport");
    }
    public boolean InsertLadData(String name,String part,String cost,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("part",part);
        contentValues.put("cost",cost);
        contentValues.put("phone",phone);
        long l = sqLiteDatabase.insert("LabReport",null,contentValues);
        if (l>0){
            return true;
        }else {
            return false;
        }
    }

    public boolean UpdateLadData(int id,String name,String part,String cost,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("part",part);
        contentValues.put("cost",cost);
        contentValues.put("phone",phone);
        long l = sqLiteDatabase.update("LabReport",contentValues,"id=?",new String[]{String.valueOf(id)});
        if (l>0){
            return true;
        }else {
            return false;
        }
    }
    public Cursor GetAllDetailLab(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from LabReport",null);
        return cursor;
    }

    public void GetDeleteLabDetail(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete("LabReport","id=?",new String[]{String.valueOf(id)});
    }
}
