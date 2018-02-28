package com.example.arist.kaeoh;

import android.telecom.Call;

import java.util.List;

import retrofit2.http.GET;


/**
 * Created by arist on 21/11/2017.
 */

public interface KAEOHService{
    public static final String BASE_URL = "http://kaeoh.gearhostpreview.com/";
    @GET("rasp.php")
    retrofit2.Call<List<Raspberry>> getRasp();

    @GET("users.php")
    retrofit2.Call<List<User>> getUser();

    @GET("esps.php")
    retrofit2.Call<List<ESP>> getEsps();
}
