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

    public void setconnected(Boolean connect){
        prefs.edit().putBoolean("connected",connect).commit();
    }
    public boolean getconnected(){
        Boolean connect = prefs.getBoolean("connected",false);
        return connect;
    }
    public String getusername() {
        String usename = prefs.getString("username",null);
        return usename;
    }
}
