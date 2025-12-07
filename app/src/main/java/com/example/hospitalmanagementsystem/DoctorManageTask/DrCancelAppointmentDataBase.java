package com.example.hospitalmanagementsystem.DoctorManageTask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DrCancelAppointmentDataBase extends SQLiteOpenHelper {
    public static final int VERSION = 1;
    public static final String CreateDataBaseName = "DrCancelAppointment.DB";

    public DrCancelAppointmentDataBase(Context context) {
        super(context, CreateDataBaseName, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query = "create table DrCancelAppointment(id integer primary key autoincrement,Name text,Email text,AvailableDay text,AvailableTime text,Phone text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists DrCancelAppointment");
    }

    public boolean InsertDrCancelAppointmentData(String name, String email, String AvailableDay, String AvailableTime, String phone) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("AvailableDay", AvailableDay);
        contentValues.put("AvailableTime", AvailableTime);
        contentValues.put("phone", phone);
        long l = sqLiteDatabase.insert("DrCancelAppointment", null, contentValues);
        if (l > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Cursor GetAllCancelAppointmentDetails() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from DrCancelAppointment", null);
        return cursor;
    }

    public void GetDeleteCancelAppointmentDetails(int id) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        sqLiteDatabase.delete("DrCancelAppointment", "id=?", new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }
}

