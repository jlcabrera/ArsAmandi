package com.example.zeky.arsamandi;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import Model.Evento;

public class DetallesEventos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_eventos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        crearDatos();
    }

    public void crearDatos(){
        TextView tvNombre = (TextView)findViewById(R.id.tvNombreEvento);
        TextView tvGrupo = (TextView)findViewById((R.id.tvGrupoDestino));
        TextView tvFechaEvento = (TextView) findViewById(R.id.tvFechaDelEvento);
        TextView tvHora = (TextView) findViewById(R.id.tvHora);
        TextView tvPuntoEncuentro = (TextView) findViewById(R.id.tvPuntoDeEncuentro);

        Evento event = (Evento) getIntent().getExtras().get("evento");
        tvNombre.setText(event.getName());
        tvGrupo.setText(event.getGroupDestiny());
        tvFechaEvento.setText(event.getDia());
        tvHora.setText(event.getHora());
        tvPuntoEncuentro.setText(event.getLocation());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
