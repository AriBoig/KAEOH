package com.example.arist.kaeoh;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by arist on 06/02/2018.
 */

public class AccueilFragment extends android.support.v4.app.Fragment{
    public AccueilFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_accueil,container,false);

    }
    public void onAttach(Context context) {
        super.onAttach(context);
        ((Activity)context).setTitle("Application KAEOH");
    }
}
