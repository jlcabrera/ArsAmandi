package com.example.zeky.arsamandi;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ActividadPrincipal extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private DrawerLayout mDrawer;
    private ListView optionList;
    private String[] options = {"opcion1", "opcion2", "opcion3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbarPrincipal);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        this.optionList = (ListView)findViewById(R.id.optionItems);
        this.mDrawer = (DrawerLayout)findViewById(R.id.drawerLayout);

        this.optionList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options));
        this.optionList.setOnItemClickListener(this);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == android.R.id.home){
            if(this.mDrawer.isDrawerOpen(this.optionList)){
                this.mDrawer.closeDrawers();
            }else{
                this.mDrawer.openDrawer(this.optionList);
            }
        }
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "seleccionado" + this.options[position], Toast.LENGTH_SHORT).show();
        this.mDrawer.closeDrawers();
    }
}
