package com.example.hospitalmanagementsystem.DoctorManageTask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MedSuggestDataBase extends SQLiteOpenHelper {
    public static final int VERSION=1;
    public static final String DataBaseName="MedSuggestsDB";
    public MedSuggestDataBase(Context context) {
        super(context,DataBaseName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table MedSuggest(id integer primary key autoincrement,hospital text,doctor text,phone text,name text,treatment text,medicine text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists MedSuggest");
    }
    public boolean InsertDataMed(String hospital,String doctor,String phone,String name,String treatment,String medicine){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hospital",hospital);
        contentValues.put("doctor",doctor);
        contentValues.put("phone",phone);
        contentValues.put("name",name);
        contentValues.put("treatment",treatment);
        contentValues.put("medicine",medicine);
        long l = sqLiteDatabase.insert("MedSuggest",null,contentValues);
        if (l>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean UpdateDataMed(int id,String hospital,String doctor,String phone,String name,String treatment,String medicine){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hospital",hospital);
        contentValues.put("doctor",doctor);
        contentValues.put("phone",phone);
        contentValues.put("name",name);
        contentValues.put("treatment",treatment);
        contentValues.put("medicine",medicine);
        long l = sqLiteDatabase.update("MedSuggest",contentValues,"id=?",new String[]{String.valueOf(id)});
        if (l==-1){
            return false;
        }else {
            return true;
        }
    }
    public Cursor GetAllMedDetails(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from MedSuggest",null);
        return cursor;
    }
    public void GetDeleteMed(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete("MedSuggest","id=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }
}
