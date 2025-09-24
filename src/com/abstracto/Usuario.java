
package com.abstracto;

import com.entidades.Notificacion;
import com.excepciones.PinException;
import com.excepciones.CedulaException;
import com.excepciones.PasswordException;

import com.excepciones.LongitudNoAdmitidaExceptión;
import com.excepciones.SoloLetrasExceptión;
import com.excepciones.CorreoException;
import com.excepciones.EmptyFieldException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhona
 */
public abstract class Usuario implements Serializable{
    protected String cedula;
    protected String nombre;
    protected String correo;
    protected int pin;
    protected String genero;
    protected List<Notificacion> notificaciones;

    public Usuario(String cedula, String Nombre, String Correo, int pin, String genero) throws CorreoException, SoloLetrasExceptión, LongitudNoAdmitidaExceptión, PasswordException, EmptyFieldException, CedulaException, PinException {
        this.cedula = cedula;
        this.nombre = Nombre;
        this.correo = Correo;
        this.pin = pin;
        this.genero = genero;
        notificaciones = new ArrayList<>();
        
        
        
        if (!correo.contains("@")) {
            throw new CorreoException("Correo Invalido\nEjemplo: example@gmail.com");
        }
        
        if (!nombre.replace(" ", "").matches("[a-zA-Z]+")) {
            throw new SoloLetrasExceptión("EL NOMBRE SOLO TIENE QUE CONTENER SOLO LETRAS SIN NUMEROS.");
        }
        
        if (nombre.length() < 3 || nombre.length() > 30) {
            throw new LongitudNoAdmitidaExceptión("EL NOMBRE DEBE TENER ENTRE 3 Y 30 CARACTERES");
        }
        
        if (nombre.equals("") || correo.equals("") || genero.equals("")) {
                throw new EmptyFieldException("NO PUEDES DEJAR CAMPOS VACIOS!!");
            }
        
        if (cedula.length() < 8 || cedula.length() > 12) {
            throw new CedulaException("LA CEDULA DEBE DE TENER ENTRE 8 y 12 DIGITOS");
        }
        
        String codi = String.valueOf(pin);
        if (codi.length() != 4) {
            throw new PinException("EL PIN DEBE TENER CUATRO DIGITOS");
        }
        
        
        
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", Nombre=" + nombre + ", Correo=" + correo + ", pin=" + pin + ", genero=" + genero + '}';
    }
    
    public String listarNotificaciones(){
        String lis = " ";
        for (Notificacion notificacion : notificaciones) {
            lis += notificacion.toString();
        }
        return lis;
    }
    
    public void agregarNotificacion(Notificacion x){
        notificaciones.add(x);
    }
    
    public void eliminarNotificacion(Notificacion x){
        notificaciones.remove(x);
    }
    
    public boolean comparar(Usuario u) {
        return u.getCedula().equalsIgnoreCase(cedula);
    }
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }
    
    
}
