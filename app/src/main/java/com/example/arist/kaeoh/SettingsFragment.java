package com.example.arist.kaeoh;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by arist on 07/02/2018.
 */

public class SettingsFragment extends Fragment {
    public SettingsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        setHasOptionsMenu(true);
        Button button = (Button) v.findViewById(R.id.button_settings);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((Activity)context).setTitle("Settings");
    }

    public static SettingsFragment newInstance(){
        return new SettingsFragment();
    }
}
