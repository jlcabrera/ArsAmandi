package Model;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Zeky on 11/5/16.
 */
public class Evento implements Serializable {

    //Atributos de la clase
    private String name;
    private String groupDestiny;

    private String location;
    private int recursoImagen;
    private String dia;
    private String hora;

    public Evento(){
        this.name = "Evento de ejemplo";
        this.groupDestiny = "grupo de ejemplo";

        this.location = "lugar del evento";
    }

    public Evento(String name, String group, String location, int recursoImagen, String dia, String hora){
        this.name = name;
        this.groupDestiny = group;

        this.location = location;
        this.recursoImagen = recursoImagen;
        this.dia = dia;
        this.hora = hora;
    }


    //metodos getter y setter
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getGroupDestiny(){
        return this.groupDestiny;
    }

    public void setGroupDestiny(String grupo){
        this.groupDestiny = grupo;
    }

    public String getLocation(){
        return this.location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public void setRecursoImagen(int imagen){
        this.recursoImagen = imagen;
    }

    public int getRecursoImagen(){
        return recursoImagen;
    }

    public String getDia(){
        return dia;
    }

    public void setDia(String dia){
        this.dia = dia;
    }

    public String getHora(){
        return this.hora;
    }

    public void setHora(String hora){
        this.hora = hora;
    }
}
