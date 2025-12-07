package com.example.hospitalmanagementsystem.AmbulanceManageTask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AmbulanceBookingDataBase extends SQLiteOpenHelper {
public static final String CreateDataName="AmbulanceBook.DB";
public static final int VERSION=1;

    public AmbulanceBookingDataBase(Context context) {
        super(context,CreateDataName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table AmbulanceBook(id integer primary key autoincrement,name text,email text,phone text,alterNumber text,location text,ambulance text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          db.execSQL("drop table if exists AmbulanceBook");
    }
    public boolean InsertData(String name,String email,String phone,String alterNumber,String location,String ambulance){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("phone",phone);
        contentValues.put("alterNumber",alterNumber);
        contentValues.put("location",location);
        contentValues.put("ambulance",ambulance);
       long l = sqLiteDatabase.insert("AmbulanceBook",null,contentValues);
       if (l>0){
           return true;
       }else {
           return false;
       }
    }
    public void GetDeleteAmbulanceBookDetails(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        sqLiteDatabase.delete("AmbulanceBook","id=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }
    public Cursor GetAllDetailsAmbulanceBook(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from AmbulanceBook",null);
        return cursor;
    }
}
