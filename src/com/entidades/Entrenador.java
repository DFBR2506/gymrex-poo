
package com.entidades;

import com.excepciones.PinException;
import com.abstracto.Usuario;
import com.excepciones.CedulaException;
import com.excepciones.CorreoException;
import com.excepciones.EmptyFieldException;
import com.excepciones.LongitudNoAdmitidaExceptión;
import com.excepciones.PasswordException;
import com.excepciones.SoloLetrasExceptión;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhona
 */
public class Entrenador extends Usuario implements Serializable{
    private List<Sesion> sesiones = new ArrayList<>();
    
    
    public Entrenador(String cedula, String Nombre, String Correo, int pin, String genero) throws CorreoException, SoloLetrasExceptión, LongitudNoAdmitidaExceptión, PasswordException, EmptyFieldException, CedulaException, PinException {
        super(cedula, Nombre, Correo, pin, genero);
    }
    
    
    public void añadirSesion(Sesion x){
        sesiones.add(x);
    }
    
    public void eliminarSesion(int codigo){
        for (Sesion sesion : sesiones) {
            if(sesion.getCodigo()==codigo){
                sesiones.remove(sesion);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + "sesiones=" + sesiones + '}';
    }
    
    public String listarSesiones(){
        String lis = " ";
        for (Sesion sesion : sesiones) {
            lis += sesion.toString() + "\n";
        }
        return lis;
    }
    
    public boolean buscarSesion(int codigo){
        for (Sesion sesion : sesiones) {
            if(sesion.getCodigo()==codigo){
                return true;
            }
        }
        return false;
    }

    public List<Sesion> getSesiones() {
        return sesiones;
    }

    public void setSesiones(List<Sesion> sesiones) {
        this.sesiones = sesiones;
    }
    
}
