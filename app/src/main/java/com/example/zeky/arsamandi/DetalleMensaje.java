package com.example.zeky.arsamandi;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import Model.Mensaje;

public class DetalleMensaje extends AppCompatActivity {

    private Mensaje mensaje = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mensaje);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarDetalle);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mensaje = (Mensaje)getIntent().getExtras().get("mensaje");
        ((TextView) findViewById(R.id.tvDetalleRemitente)).setText(mensaje.getSendingUser());
        ((TextView) findViewById(R.id.tvDetalleAsunto)).setText(mensaje.getMatter());
        ((TextView) findViewById(R.id.tvDetalleMensaje)).setText(mensaje.getMessage());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return true;
    }
}
