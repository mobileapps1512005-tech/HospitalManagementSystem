package com.example.hospitalmanagementsystem.GrievanceActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class GrievanceDataBase extends SQLiteOpenHelper {
public static final int VERSION=1;
public static final String CreateDataBaseName="GrievanceDB";
    public GrievanceDataBase(Context context) {
        super(context,CreateDataBaseName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table Grievance(id integer primary key autoincrement,hospital text,name text,phone,staff text,grievance text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Grievance");
    }

    public boolean GrievanceInsertData(String hospital,String name,String phone,String staff,String grievance){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hospital",hospital);
        contentValues.put("name",name);
        contentValues.put("phone",phone);
        contentValues.put("staff",staff);
        contentValues.put("grievance",grievance);
        long l = sqLiteDatabase.insert("Grievance",null,contentValues);
        if (l>0){
            return true;
        }else {
            return false;
        }
    }

    public boolean GrievanceUpdateData(int id,String hospital,String name,String phone,String staff,String grievance) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hospital", hospital);
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("staff", staff);
        contentValues.put("grievance", grievance);
        long l = sqLiteDatabase.update("Grievance", contentValues,"id=?",new String[]{String.valueOf(id)});
        if (l==-1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor GetAllGrievance(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from grievance",null);
        return cursor;
    }

    public void GetDeleteGrievance(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        sqLiteDatabase.delete("Grievance","id=?",new String[]{String.valueOf(id)});
    }
}
