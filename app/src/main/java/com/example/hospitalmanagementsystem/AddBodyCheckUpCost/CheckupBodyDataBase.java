package com.example.hospitalmanagementsystem.AddBodyCheckUpCost;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class CheckupBodyDataBase extends SQLiteOpenHelper {
public static final int VERSION=1;
public static final String CreateDataBaseName="Checks.DB";

    public CheckupBodyDataBase(Context context) {
        super(context,CreateDataBaseName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table CheckUp(id integer primary key autoincrement,name text,part text,price text,discounts text,phone text)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         db.execSQL("drop table if exists CheckUp");
    }

    public boolean InsertData(String name,String part,String price,String discounts,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("part",part);
        contentValues.put("price",price);
        contentValues.put("discounts",discounts);
        contentValues.put("phone",phone);
      long l = sqLiteDatabase.insert("CheckUp",null,contentValues);
      if (l>0){
          return true;
      }else {
         return false;
       }
    }

    public Cursor AllGetDetails(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from CheckUp",null);
        return cursor;
    }

    public boolean UpdateData(int id,String name,String part,String price,String discounts,String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("part",part);
        contentValues.put("price",price);
        contentValues.put("discounts",discounts);
        contentValues.put("phone",phone);
        long l = sqLiteDatabase.update("CheckUp",contentValues,"id=?",new String[]{String.valueOf(id)});
        if (l==-1){
            return false;
        }else {
            return true;
        }
    }

    public void GetDeleteCheckDelete(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        sqLiteDatabase.delete("CheckUp","id=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }

}
