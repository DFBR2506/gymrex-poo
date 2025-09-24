/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.control;

import com.entidades.Sesion;

/**
 *
 * @author jhona
 */
public class ControladorSesiones {
    public boolean horasCruzadasSesiones(Sesion x, Sesion y){
        if(x.getDia().equals(y.getDia())){
            if(!(x.getHoraFin() <= y.getHoraIni() || y.getHoraFin() <= x.getHoraIni())){
                return true;
            }
        }
        return false;
    }
}
