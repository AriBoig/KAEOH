package com.example.arist.kaeoh;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by arist on 23/11/2017.
 */

public class AdaptateurRaspberry extends ArrayAdapter<Raspberry>{

    public AdaptateurRaspberry(Context context, List<Raspberry> raspberry) {
        super(context, 0, raspberry);
    }

    public View getView(int position, View convertView, ViewGroup parent){

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.raspberry_liste,parent, false);
        }
        RaspViewHolder viewHolder = (RaspViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new RaspViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.raspberry);
            viewHolder.ip= (TextView) convertView.findViewById(R.id.rasp_ip);

            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Prods> prods
        Raspberry raspberry = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.name.setText(raspberry.getName());
        viewHolder.ip.setText(raspberry.getIp());

        return convertView;
    }
    private class RaspViewHolder{
        public TextView name;
        public TextView ip;
    }

}
