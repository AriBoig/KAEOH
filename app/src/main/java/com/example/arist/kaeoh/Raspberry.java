package com.example.arist.kaeoh;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by arist on 21/11/2017.
 */

public class Raspberry{
    private int id;
    private String name;
    private int user_id;
    private int tag_id;
    private String added;
    private String last_com;

    public Raspberry() {

    }

    public Raspberry(int id, String name, int user_id, int tag_id, String added, String last_com) {
        this.id = id;
        this.name = name;
        this.user_id = user_id;
        this.tag_id = tag_id;
        this.added = added;
        this.last_com = last_com;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
    }

    public String getLast_com() {
        return last_com;
    }

    public void setLast_com(String last_com) {
        this.last_com = last_com;
    }
}
