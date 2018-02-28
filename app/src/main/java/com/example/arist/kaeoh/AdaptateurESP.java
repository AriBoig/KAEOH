package com.example.arist.kaeoh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by arist on 28/02/2018.
 */

public class AdaptateurESP extends ArrayAdapter<ESP> {

    public AdaptateurESP(Context context, List<ESP> esp) {
        super(context, 0, esp);
    }
    private class ESPViewHolder{
        public TextView name;
        public TextView value;
        public TextView name_courant;
        public TextView unit;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.esp_liste,parent, false);
        }
        ESPViewHolder viewHolder = (ESPViewHolder) convertView.getTag();

        if(viewHolder == null){
            viewHolder = new ESPViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name_esp);
            viewHolder.value = (TextView) convertView.findViewById(R.id.value_esp);
            viewHolder.name_courant = (TextView) convertView.findViewById(R.id.esp_courant);
            viewHolder.unit = (TextView) convertView.findViewById(R.id.unit_esp);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Prods> prods
        ESP esp = getItem(position);

        //Remplissage de la vue
        viewHolder.name.setText(esp.getName());
        viewHolder.value.setText(esp.getValue());
        viewHolder.name_courant.setText(esp.getName_courant());
        viewHolder.unit.setText(esp.getUnit());
        return convertView;
    }
}
