package com.example.hospitalmanagementsystem.AddLabTestReports;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OwnerAddReportDataBase extends SQLiteOpenHelper {
    public static final int VERSION=1;
    public static final String CreateDataBaseName="LabReportAddDB";

    public OwnerAddReportDataBase(Context context) {
        super(context,CreateDataBaseName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query = "create table LabReportAdd(id integer primary key autoincrement,name text,phone text,condition text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists LabReportAdd");
    }
    public boolean OwnerInsertLabDataAdd(String name,String phone,String condition){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("phone",phone);
        contentValues.put("condition",condition);
        long l = sqLiteDatabase.insert("LabReportAdd",null,contentValues);
        if (l>0){
            return true;
        }else {
            return false;
        }
    }

    public Cursor GetAllDetailLabAdd(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from LabReportAdd",null);
        return cursor;
    }

    public void GetDeleteLabDetailAdd(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete("LabReportAdd","id=?",new String[]{String.valueOf(id)});
    }
}
