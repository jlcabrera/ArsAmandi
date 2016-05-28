package com.example.zeky.arsamandi;

import android.content.Intent;
import android.graphics.Color;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import Model.Usuario;
import fragments.MensajesFragment;
import fragments.MiPerfilFragment;
import fragments.ProximosEventos;


public class ActividadPrincipal extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private NavigationView navview;

    private Usuario user;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        Fragment f = new ProximosEventos();
        getSupportFragmentManager().beginTransaction().replace(R.id.contentFrame, f).setTransition(android.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
        this.user = (Usuario) getIntent().getExtras().get("usuario");
        this.mDrawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        this.navview = (NavigationView) findViewById(R.id.navview);
        View headerView = this.navview.inflateHeaderView(R.layout.header_navview);
        ImageView imagen = (ImageView) headerView.findViewById(R.id.imagenCabecera);
        imagen.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(imagen.getContext()).load(R.drawable.sevilla).into(imagen);
        ((TextView)headerView.findViewById(R.id.tvUserNameHeader)).setText(this.user.getUsuario());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.mDrawer.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null) {
            getIntent().putExtras(data);
            onResume();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarPrincipal);
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Próximos Eventos");
        this.navview.setCheckedItem(R.id.proximosEventos);

        getSupportActionBar().setHomeButtonEnabled(true);


        this.navview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                boolean fragmentTrasaction = false;
                Fragment f = null;

                switch (item.getItemId()) {
                    case R.id.proximosEventos:
                        f = new ProximosEventos();
                        f.setArguments(getIntent().getExtras());
                        fragmentTrasaction = true;
                        break;
                    case R.id.miPerfil:
                        f = new MiPerfilFragment();
                        f.setArguments(getIntent().getExtras());
                        fragmentTrasaction = true;
                        break;
                    case R.id.mensajes:
                        f = new MensajesFragment();
                        f.setArguments(getIntent().getExtras());
                        fragmentTrasaction = true;
                        break;
                    case R.id.salir:
                        finish();
                        break;
                }

                if (fragmentTrasaction) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.contentFrame, f).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
                    item.setChecked(true);
                    getSupportActionBar().setTitle(item.getTitle());
                }

                mDrawer.closeDrawers();

                return true;
            }
        });

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_18dp);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            Fragment f = new ProximosEventos();
            getSupportFragmentManager().beginTransaction().replace(R.id.contentFrame, f).setTransition(android.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
            getSupportActionBar().setTitle("Próximos Eventos");
            this.navview.setCheckedItem(R.id.proximosEventos);

        }
        return false;
    }
}
