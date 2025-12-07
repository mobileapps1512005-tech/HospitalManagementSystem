package com.example.hospitalmanagementsystem.MedicineReturnsPolicy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class MedicineReturnRejectDataBase extends SQLiteOpenHelper {
public static final int VERSION=1;
public static final String CreateDataBase="MedicineReturnRejectDB";
    public MedicineReturnRejectDataBase(Context context) {
        super(context,CreateDataBase,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table MedicineReturnReject(id integer primary key autoincrement,name text,condition text,phone text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists MedicineReturnReject");
    }
    public boolean InsertDataMedicineReject(String name,String condition,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("condition",condition);
        contentValues.put("phone",phone);
        long l = sqLiteDatabase.insert("MedicineReturnReject",null,contentValues);
        if (l>0){
            return true;
        }else {
            return false;
        }
    }
    public void GetDeleteMedicineReturnReject(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        sqLiteDatabase.delete("MedicineReturnReject","id=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }
    public Cursor GetAllRejectMedicine(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from MedicineReturnReject",null);
        return cursor;
    }
}
