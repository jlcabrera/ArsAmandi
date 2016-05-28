package fragments;


import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.zeky.arsamandi.DetallesEventos;
import com.example.zeky.arsamandi.R;

import java.util.ArrayList;

import Model.Evento;
import controller.MyAdapter;

public class ProximosEventos extends Fragment {

    public ProximosEventos() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_proximos_eventos, container, false);
        GridView listaEventos = (GridView) v.findViewById(R.id.gridView);
        final ArrayList<Evento> eventos = crearEventos();
        listaEventos.setAdapter(new MyAdapter(v.getContext(), eventos));
        listaEventos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent i = new Intent(view.getContext(), DetallesEventos.class);
               i.putExtra("evento", eventos.get(position));
               startActivity(i);
            }
        });
        return v;
    }

    public ArrayList<Evento> crearEventos(){
        ArrayList<Evento> eventos = new ArrayList<>();
        eventos.add(new Evento("Cata de vino","solteros","Plaza de la Encarnación", R.drawable.cata, "18/06/2016", "21:30"));
        eventos.add(new Evento("Crucero por el río", "solteros","Torre del Oro",R.drawable.crucero_por_el_guadalquivir, "19/06/2016", "12:30"));
        eventos.add(new Evento("Casas Palacio", "solteros", "Puerta Jerez", R.drawable.casa_palacio, "25/06/2016", "12:00"));
        eventos.add(new Evento("Bécquer Parque Mª Luisa", "solteros", "Glorieta de Bécquer", R.drawable.glorieta,"04/06/2016", "12:00"));

        return eventos;
    }


}
