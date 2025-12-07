package com.example.hospitalmanagementsystem.AmbulanceManageTask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonUiContext;
import androidx.annotation.Nullable;

public class AmbulanceApprovalDataBase extends SQLiteOpenHelper {
public static final int VERSION=1;
public static final String CreateTableName="AmbulanceApproval.DB";

    public AmbulanceApprovalDataBase(Context context) {
        super(context,CreateTableName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table Approval(id integer primary key autoincrement,name text,email text,phone text,alterNumber text,location text,ambulance text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("drop table if exists Approval");
    }
    public boolean InsertDataApproval(String name,String email,String phone,String alterNumber,String location,String ambulance){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("phone",phone);
        contentValues.put("alterNumber",alterNumber);
        contentValues.put("location",location);
        contentValues.put("ambulance",ambulance);
        long l = sqLiteDatabase.insert("Approval",null,contentValues);
        if (l>0){
            return true;
        }else {
            return false;
        }
    }
    public Cursor GetAllDetailsAmbulanceBook(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Approval",null);
        return cursor;
    }

}
