package com.example.arist.kaeoh;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by arist on 23/11/2017.
 */

public class AdaptateurRaspberry extends ArrayAdapter<Raspberry>{

    public AdaptateurRaspberry(Context context, List<Raspberry> raspberry) {
        super(context, 0, raspberry);
    }
    private class RaspViewHolder{
        public TextView name;
        public TextView added;
        public TextView last_com;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.raspberry_liste,parent, false);
        }
        RaspViewHolder viewHolder = (RaspViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new RaspViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.raspberry);
            viewHolder.added = (TextView) convertView.findViewById(R.id.rasp_date_ajout);
            viewHolder.last_com = (TextView) convertView.findViewById(R.id.rasp_last_com);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Prods> prods
        Raspberry raspberry = getItem(position);

        //Remplissage de la vue
        viewHolder.name.setText(raspberry.getName());
        viewHolder.added.setText(raspberry.getAdded());
        viewHolder.last_com.setText(raspberry.getLast_com());
        return convertView;
    }
}
