package com.example.hospitalmanagementsystem.AmbulanceManageTask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class AmbulanceDataBase extends SQLiteOpenHelper {
    public static final int VERSION=1;
    public static final String CreateDataBase="Ambulances.DB";

    public AmbulanceDataBase(@Nullable Context context) {
        super(context,CreateDataBase,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String  Query="create table Ambulance(id integer primary key autoincrement,Name text,Email text,Experience text,License text,DriverNo text," +
                "VehicleNo text,HospitalName text,HospitalNo text,BaseFare text,PerKmCost text,EmergencyCost text,WithDoctor text," +
                "WithoutDoctor text,WithAc text,WithoutAc text,AmbulanceComboKit text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Ambulance");
    }
    public boolean SetInsertAmbulanceData(String name,String email,String experience,String License,String DriverNo,String VehicleNo,String HospitalName,
                                          String HospitalNo,String BaseFare,String PerKmCost,String EmergencyCost,String WithDoctor,String WithoutDoctor,String WithAc,
                                          String WithOutAc,String AmbulanceComboKit){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("experience",experience);
        contentValues.put("License",License);
        contentValues.put("DriverNo",DriverNo);
        contentValues.put("VehicleNo",VehicleNo);
        contentValues.put("HospitalName",HospitalName);
        contentValues.put("HospitalNo",HospitalNo);
        contentValues.put("BaseFare",BaseFare);
        contentValues.put("PerKmCost",PerKmCost);
        contentValues.put("EmergencyCost",EmergencyCost);
        contentValues.put("WithDoctor",WithDoctor);
        contentValues.put("WithoutDoctor",WithoutDoctor);
        contentValues.put("WithAc",WithAc);
        contentValues.put("WithOutAc",WithOutAc);
        contentValues.put("AmbulanceComboKit",AmbulanceComboKit);
      long l = sqLiteDatabase.insert("Ambulance",null,contentValues);
      if (l>0){
        return true;
       }else {
          return false;
       }
    }

    public boolean SetupdateAmbulanceData(int id,String name,String email,String experience,String License,String DriverNo,String VehicleNo,String HospitalName,
                                          String HospitalNo,String BaseFare,String PerKmCost,String EmergencyCost,String WithDoctor,String WithoutDoctor,String WithAc,
                                          String WithOutAc,String AmbulanceComboKit){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("experience",experience);
        contentValues.put("License",License);
        contentValues.put("DriverNo",DriverNo);
        contentValues.put("VehicleNo",VehicleNo);
        contentValues.put("HospitalName",HospitalName);
        contentValues.put("HospitalNo",HospitalNo);
        contentValues.put("BaseFare",BaseFare);
        contentValues.put("PerKmCost",PerKmCost);
        contentValues.put("EmergencyCost",EmergencyCost);
        contentValues.put("WithDoctor",WithDoctor);
        contentValues.put("WithoutDoctor",WithoutDoctor);
        contentValues.put("WithAc",WithAc);
        contentValues.put("WithOutAc",WithOutAc);
        contentValues.put("AmbulanceComboKit",AmbulanceComboKit);
        long l = sqLiteDatabase.update("Ambulance",contentValues,"id=?",new String[]{String.valueOf(id)});
        if (l==-1){
            return false;
        }else {
            return true;
        }
    }
    public Cursor GetAllAmbulanceDetail(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Ambulance",null);
        return cursor;
    }
    public void GetDeleteAmbulanceDetails(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete("Ambulance","id=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }
}
