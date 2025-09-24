
package com.entidades;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author jhona
 */
public class Notificacion implements Serializable{
    private int codigo;
    private String titulo;
    private String descripcion;
    private String tipo;
    private LocalDate fecha;

    public Notificacion(int codigo, String titulo, String descripcion, String tipo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        fecha = LocalDate.now();
    }

    @Override
    public String toString() {
        return "código: " + codigo + ", titulo: " + titulo + ", descripción: " + descripcion + ", tipo: " + tipo + ", fecha: " + fecha.toString();
    }
    
    public String crearDescripcionVencimiento(Membresia membresia){
        return "Su membresía "+membresia.getTipo() +" Se encuentra deshabilitada desde el " + membresia.calcularFechaVencimiento().toString() +" ,si quiere seguir entrenando en el gimnasio asegurese de comprar una nueva membresia.";
    }
    
    public String crearDescripcionSesion(Sesion sesion){
        return "La sesión: "+sesion.getNombre()+" es hoy "+sesion.getDia()+" a las "+sesion.getHoraIni()+", asegurate de asistir!";
    }
    
    public String crearDescripcionSesionEntrenador(Sesion sesion){
        return "Tiene programado liderar la sesión: "+sesion.getNombre()+" hoy "+sesion.getDia()+" a las "+sesion.getHoraIni()+", recuerde asistir!";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
}
