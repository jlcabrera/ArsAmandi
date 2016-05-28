package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.zeky.arsamandi.DetalleMensaje;
import com.example.zeky.arsamandi.NewMessage;
import com.example.zeky.arsamandi.R;

import java.util.ArrayList;

import Model.Mensaje;
import Model.Usuario;
import controller.UserController;


public class MensajesFragment extends Fragment{

    private TabHost th;
    private ArrayList<Mensaje> mensajesUsuario;
    private ArrayList<Mensaje> mensajesLeidos;
    private ArrayList<Mensaje> mensajesRecibidos;
    private ListView lvLeidos;
    private ListView lvRecibidos;
    private FloatingActionButton fab;
    private View vista;


    public MensajesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.vista = inflater.inflate(R.layout.fragment_mensajes, container, false);
        this.th = (TabHost) vista.findViewById(R.id.tabHost);
        rellenarTabs();
        onResume();
        return vista;
    }

    @Override
    public void onResume() {
        iniciarComponentes();

        System.out.println("payaso");
        super.onResume();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == getActivity().RESULT_OK){
            this.getArguments().putAll(data.getExtras());
            onResume();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void iniciarComponentes(){

        Usuario u = (Usuario) getArguments().get("usuario");
        this.mensajesUsuario = u.getMensajes();
        clasificarMensajes();
        this.lvLeidos = (ListView) vista.findViewById(R.id.lvLeidos);
        this.lvRecibidos = (ListView) vista.findViewById(R.id.lvRecibidos);
        this.lvLeidos.setAdapter(new ArrayAdapter<>(vista.getContext(), android.R.layout.simple_list_item_1, obtenerAsuntosLeidos()));
        this.lvLeidos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mostrarMensajeLeido(mensajesLeidos.get(position));
            }
        });
        this.lvRecibidos.setAdapter(new ArrayAdapter<>(vista.getContext(), android.R.layout.simple_list_item_1, obtenerAsuntosRecibidos()));
        this.lvRecibidos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mostrarMensajeRecibido(mensajesRecibidos.get(position));
            }
        });
        this.fab = (FloatingActionButton) vista.findViewById(R.id.fbMessage);
        this.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), NewMessage.class);
                i.putExtras(getArguments());
                startActivityForResult(i, 1);
                Toast.makeText(v.getContext(), "Se inicia la vista para redactar un mensaje", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void rellenarTabs(){
        this.th.setup();
        TabHost.TabSpec spec = this.th.newTabSpec("Mensjes Recibidos");
        spec.setContent(R.id.linearLayout);
        spec.setIndicator("Mensajes Recibidos");
        this.th.addTab(spec);

        spec = this.th.newTabSpec("Mensajes Leídos");
        spec.setContent(R.id.linearLayout2);
        spec.setIndicator("Mensajes Leídos");
        this.th.addTab(spec);

        this.th.setCurrentTab(0);
    }

    public void clasificarMensajes(){
        this.mensajesRecibidos = new ArrayList<Mensaje>();
        this.mensajesLeidos = new ArrayList<Mensaje>();
        for(Mensaje m : this.mensajesUsuario){
            if(m.isLeido()){
                this.mensajesLeidos.add(m);
            }else{
                this.mensajesRecibidos.add(m);
            }
        }
    }

    public ArrayList<String> obtenerAsuntosLeidos(){
        ArrayList<String> asuntos = new ArrayList<String>();
        for(Mensaje m : this.mensajesLeidos){
            asuntos.add(m.getMatter());
        }
        return asuntos;
    }

    public ArrayList<String> obtenerAsuntosRecibidos(){
        ArrayList<String> asuntos = new ArrayList<String>();
        for(Mensaje m : this.mensajesRecibidos){
            asuntos.add(m.getMatter());
        }
        return asuntos;
    }

    //Metodo para mostrar el mensaje leido

    public void mostrarMensajeLeido(Mensaje message){
        Intent i = new Intent(getContext(), DetalleMensaje.class);
        i.putExtra("mensaje", message);
        startActivity(i);
    }

    //Metodo para mostrar el mensaje recibido y marcarlo como leido
    public void mostrarMensajeRecibido(Mensaje message) {
        this.mensajesUsuario.remove(message);
        Intent i = new Intent(getContext(), DetalleMensaje.class);
        i.putExtra("mensaje", message);
        startActivity(i);
        message.setLeido(true);
        this.mensajesUsuario.add(message);
        UserController controller = new UserController();
        Usuario u = (Usuario) getArguments().get("usuario");
        u.setMensajes(this.mensajesUsuario);
        controller.saveUser(u);

    }
}
