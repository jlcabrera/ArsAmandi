package com.example.zeky.arsamandi;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import Model.Usuario;
import controller.UserController;

public class Registro extends AppCompatActivity {

    private EditText userField;
    private EditText passField;
    private Spinner group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);

        userField = (EditText)findViewById(R.id.editText);
        passField = (EditText)findViewById(R.id.editText2);
        group = (Spinner)findViewById(R.id.spinner);
        setDataSpinner();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if(fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(regiserUser()) {
                        Toast.makeText(view.getContext(), "Te has registrado en la aplicación", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            });
        }
    }

    private boolean regiserUser(){
        if(checkFields()){
            String userName = this.userField.getText().toString();
            String userPass = this.passField.getText().toString();
            String groupName = group.getSelectedItem().toString();

            UserController uc = new UserController();
            if(uc.userExist(userName)) {
                uc.saveUser(new Usuario(userName, userPass, groupName));
            }else{
                Toast.makeText(this, "El nombre de usuario ya está en uso", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }

    private void setDataSpinner(){
        String[] groupName = {"Soltero", "Ama de casa", "Casado","Pensionista"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, groupName);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        group.setAdapter(spinnerAdapter);

    }

    private boolean checkFields() {
        boolean valid = true;
        if (passField.getText().toString().length() == 0) {
            passField.setError("Este campo es requerido");
            passField.requestFocus();
            valid = false;
        }

        if (userField.getText().toString().length() == 0) {
            userField.setError("Este campo es requerido");
            userField.requestFocus();
            valid = false;
        }

        return valid;
    }
}
