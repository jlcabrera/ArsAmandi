package Model;

import java.io.Serializable;

public class Usuario implements Serializable{

    //Atributos del usuario
    private String usuario;
    private String pass;

    public Usuario(){

    }

    public Usuario(String name, String password){
        this.usuario = name;
        this.pass = password;
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
}
