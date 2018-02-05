package com.example.arist.kaeoh;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by arist on 16/01/2018.
 */

public class QueryResponse {
    @SerializedName("Error")
    public final String error;
    @SerializedName("ID")
    public final int id;
    @SerializedName("NAME")
    public final String name;
    @SerializedName("IP")
    public final String ip;

    public QueryResponse(List<Raspberry> Raspberry, int id, String name, String ip, String error) {
        this.error = error;
        this.id = id;
        this.name = name;
        this.ip = ip;
    }
}
