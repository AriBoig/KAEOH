package com.example.arist.kaeoh;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by arist on 23/11/2017.
 */

public class MainFragment extends Fragment {
    public MainFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }
    public void onAttach(Context context) {
        super.onAttach(context);
        ((Activity)context).setTitle("Application KAEOH");
    }
}
