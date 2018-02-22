package com.example.arist.kaeoh;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by arist on 22/02/2018.
 */

public class AboutFragment extends Fragment {
    private TextView text = null;

    public AboutFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_about, container, false);
        setHasOptionsMenu(true);
        String textAbout = "KAEOH is an application made by Timothé TOUDIC and Aristide BOISGONTIER. You can contact us on kaeoh@gmail.com";
        text = v.findViewById(R.id.text_about);
        text.setText(textAbout);
        return v;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        ((Activity)context).setTitle("About");
    }

    public static AboutFragment newInstance(){
        return new AboutFragment();
    }
}
