package Model;

import java.io.Serializable;

/**
 * Created by Zeky on 13/5/16.
 */
public class Mensaje implements Serializable{
    private String receivingUser;
    private String matter;
    private String message;
    private boolean leido;
    private String sendingUser;

    public Mensaje(){
        this.receivingUser = null;
        this.matter = null;
        this.message = null;
    }

    public Mensaje(String destinity, String matter, String message, boolean leido, String sendingUser ){
        this.receivingUser = destinity;
        this.matter = matter;
        this.message = message;
        this.leido = leido;
        this.sendingUser = sendingUser;
    }

    public String getReceivingUser(){
        return this.receivingUser;
    }

    public void setReceivingUser(String receivingUser){
        this.receivingUser = receivingUser;
    }

    public String getMatter(){
        return this.matter;
    }

    public void setMatter(String matter){
        this.matter = matter;
    }

    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public boolean isLeido(){
        return this.leido;
    }

    public void setLeido(boolean leido){
        this.leido = leido;
    }

    public String getSendingUser(){
        return this.sendingUser;
    }

    public void setSendingUser(String sendingUser){
        this.sendingUser = sendingUser;
    }
}
