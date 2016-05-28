package controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zeky.arsamandi.R;

import java.util.ArrayList;

import Model.Evento;

/**
 * Created by Zeky on 28/5/16.
 */
public class MyAdapter extends BaseAdapter {

    private Context myContext;
    private ArrayList<Evento> eventos;


    public MyAdapter(Context c, ArrayList<Evento> eventos){
        this.myContext = c;
        this.eventos = eventos;
    }

    @Override
    public int getCount() {
        return eventos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.eventos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_item_grid, parent, false);
        }
        ImageView imagen = (ImageView)convertView.findViewById(R.id.imageEvento);
        imagen.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TextView tv = (TextView)convertView.findViewById(R.id.textoEvento);

        Glide.with(imagen.getContext()).load(this.eventos.get(position).getRecursoImagen()).into(imagen);
        tv.setText(this.eventos.get(position).getName());
        return convertView;
    }
}
