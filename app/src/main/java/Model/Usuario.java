package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable{

    //Atributos del usuario
    private String usuario;
    private String pass;
    private String grupo;
    private ArrayList<Mensaje> mensajes;

    public Usuario(){

    }

    public Usuario(String name, String password, String grupo, ArrayList<Mensaje> mensajes){
        this.usuario = name;
        this.pass = password;
        this.grupo = grupo;
        this.mensajes = mensajes;
    }

    //Metodos getter y setter para tratar los datos del usuario
    public String getUsuario(){
        return this.usuario;
    }

    public void setUsuario(String userName){
        this.usuario = userName;
    }

    public String getPass(){
        return this.pass;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public String getGrupo(){
        return this.grupo;
    }

    public void setGrupo(String grupo){
        this.grupo = grupo;
    }

    public ArrayList<Mensaje> getMensajes(){
        return this.mensajes;
    }

    public void setMensajes(ArrayList<Mensaje> mensajes){
        this.mensajes = mensajes;
    }
}
