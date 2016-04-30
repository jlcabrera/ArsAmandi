package controller;

import Model.Usuario;

/**
 * Created by Zeky on 30/4/16.
 */
public class UserController {

    private static Usuario user;

    static{
        user = new Usuario();
    }

    public UserController(){

    }

    public UserController(Usuario userio){
        user = userio;
    }

    //Metodo para guardar un usuario en el
}
