package com.example.zeky.arsamandi;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import Model.Mensaje;
import Model.Usuario;
import controller.UserController;

public class NewMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
        Toolbar tb = (Toolbar)findViewById(R.id.toolbarNewMessage);
        tb.setTitleTextColor(Color.BLACK);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_send, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuSend:
              sendMessage();
                break;
            case android.R.id.home:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void sendMessage(){
        Usuario user = (Usuario) getIntent().getExtras().get("usuario");
        Mensaje m = new Mensaje();
        String userDestino = ((EditText)findViewById(R.id.etUsuarioDestino)).getText().toString();
        String asunto = ((EditText)findViewById(R.id.etAsunto)).getText().toString();
        String mensaje = ((EditText) findViewById(R.id.etMensaje)).getText().toString();

        m.setLeido(false);
        m.setMatter(asunto);
        m.setReceivingUser(userDestino);
        m.setMessage(mensaje);
        m.setSendingUser(user.getUsuario());

        user.getMensajes().add(m);
        UserController uc = new UserController();
        uc.saveUser(user);

        setResult(Activity.RESULT_OK, getIntent().putExtra("usuario", user));

        //Envío de notificación
        generarNotificacion(user.getUsuario());
        finish();
    }

    public void generarNotificacion(String user){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_mail_outline_black_24dp)
                .setContentTitle("Nuevo Mensaje")
                .setContentText("Has recibido una nuevo mensaje de " + user + "!!!");

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());


    }

}