package com.example.arist.kaeoh;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by arist on 28/02/2018.
 */

public class ESPFragment extends Fragment{

    ListView mListView;
    public ESPFragment(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_esp, container, false);

        mListView = v.findViewById(R.id.espListe);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(KAEOHService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        KAEOHService api = retrofit.create(KAEOHService.class);

        Call<List<ESP>> call = api.getEsps();

        call.enqueue(new Callback<List<ESP>>() {
            @Override
            public void onResponse(Call<List<ESP>> call, Response<List<ESP>> response) {
                List<ESP> esp = response.body();

                AdaptateurESP adapter = new AdaptateurESP(getContext(),esp);
                mListView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ESP>> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        //BaseDeDonnees obj = new BaseDeDonnees(getContext(),"listeRaspberry.db",null,25);
        //List<Raspberry> raspberry = obj.createRaspberry();

        return v;
    }
    public void onAttach(Context context){
        super.onAttach(context);
        ((Activity)context).setTitle("Liste de ESPS");
    }

}
