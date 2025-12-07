package com.example.hospitalmanagementsystem.NurseManageTask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class NurseDataBase extends SQLiteOpenHelper {
 public static final int VERSION=1;
 public static final String CreateDataBase="Nurse.DB";

    public NurseDataBase(Context context) {
        super(context,CreateDataBase,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String  Query = "create table Nurse(id integer primary key autoincrement,Name text,Email text,Qualification text,Experience text,Gender text,Location text,Phone text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Nurse");
    }
    public boolean InsertNurseData(String name,String email,String qualification,String experience,String gender,String location,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("qualification",qualification);
        contentValues.put("experience",experience);
        contentValues.put("gender",gender);
        contentValues.put("location",location);
        contentValues.put("phone",phone);
    long l = sqLiteDatabase.insert("Nurse",null,contentValues);
       if (l>0){
         return true;
        }else {
           return false;
       }
    }
    public Cursor GetAllNurseData(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Nurse",null);
        return cursor;
    }

    public boolean UpdateNurseData(int id,String name,String email,String qualification,String experience,String gender,String location,String  phone) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("qualification", qualification);
        contentValues.put("experience", experience);
        contentValues.put("gender", gender);
        contentValues.put("location", location);
        contentValues.put("phone", phone);
        long l = sqLiteDatabase.update("Nurse", contentValues, "id=?", new String[]{String.valueOf(id)});
        if (l == -1) {
            return false;
        } else {
            return true;
        }
    }
    public void GetDeleteNurseDetails(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        sqLiteDatabase.delete("Nurse","id=?",new String[]{String.valueOf(id)});
    }
}
