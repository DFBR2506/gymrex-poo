/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.control;

import com.abstracto.Usuario;
import com.entidades.Cliente;
import com.entidades.Entrenador;
import com.entidades.Gimnasio;
import com.entidades.Notificacion;
import com.entidades.Sesion;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author jhona
 */
public class ControladorNotificaciones {
    public void añadirNotificacion(Usuario usuario, Gimnasio gimnasio, Notificacion notificacion){
        usuario.agregarNotificacion(notificacion);
        gimnasio.agregarNotificacion(notificacion);
    }
    
    public void actualizarNotificaciones(Usuario usuario, Gimnasio gimnasio){
        if(usuario instanceof Cliente cliente){
            List<Notificacion> notificaciones = cliente.getNotificaciones();
            if(cliente.getMembresia() != null){
                if(!cliente.getMembresia().isEstado()){
                    Notificacion vencimiento = null;
                    for (Notificacion notificacion : notificaciones) {
                        if(notificacion.getTipo().equalsIgnoreCase("Vencimiento:"+cliente.getMembresia().getCodigo())){
                            vencimiento = notificacion;
                        }
                    }
                    if(vencimiento == null){
                        vencimiento = new Notificacion(gimnasio.obtenerCodigoMaximoNotificaciones() + 1, "Vencimiento de membresía", "" , "Vencimiento:"+cliente.getMembresia().getCodigo());
                        vencimiento.setDescripcion(vencimiento.crearDescripcionVencimiento(cliente.getMembresia()));
                        añadirNotificacion(cliente, gimnasio, vencimiento);
                    }
                }
            }
            List<Sesion> sesiones = gimnasio.getSesiones();
            for (Sesion sesion : sesiones) {
                if(sesion.buscarIntegrante(cliente.getCedula())){
                    if(sesion.transformarDiaWeek() == LocalDate.now().getDayOfWeek()){
                        Notificacion haySesion = null;
                        for (Notificacion notificacion : notificaciones){
                            if(notificacion.getTipo().equalsIgnoreCase("Sesion:"+sesion.getCodigo()+":"+LocalDate.now().toString())){
                                haySesion = notificacion;
                            }
                        }
                        if(haySesion == null){
                            haySesion = new Notificacion(gimnasio.obtenerCodigoMaximoNotificaciones() + 1, "Se aproxima una sesión", "", "Sesion:"+sesion.getCodigo()+":"+LocalDate.now().toString());
                            haySesion.setDescripcion(haySesion.crearDescripcionSesion(sesion));
                            añadirNotificacion(cliente, gimnasio, haySesion);
                        }
                    }
                }
            }
        }
        else if(usuario instanceof Entrenador entrenador){
            List<Notificacion> notificaciones = entrenador.getNotificaciones();
            List<Sesion> sesiones = gimnasio.getSesiones();
            for (Sesion sesion : sesiones){
                if(sesion.getEntrenador().getCedula()==entrenador.getCedula()){
                    if(sesion.transformarDiaWeek() == LocalDate.now().getDayOfWeek()){
                        Notificacion haySesion = null;
                        for (Notificacion notificacion : notificaciones){
                            if(notificacion.getTipo().equalsIgnoreCase("Sesion:"+sesion.getCodigo()+":"+LocalDate.now().toString())){
                                haySesion = notificacion;
                            }
                        }
                        if(haySesion == null){
                            haySesion = new Notificacion(gimnasio.obtenerCodigoMaximoNotificaciones() + 1, "Se aproxima una sesión", "", "Sesion:"+sesion.getCodigo()+":"+LocalDate.now().toString());
                            haySesion.setDescripcion(haySesion.crearDescripcionSesionEntrenador(sesion));
                            añadirNotificacion(entrenador, gimnasio, haySesion);
                        }
                    }
                }
            }
        }
    }
    
}
