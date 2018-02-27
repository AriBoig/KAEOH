package com.example.arist.kaeoh;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by arist on 22/02/2018.
 */

public class Session {
    private SharedPreferences prefs;

    public Session(Context cntx) {
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setusername(String username) {
        prefs.edit().putString("username", username).commit();
    }

    public void setIdUser(Integer id){
        prefs.edit().putInt("id",id).commit();
    }
    public int getIdUser(){
        Integer idUser = prefs.getInt("idUser",0);
        return idUser;
    }
    public String getusername() {
        String usename = prefs.getString("username",null);
        return usename;
    }
}
