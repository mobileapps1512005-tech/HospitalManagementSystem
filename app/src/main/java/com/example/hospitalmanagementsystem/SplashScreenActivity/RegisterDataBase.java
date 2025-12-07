package com.example.hospitalmanagementsystem.SplashScreenActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class RegisterDataBase extends SQLiteOpenHelper {
public static final int VERSION=1;
public static final String CreateDataBaseName="RegisterDB";
    public RegisterDataBase(Context context) {
        super(context,CreateDataBaseName,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table Register(id integer primary key autoincrement,name text,email text,password text,gender text,phone text,role text)";
        String Query1 = "INSERT INTO Register(name,email,password,gender,phone,role) VALUES('Admin','admin@gmail.com','admin1515','male','01','admin')";
        db.execSQL(Query);
        db.execSQL(Query1);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("drop table if exists Register");
    }

    public boolean RegisterInsertData(String name,String email,String password,String gender,String phone,String role){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("password",password);
        contentValues.put("gender",gender);
        contentValues.put("phone",phone);
        contentValues.put("role",role);
      long l = sqLiteDatabase.insert("Register",null,contentValues);
       if (l>0) {
           return true;
       }else {
           return false;
       }
    }

    public String Login(String email,String password){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select role from Register where email='"+email+"' and password='"+password+"'",null);
        if (cursor.moveToFirst()){
            String role = cursor.getString(0);
            return role;
        }
        return "Invalid";
    }

    public boolean UserDetailsAlreadyExists(String email,String phone){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Register where email='"+email+"' or phone='"+phone+"'",null);
        if (cursor.moveToFirst()){
            return true;
        }else {
            return false;
        }
    }
    
    public boolean ForgetPassword(String email,String password) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select email from Register where email=?", new String[]{email});
        if (!cursor.moveToFirst()) {
            cursor.close();
            return false;
        }else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("password", password);
            long l = sqLiteDatabase.update("Register", contentValues, "email=?", new String[]{email});
            return l>0;
        }
    }
}
