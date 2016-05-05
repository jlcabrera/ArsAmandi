package com.example.zeky.arsamandi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class ActividadPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbarPrincipal);
        setSupportActionBar(toolbar);
    }
}
