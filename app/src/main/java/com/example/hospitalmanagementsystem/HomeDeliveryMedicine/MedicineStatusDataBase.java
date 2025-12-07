package com.example.hospitalmanagementsystem.HomeDeliveryMedicine;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MedicineStatusDataBase extends SQLiteOpenHelper {
    public static final int VERSION=1;
    public static final String CreateDataBaseName="DeliveryStausDB";

    public MedicineStatusDataBase(Context context) {
        super(context,CreateDataBaseName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table DeliveryStatus(id integer primary key autoincrement,name text,email text,phone text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
           db.execSQL("drop table if exists DeliveryStatus");
    }
    public boolean InsertDeliveryStatus(String name,String email,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("phone",phone);
        long l = sqLiteDatabase.insert("DeliveryStatus",null,contentValues);
        if (l>0){
            return true;
        }else {
            return false;
        }
    }
    public Cursor GetAllDeliveryStatus(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from DeliveryStatus",null);
        return cursor;
    }
}
