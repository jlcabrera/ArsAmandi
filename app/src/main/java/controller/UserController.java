package controller;

import android.os.Environment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import Model.Usuario;

/**
 * Created by Zeky on 30/4/16.
 */
public class UserController {

    private static final File JSON = new File(Environment.getExternalStorageDirectory() + "/usuarios.json");

    private Map<String, Usuario> users;
    private Gson gson;

    static{
        if(!JSON.exists()){
            try {
                JSON.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public UserController(){
        this.gson = new Gson();
        Type mapType = new TypeToken<Map<String, Usuario>>(){}.getType();
        BufferedReader jsonReader = null;
        try {
            jsonReader = new BufferedReader(new FileReader(JSON));
            this.users = this.gson.fromJson(jsonReader, mapType);

            if(this.users == null){
                this.users = new TreeMap<String, Usuario>();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally{
            if(jsonReader != null){
                try {
                    jsonReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Metodo para obtener el usuario
    public Usuario loadUser(String user){
        Usuario u = null;
        try {
            u = this.users.get(user);
        }catch(NullPointerException e){

        }
        return u;
    }

    //Metodo para guardar un usuario en el fichero
    public void saveUser(Usuario user){
        this.users.put(user.getUsuario(), user);
        saveFile();
    }

    //Metodo para guardar el mapa de usuarios en el fichero json
    private void saveFile(){
        BufferedWriter jsonWriter = null;
        try {
            jsonWriter = new BufferedWriter(new FileWriter(JSON));
            jsonWriter.write(this.gson.toJson(this.users));
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(jsonWriter != null){
                try {
                    jsonWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Metodo para comprobar si el usuario ya está registrado
    public boolean userExist(Usuario user){
        return this.users.get(user.getUsuario()) == null;
    }

    public boolean userExist(String key){
        return this.users.get(key) == null;
    }

}
