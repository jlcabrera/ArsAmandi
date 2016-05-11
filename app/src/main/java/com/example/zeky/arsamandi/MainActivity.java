package com.example.zeky.arsamandi;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Model.Usuario;
import controller.UserController;

public class MainActivity extends AppCompatActivity {

    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button initSession = (Button)findViewById(R.id.bIniciarSesion);
        if(initSession != null) {
            initSession.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iniciarSesion();
                }
            });
        }

        Button register = (Button) findViewById(R.id.bRegistro);
        if(register != null){
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Intent para registrar el usuario
                    Intent i = new Intent(v.getContext(), Registro.class);
                    startActivity(i);
                }
            });
        }
    }

    public void iniciarSesion(){
        UserController uc = new UserController();
        this.user = uc.loadUser(((EditText)findViewById(R.id.etUsuario)).getText().toString());
        if(this.user == null){
            Toast.makeText(this,"El usuario indicado no existe", Toast.LENGTH_LONG).show();
        }else if(this.user.getPass().equals(((EditText)findViewById(R.id.etPassword)).getText().toString())){
            //nuevo intent
            Intent i = new Intent(this, ActividadPrincipal.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "La contraseña es errónea", Toast.LENGTH_LONG).show();
        }
    }


}