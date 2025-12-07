package com.example.hospitalmanagementsystem.PatientBillings;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class PatientBillingDataBase extends SQLiteOpenHelper {
public static final int VERSION=1;
public static final String CreateNameDataBase="BillingDB";
    public PatientBillingDataBase(Context context) {
        super(context,CreateNameDataBase,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table Billing(id integer primary key autoincrement,hospital text,name text,email text,phone text,typeBill text,cost text,typeDiscount text,date text,time text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Billing");
    }
    public boolean InsertBillingData(String hospital,String name,String email,String phone,String typeBill,String cost,String typeDiscount,String date,String time){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hospital",hospital);
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("phone",phone);
        contentValues.put("typeBill",typeBill);
        contentValues.put("cost",cost);
        contentValues.put("typeDiscount",typeDiscount);
        contentValues.put("date",date);
        contentValues.put("time",time);
        long l = sqLiteDatabase.insert("Billing",null,contentValues);
        if (l>0) {
            return true;
        }else {
            return false;
        }
    }
    public boolean UpdateBillingData(int id,String hospital,String name,String email,String phone,String typeBill,String cost,String typeDiscount,String date,String time) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hospital", hospital);
        contentValues.put("name", name);
        contentValues.put("email",email);
        contentValues.put("phone",phone);
        contentValues.put("typeBill",typeBill);
        contentValues.put("cost", cost);
        contentValues.put("typeDiscount",typeDiscount);
        contentValues.put("date", date);
        contentValues.put("time", time);
        long l = sqLiteDatabase.update("Billing", contentValues,"id=?",new String[]{String.valueOf(id)});
        if (l == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor GetBillingData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Billing",null);
        return cursor;
    }
}
