package com.control;

import com.abstracto.Usuario;
import com.entidades.Entrenador;
import com.entidades.Gimnasio;
import com.entidades.Sesion;

import com.excepciones.EmptyFieldException;

import java.util.ArrayList;

/**
 *
 * @author jhona
 */
public class ControladorGimnasio {
    //ArrayList<Usuario> usuarios;
    ArrayList<Usuario> usuarios = new ArrayList<>();
    
    public ControladorGimnasio() {
    }
    
    
    
    
    public void agregarUsuario(Gimnasio gimnasio, Usuario usuario)throws EmptyFieldException {
        gimnasio.registrarUsuario(usuario);
    }
    
    public Usuario obtenerUsuario(String ced, Gimnasio gimnasio){
        return gimnasio.obtenerUsuario(ced);
    }
    
    public boolean buscarUsuario(String ced, Gimnasio gimnasio){
        return gimnasio.buscarUsuario(ced);
    }
        
    public Usuario usuarioABuscar(int pin){
        for (Usuario usuario : usuarios) {
            if (usuario.getPin()==pin) {
                return usuario;
            }
        }
        return null;
    }
    
    public void añadirSesion(Sesion sesion, Entrenador entrenador, Gimnasio gimnasio){
        entrenador.añadirSesion(sesion);
        gimnasio.añadirSesion(sesion);
    }
     
    
}
