package com.example.hospitalmanagementsystem.MedicalReports;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MedicalReportsDataBase extends SQLiteOpenHelper {
    public static final int VERSION=1;
    public static final String CreateDataBaseName="Medicals.DB";

    public MedicalReportsDataBase(Context context) {
        super(context,CreateDataBaseName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table Medicals(id integer primary key autoincrement,name text,part text,date text,time text,condition text,describe text,phone text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Medicals");
    }

    public boolean InsertData(String name,String part,String date,String time,String condition,String describe,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("part",part);
        contentValues.put("date",date);
        contentValues.put("time",time);
        contentValues.put("condition",condition);
        contentValues.put("describe",describe);
        contentValues.put("phone",phone);
        long l = sqLiteDatabase.insert("Medicals",null,contentValues);
        if (l>0){
            return true;
        }else {
            return false;
        }
    }

    public Cursor AllGetDetails(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Medicals",null);
        return cursor;
    }

    public boolean UpdateMedicals(int id,String name,String part,String date,String time,String condition,String describe,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("part",part);
        contentValues.put("date",date);
        contentValues.put("time",time);
        contentValues.put("condition",condition);
        contentValues.put("describe",describe);
        contentValues.put("phone",phone);
        long l = sqLiteDatabase.update("Medicals",contentValues,"id=?",new String[]{String.valueOf(id)});
        if (l==-1){
            return false;
        }else {
            return true;
        }
    }

    public void GetDeleteMedicalReports(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        sqLiteDatabase.delete("Medicals","id=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }

}
