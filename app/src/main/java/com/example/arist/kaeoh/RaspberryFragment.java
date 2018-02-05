package com.example.arist.kaeoh;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by arist on 21/11/2017.
 */

public class RaspberryFragment extends Fragment{

    ListView mListView;
    public RaspberryFragment(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_raspberry, container, false);

        mListView = v.findViewById(R.id.raspberryListe);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(KAEOHService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        KAEOHService api = retrofit.create(KAEOHService.class);

        Call<List<Raspberry>> call = api.getRasp();

        call.enqueue(new Callback<List<Raspberry>>() {
            @Override
            public void onResponse(Call<List<Raspberry>> call, Response<List<Raspberry>> response) {
                List<Raspberry> raspberry = response.body();

                AdaptateurRaspberry adapter = new AdaptateurRaspberry(getContext(),raspberry);
                mListView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Raspberry>> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        //BaseDeDonnees obj = new BaseDeDonnees(getContext(),"listeRaspberry.db",null,25);
        //List<Raspberry> raspberry = obj.createRaspberry();

        return v;
    }
    public void onAttach(Context context){
        super.onAttach(context);
        ((Activity)context).setTitle("Liste de Raspberry");
    }
}
