/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.excepciones;

import java.io.Serializable;

/**
 *
 * @author jhona
 */
public class SesionVaciaExeption extends Exception implements Serializable{
    public SesionVaciaExeption(String message){
        super(message);
    }
}
