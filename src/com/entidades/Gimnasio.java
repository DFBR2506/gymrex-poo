
package com.entidades;

import com.abstracto.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhona
 */
public class Gimnasio implements Serializable{
    private int codigo;
    private String nombre;
    private List<Usuario> usuarios;
    private List<Sesion> sesiones;
    private List<Notificacion> notificaciones;

    public Gimnasio(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        usuarios = new ArrayList<>();
        sesiones = new ArrayList<>();
        notificaciones = new ArrayList<>();
    }
    
    public void registrarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    
    public void añadirSesion(Sesion sesion){
        sesiones.add(sesion);
    }
    
    public void eliminarSesion(Sesion sesion){
        sesiones.remove(sesion);
    }
    
    public void eliminarSesionCodigo(int codigo){
        for (Sesion sesion : sesiones) {
            if(sesion.getCodigo()==codigo){
                sesiones.remove(sesion);
                break;
            }
        }
    }
    
    public void eliminarUsuario(String cedula){
        for (Usuario usuario : usuarios) {
            if(usuario.getCedula().equalsIgnoreCase(cedula)){
                usuarios.remove(usuario);
                break;
            }
        }
    }
    
    public String listarUsuarios(){
        String lis = " ";
        for (Usuario usuario : usuarios) {
            lis += usuario.toString();
        }
        return lis;
    }
    
    public String listarSesiones(){
        String lis = " ";
        for (Sesion sesion : sesiones) {
            lis += sesion.toString();
        }
        return lis;
    }
    
    public boolean buscarUsuario(String cedula){
        for (Usuario usuario : usuarios) {
            if(usuario.getCedula().equalsIgnoreCase(cedula)){
                return true;
            }
        }
        return false;
    }
    
    public boolean buscarSesionNombre(String nombre){
        for (Sesion sesion : sesiones) {
            if(sesion.getNombre().equalsIgnoreCase(nombre)){
                return true;
            }
        }
        return false;
    }
    
    public Sesion obtenerSesionNombre(String nombre){
        for (Sesion sesion : sesiones) {
            if(sesion.getNombre().equalsIgnoreCase(nombre)){
                return sesion;
            }
        }
        return null;
    }
    
    public boolean buscarSesionCodigo(int codigo){
        for (Sesion sesion : sesiones) {
            if(sesion.getCodigo()==codigo){
                return true;
            }
        }
        return false;
    }
    
    public Sesion obtenerSesionCodigo(int codigo){
        for (Sesion sesion : sesiones) {
            if(sesion.getCodigo()==codigo){
                return sesion;
            }
        }
        return null;
    }
    
    public Usuario obtenerUsuario(String cedula){
        for (Usuario usuario : usuarios) {
            if(usuario.getCedula().equalsIgnoreCase(cedula)){
                return usuario;
            }
        }
        return null;
    }
    
    public void cargarSesiones(){
        for (Usuario usuario : usuarios) {
            if(usuario instanceof Entrenador entrenador){
                List<Sesion>  listaaux = entrenador.getSesiones();
                for (Sesion sesion : listaaux) {
                    if(!sesiones.contains(sesion)){
                        sesiones.add(sesion);
                    }
                }
            }
        }
    }
    
    public String listarNotificaciones(){
        String lis = " ";
        for (Notificacion notificacion : notificaciones) {
            lis += notificacion.toString();
        }
        return lis;
    }
    
    public int obtenerCodigoMaximoMembresias(){
        int codigoMaximo = 0;
        for (Usuario usuario : usuarios) {
            if(usuario instanceof Cliente cliente){
                if(cliente.getMembresia() != null){
                    if(cliente.getMembresia().getCodigo() > codigoMaximo){
                        codigoMaximo = cliente.getMembresia().getCodigo();
                    }
                }
            }
        }
        return codigoMaximo;
    }
    
    public int obtenerCodigoMaximoSesiones(){
        int codigoMaximo = 0;
        for (Sesion sesion : sesiones) {
            if(sesion.getCodigo()>codigoMaximo){
                codigoMaximo = sesion.getCodigo();
            }
        }
        return codigoMaximo;
    }
    
    public int obtenerCodigoMaximoNotificaciones(){
        int codigoMaximo = 0;
        for(Notificacion notificacion : notificaciones){
            if(notificacion.getCodigo()>codigoMaximo){
                codigoMaximo = notificacion.getCodigo();
            }
        }
        return codigoMaximo;
    }
    
    public float obtenerIngresos(){
        float ingresos = 0;
        for (Usuario usuario : usuarios) {
            if(usuario instanceof Cliente cliente){
                ingresos += cliente.getTotalGastado();
            }
        }
        return ingresos;
    }
    
    public float calcularPorcentajeHombres(){
        float cantidad = usuarios.size();
        float cantidadHombres = 0;
        for (Usuario usuario : usuarios) {
            if(usuario.getGenero().equalsIgnoreCase("Hombre")){
                cantidadHombres++;
            }
        }
        return Math.round(cantidadHombres/cantidad * 100);
    }
    
    public float calcularPorcentajeMujeres(){
        float cantidad = usuarios.size();
        float cantidadMujeres = 0;
        for (Usuario usuario : usuarios) {
            if(usuario.getGenero().equalsIgnoreCase("Mujer")){
                cantidadMujeres++;
            }
        }
        return Math.round(cantidadMujeres/cantidad * 100);
    }
    
    public float calcularPorcentajeEstudiantes(){
        float cantidad = usuarios.size();
        float cantidadEstudiantes = 0;
        for (Usuario usuario : usuarios) {
            if(usuario instanceof Cliente cliente){
                if(cliente.isEstudiante()){
                    cantidadEstudiantes++;
                }
            }
        }
        return Math.round(cantidadEstudiantes/cantidad * 100f);
    }
    
    public int cantidadMembresiasActivas(){
        int cantidadMembresias = 0;
        for (Usuario usuario : usuarios) {
            if(usuario instanceof Cliente cliente){
                if(cliente.getMembresia() != null){
                    if(cliente.getMembresia().isEstado()){
                        cantidadMembresias++;
                    }
                }
            }
        }
        return cantidadMembresias;
    }
    
    public int cantidadSesiones(){
        return sesiones.size();
    }
    
    public float porcentajeMembresiasMensuales(){
        float cantidadMembresias = cantidadMembresiasActivas();
        float cantidadMembresiasMensuales = 0;
        for (Usuario usuario : usuarios) {
            if(usuario instanceof Cliente cliente){
                if(cliente.getMembresia() != null){
                    if(cliente.getMembresia().isEstado() && cliente.getMembresia().getTipo().equalsIgnoreCase("Mensual")){
                        cantidadMembresiasMensuales++;
                    }
                }
            }
        }
        return Math.round(cantidadMembresiasMensuales/cantidadMembresias * 100f);
    }
    
    public float porcentajeMembresiasTrimestrales(){
        float cantidadMembresias = cantidadMembresiasActivas();
        float cantidadMembresiasTrimestrales = 0;
        for (Usuario usuario : usuarios) {
            if(usuario instanceof Cliente cliente){
                if(cliente.getMembresia() != null){
                    if(cliente.getMembresia().isEstado() && cliente.getMembresia().getTipo().equalsIgnoreCase("Trimestral")){
                        cantidadMembresiasTrimestrales++;
                    }
                }
            }
        }
        return Math.round(cantidadMembresiasTrimestrales/cantidadMembresias * 100f);
    }
    
    public float porcentajeMembresiasAnuales(){
        float cantidadMembresias = cantidadMembresiasActivas();
        float cantidadMembresiasAnuales = 0;
        for (Usuario usuario : usuarios) {
            if(usuario instanceof Cliente cliente){
                if(cliente.getMembresia() != null){
                    if(cliente.getMembresia().isEstado() && cliente.getMembresia().getTipo().equalsIgnoreCase("Anual")){
                        cantidadMembresiasAnuales++;
                    }
                }
            }
        }
        return Math.round(cantidadMembresiasAnuales/cantidadMembresias * 100f);
    }
    
    public void agregarNotificacion(Notificacion x){
        notificaciones.add(x);
    }
    
    public void eliminarNotificacion(Notificacion x){
        notificaciones.remove(x);
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Sesion> getSesiones() {
        return sesiones;
    }

    public void setSesiones(List<Sesion> sesiones) {
        this.sesiones = sesiones;
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }
    
}
