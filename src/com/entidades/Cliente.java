
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
import java.time.LocalDate;

/**
 *
 * @author jhona
 */
public class Cliente extends Usuario implements Serializable{
    private boolean estudiante;
    private Membresia membresia;
    private float totalGastado;
    

    public Cliente(String cedula, String Nombre, String Correo, int pin, String genero, boolean estudiante) throws CorreoException, SoloLetrasExceptión, LongitudNoAdmitidaExceptión, PasswordException, EmptyFieldException, CedulaException, PinException {
        super(cedula, Nombre, Correo, pin, genero);
        this.estudiante = estudiante;
        this.membresia = null;
        totalGastado = 0;
    }
    
    public void añadirMembresia(int codigo, String tipo, float costoBase, LocalDate fecha){
        if(membresia==null){
            membresia = new Membresia(codigo, tipo, costoBase, fecha);
            totalGastado += totalPagar();
        }
        else if(!membresia.isEstado()){
            membresia = new Membresia(codigo, tipo, costoBase, fecha);
            totalGastado += totalPagar();
        }
        membresia.establecerEstado();
    }

    @Override
    public String toString() {
        return super.toString() + "estudiante=" + estudiante + '}';
    }
    
    
    
    public void desactivarMembresia(){
        membresia.setEstado(false);
    }
    
    private float descuentoEstudiante(){
        if(estudiante){
            return membresia.costoTotal() * 0.1f;
        }
        return 0;
    }
    
    public float totalPagar(){
        return membresia.costoTotal() - descuentoEstudiante();
    }

    public boolean isEstudiante() {
        return estudiante;
    }

    public void setEstudiante(boolean estudiante) {
        this.estudiante = estudiante;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    public float getTotalGastado() {
        return totalGastado;
    }

    public void setTotalGastado(float totalGastado) {
        this.totalGastado = totalGastado;
    }
    
}
