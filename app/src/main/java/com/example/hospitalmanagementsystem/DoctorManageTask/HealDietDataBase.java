package com.example.hospitalmanagementsystem.DoctorManageTask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class HealDietDataBase extends SQLiteOpenHelper {
    public static final int VERSION=1;
    public static final String DataBaseName="Heal.DB";
    public HealDietDataBase(Context context) {
        super(context,DataBaseName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table Heal(id integer primary key autoincrement,name text,age text,morning text,lunch text,dinner text,doctor text,phone text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("drop table if exists Heal");
    }
    public boolean InsertDataHeal(String name,String age,String morning,String lunch,String dinner,String doctor,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("age",age);
        contentValues.put("morning",morning);
        contentValues.put("lunch",lunch);
        contentValues.put("dinner",dinner);
        contentValues.put("doctor",doctor);
        contentValues.put("phone",phone);
      long l = sqLiteDatabase.insert("Heal",null,contentValues);
       if (l>0){
           return true;
       }else {
           return false;
       }
    }
    public boolean UpdateDataHeal(int id,String name,String age,String morning,String lunch,String dinner,String doctor,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("age",age);
        contentValues.put("morning",morning);
        contentValues.put("lunch",lunch);
        contentValues.put("dinner",dinner);
        contentValues.put("doctor",doctor);
        contentValues.put("phone",phone);
        long l = sqLiteDatabase.update("Heal",contentValues,"id=?",new String[]{String.valueOf(id)});
        if (l==-1){
            return false;
        }else {
            return true;
        }
    }
   public Cursor GetAllHealDetails(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Heal",null);
        return cursor;
   }
   public void GetDeleteHealDiet(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete("Heal","id=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
   }
}
