package fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zeky.arsamandi.R;

/**
 * Created by Zeky on 12/5/16.
 */
public class MiPerfilFragment extends Fragment {

    private TextView nombre;
    private TextView grupo;

    public MiPerfilFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_mi_perfil, container, false);
        this.nombre = (TextView)v.findViewById(R.id.tvUserName);
        this.grupo = (TextView)v.findViewById(R.id.tvGroupName);

        this.nombre.setText("Nombre de usuario: " + this.getArguments().getString("usuario"));
        this.grupo.setText("Perteneces al grupo: " + this.getArguments().getString("grupo"));
        return v;
    }


}
