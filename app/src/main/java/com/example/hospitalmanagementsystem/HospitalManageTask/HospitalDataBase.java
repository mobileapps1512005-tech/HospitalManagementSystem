package com.example.hospitalmanagementsystem.HospitalManageTask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class HospitalDataBase extends SQLiteOpenHelper {
    public static final int VERSION=1;
    public static final String DatabaseName="Hospital.DB";
    public HospitalDataBase(@Nullable Context context) {
        super(context,DatabaseName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="Create Table Hospital (id integer primary key autoincrement,Name text,Established text,Email text,Location,Phone text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         db.execSQL("drop table if exists Hospital");
    }
    public boolean InsertHospitalData(String name,String established,String email,String location,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("established",established);
        contentValues.put("email",email);
        contentValues.put("location",location);
        contentValues.put("phone",phone);
        long l = sqLiteDatabase.insert("Hospital",null,contentValues);
        if (l>0){
            return true;
        }else {
            return false;
        }
    }
    public Cursor GetAllHospitalData(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Hospital",null);
        return cursor;
    }
    public boolean UpdateGetAllDetails(int id,String name,String established,String email,String location,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("established",established);
        contentValues.put("email",email);
        contentValues.put("location",location);
        contentValues.put("phone",phone);
        long up = sqLiteDatabase.update("Hospital",contentValues,"id=?",new String[]{String.valueOf(id)});
        if (up==-1){
            return false;
        }else {
            return true;
        }
    }
    public void GetDeleteHospitalDetails(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete("Hospital","id=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }
}
