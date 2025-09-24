
package com.entidades;

import com.excepciones.SesionVaciaExeption;
import com.excepciones.HoraFueraDeRangoExeption;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhona
 */
public class Sesion implements Serializable{
    private int codigo;
    private Entrenador entrenador;
    private String nombre;
    private List<Cliente> integrantes= new ArrayList<>();
    private String dia;
    private int horaIni;
    private int horaFin;

    public Sesion(int codigo, String nombre, String dia, int horaIni, int horaFin, Entrenador entrenador) throws SesionVaciaExeption, HoraFueraDeRangoExeption {
        if(nombre.isBlank()){
            throw new SesionVaciaExeption("EL NOMBRE DE LA SESIÓN NO PUEDE SER VACIO");
        }
        if((horaFin < 0 || horaFin > 24) || (horaIni < 0 || horaFin > 24)){
            throw new HoraFueraDeRangoExeption("LAS HORAS DEBEN ESTAR EN FORMATO 24 HORAS");
        }
        if(horaIni >= horaFin){
            throw new HoraFueraDeRangoExeption("LA HORA DE INICIO NO PUEDE SER MAYOR NI IGUAL A LA HORA DE FINALIZACIÓN");
        }
        this.codigo = codigo;
        this.entrenador = entrenador;
        this.nombre = nombre;
        this.dia = dia;
        this.horaIni = horaIni;
        this.horaFin = horaFin;
    }
    
    public void insertarIntegrante(Cliente x){
        integrantes.add(x);
    }
    
    public void eliminarIntegrante(String cedula){
        for (Cliente integrante : integrantes) {
            if(integrante.getCedula().equalsIgnoreCase(cedula)){
                integrantes.remove(integrante);
                break;
            }
        }
    }
    
    public String listarIntegrantes(){
        String lis = " ";
        for (Cliente integrante : integrantes) {
            lis += integrante.toString();
        }
        return lis;
    }
    
    public String listarNombreIntegrantes(){
        String lis = " ";
        for (Cliente integrante : integrantes) {
            lis += integrante.getNombre() + "\n";
        }
        return lis;
    }
    
    public boolean buscarIntegrante(String cedula){
        for (Cliente integrante : integrantes) {
            if(integrante.getCedula().equalsIgnoreCase(cedula)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Sesion{" + "codigo=" + codigo + ", entrenador=" + entrenador.getNombre() + ", nombre=" + nombre + ", integrantes=" + integrantes + ", dia=" + dia + ", horaIni=" + horaIni + ", horaFin=" + horaFin + '}';
    }
    
    public DayOfWeek transformarDiaWeek(){
        if(dia.equalsIgnoreCase("Lunes")) {
            return DayOfWeek.MONDAY;
        } else if(dia.equalsIgnoreCase("Martes")){
            return DayOfWeek.TUESDAY;
        }
        else if(dia.equalsIgnoreCase("Miercoles")){
            return DayOfWeek.WEDNESDAY;
        }
        else if(dia.equalsIgnoreCase("Jueves")){
            return DayOfWeek.THURSDAY;
        }
        else if(dia.equalsIgnoreCase("Viernes")){
            return DayOfWeek.FRIDAY;
        }
        else{
            return DayOfWeek.SATURDAY;
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Cliente> integrantes) {
        this.integrantes = integrantes;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(int horaIni) {
        this.horaIni = horaIni;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
    
}
