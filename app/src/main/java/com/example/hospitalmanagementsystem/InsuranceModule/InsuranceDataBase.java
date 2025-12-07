package com.example.hospitalmanagementsystem.InsuranceModule;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class InsuranceDataBase extends SQLiteOpenHelper {
public static final int VERSION=2;
public static final String CreateDataBaseName="Insurance.DB";
    public InsuranceDataBase(@Nullable Context context) {
        super(context,CreateDataBaseName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table Insurance(id integer primary key autoincrement,name text,dob text,gender text,phone text,email text,aadhar text,policyNumber text,selectCompany text,selectHospital text,date text,time text,nominee text,hospital text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists Insurance");
    }
    public boolean InsertInsuranceDetails(String name,String dob,String gender,String phone,String email,String aadhar,String policyNumber,String selectCompany,String selectHospital,String date,String time,String nominee,String hospital){
    SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("dob",dob);
        contentValues.put("gender",gender);
        contentValues.put("phone",phone);
        contentValues.put("email",email);
        contentValues.put("aadhar",aadhar);
        contentValues.put("policyNumber",policyNumber);
        contentValues.put("selectCompany",selectCompany);
        contentValues.put("selectHospital",selectHospital);
        contentValues.put("date",date);
        contentValues.put("time",time);
        contentValues.put("nominee",nominee);
        contentValues.put("hospital",hospital);
      long l = sqLiteDatabase.insert("Insurance",null,contentValues);
      if (l>0){
          return true;
      }else {
          return false;
       }
    }
    public Cursor GetAllInsuranceDetails(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Insurance",null);
        return cursor;
    }
    public boolean UpdateInsuranceDetails(int id,String name,String dob,String gender,String phone,String email,String aadhar,String policyNumber,String selectCompany,String selectHospital,String date,String time,String nominee,String hospital){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("dob",dob);
        contentValues.put("gender",gender);
        contentValues.put("phone",phone);
        contentValues.put("email",email);
        contentValues.put("aadhar",aadhar);
        contentValues.put("policyNumber",policyNumber);
        contentValues.put("selectCompany",selectCompany);
        contentValues.put("selectHospital",selectHospital);
        contentValues.put("date",date);
        contentValues.put("time",time);
        contentValues.put("nominee",nominee);
        contentValues.put("hospital",hospital);
        long l = sqLiteDatabase.update("Insurance",contentValues,"id=?",new String[]{String.valueOf(id)});
        if (l==-1){
            return false;
        }else {
            return true;
        }
    }

}
