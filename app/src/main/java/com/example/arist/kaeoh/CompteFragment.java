package com.example.arist.kaeoh;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by arist on 22/02/2018.
 */

public class CompteFragment extends android.support.v4.app.Fragment {

    private TextView text = null;
    private Session session;
    public CompteFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_compte,container,false);

        session = new Session(getContext());
        String name = session.getusername();

        text = v.findViewById(R.id.compte_name);
        text.setText(name);

        Button button = (Button) v.findViewById(R.id.button_disconnect);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                session.setusername(null);
                Toast.makeText(getActivity().getApplicationContext(),"Déconnexion réussie",Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction()
                        .replace(R.id.content_main, new AccueilFragment())
                        .commit();
            }
        });
        return v;
    }
    public void onAttach(Context context) {
        super.onAttach(context);
        ((Activity)context).setTitle("Compte");
    }
}
