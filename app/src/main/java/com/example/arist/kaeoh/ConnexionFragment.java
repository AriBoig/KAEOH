package com.example.arist.kaeoh;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by arist on 07/02/2018.
 */

public class ConnexionFragment extends Fragment {

   private Session session;
    public ConnexionFragment() {

    }
    private static String[] userEmail;
    private static String[] userPassword;
    private static String[] userName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_connexion,container,false);
        Button button = (Button) v.findViewById(R.id.buttonConnexion);

        session = new Session(getContext());

        if (session.getusername() != null){
            Toast.makeText(getActivity().getApplicationContext(),"Vous êtes déjà connecté sous le nom " + session.getusername(),Toast.LENGTH_SHORT).show();
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(KAEOHService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        KAEOHService api = retrofit.create(KAEOHService.class);

        Call<List<User>> call = api.getUser();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> user = response.body();

                userEmail = new String[user.size()];
                userPassword = new String[user.size()];
                userName = new String[user.size()];
                for (int i = 0; i < user.size(); i++) {
                    userEmail[i] = user.get(i).getEmail();
                    userPassword[i] = user.get(i).getPassword();
                    userName[i] = user.get(i).getName();
                }
                
            }
            
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText emailText = (EditText)getActivity().findViewById(R.id.editTextAdress);
                EditText pswdText = (EditText)getActivity().findViewById(R.id.editTextPassword);
                String email = emailText.getText().toString();
                String pswd = pswdText.getText().toString();
                if(compare(email,userEmail)&& compare(pswd,userPassword)){
                    Toast.makeText(getActivity().getApplicationContext(),"Connexion réussie",Toast.LENGTH_SHORT).show();
                    session.setusername(String.valueOf(recupName(email,userEmail,userName)));
                    getFragmentManager().beginTransaction()
                            .replace(R.id.content_main, new CompteFragment())
                            .commit();
                }else{
                    Toast.makeText(getActivity().getApplicationContext(),"Impossible de se connecter. Email ou mot de passe incorrect",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((Activity)context).setTitle("Connexion");
    }

    private static final String TAG = "MyActivity";
    private boolean compare(String compare,String list[]){
        for (int i = 0; i < list.length; i++) {
            if(compare.equals(list[i])){
                return true;
            }
        }
        return false;
    }

    private String recupName(String compare, String list1[], String list2[]){
        for (int i = 0; i < list1.length; i++) {
            if(compare.equals(list1[i])){
                return list2[i];
            }
        }
        return "no name";
    }

}
