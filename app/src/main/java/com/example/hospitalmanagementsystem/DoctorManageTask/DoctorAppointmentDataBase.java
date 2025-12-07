package com.example.hospitalmanagementsystem.DoctorManageTask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DoctorAppointmentDataBase extends SQLiteOpenHelper {
    public static final int VERSION=1;
    public static final String CreateDataBaseName="Appointment.DB";

    public DoctorAppointmentDataBase(Context context) {
        super(context,CreateDataBaseName,null,VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table Appointment(id integer primary key autoincrement,Name text,Email text,AvailableDay text,AvailableTime text,Phone text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Appointment");
    }
    public boolean InsertAppointmentData(String name,String email,String AvailableDay,String AvailableTime,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("AvailableDay",AvailableDay);
        contentValues.put("AvailableTime",AvailableTime);
        contentValues.put("phone",phone);
        long l = sqLiteDatabase.insert("Appointment",null,contentValues);
        if(l>0){
            return true;
        } else {
            return false;
        }
    }

    public Cursor GetAllAppointmentDetails(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Appointment",null);
        return cursor;
    }

    public void GetDeleteAppointmentDetails(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete("Appointment","id=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }

}
