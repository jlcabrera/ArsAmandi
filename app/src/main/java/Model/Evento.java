package Model;

/**
 * Created by Zeky on 11/5/16.
 */
public class Evento {

    //Atributos de la clase
    private String name;
    private String groupDestiny;
    private int price;
    private String location;

    public Evento(){
        this.name = "Evento de ejemplo";
        this.groupDestiny = "grupo de ejemplo";
        this.price = 0;
        this.location = "lugar del evento";
    }

    public Evento(String name, String group, int price, String location){
        this.name = name;
        this.groupDestiny = group;
        this.price = price;
        this.location = location;
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

    public int getPrice(){
        return this.price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public String getLocation(){
        return this.location;
    }

    public void setLocation(String location){
        this.location = location;
    }

}
