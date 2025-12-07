package com.example.hospitalmanagementsystem.AdminModule;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("Session",MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void HoldUserData(String email,String password){
        editor.putString("email",email);
        editor.putString("password",password);
        editor.apply();
    }

    public boolean CheckUserExists(){

        if (sharedPreferences.contains("email") || sharedPreferences.contains("password")){
            return true;
        }else {
            return false;
        }
    }

    public void LogOut(){
        editor.clear();
        editor.apply();
    }

}
