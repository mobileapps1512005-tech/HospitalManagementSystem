package com.example.hospitalmanagementsystem.DoctorManageTask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DoctorDataBase extends SQLiteOpenHelper {
public static final int VERSION=1;
public static final String CreateDataBaseName="Doctor.DB";
    public DoctorDataBase(@Nullable Context context) {
        super(context,CreateDataBaseName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table Doctor(id integer primary key autoincrement,Name text,Email text,Qualification text,Experience text,Specialize text,AvailableDay text,AvailableTime text,Phone text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists Doctor");
    }
    public boolean InsertDoctorData(String name,String email,String qualification,String experience,String specialize,String AvailableDay,String AvailableTime,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("qualification",qualification);
        contentValues.put("experience",experience);
        contentValues.put("specialize",specialize);
        contentValues.put("AvailableDay",AvailableDay);
        contentValues.put("AvailableTime",AvailableTime);
        contentValues.put("phone",phone);
     long l = sqLiteDatabase.insert("Doctor",null,contentValues);
       if(l>0){
          return true;
       } else {
          return false;
       }
    }

    public Cursor GetAllDoctorDetails(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Doctor",null);
        return cursor;
    }

    public boolean UpdateDoctorDetails(int id,String name,String email,String qualification,String experience,String specialize,String AvailableDay,String AvailableTime,String phone){
       SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
       ContentValues contentValues = new ContentValues();
       contentValues.put("name",name);
       contentValues.put("email",email);
       contentValues.put("qualification",qualification);
       contentValues.put("experience",experience);
       contentValues.put("specialize",specialize);
       contentValues.put("AvailableDay",AvailableDay);
       contentValues.put("AvailableTime",AvailableTime);
       contentValues.put("phone",phone);
         long Up = sqLiteDatabase.update("Doctor",contentValues,"id=?",new String[]{String.valueOf(id)});
         if (Up==-1){
                return false;
         }else {
             return true;
         }
    }

   public void GetDeleteDoctorDetails(int id){
    SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
    sqLiteDatabase.delete("Doctor","id=?",new String[]{String.valueOf(id)});
    sqLiteDatabase.close();
   }


}