/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author jhona
 */
public class Membresia implements Serializable{
    private int codigo;
    private String tipo;
    private float costoBase;
    private LocalDate fecha;
    private boolean estado;

    public Membresia(int codigo, String tipo, float costoBase, LocalDate fecha) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.costoBase = costoBase;
        this.fecha = fecha;
        establecerEstado();
    }
    
    private float calcularCostoBase(){
        if(tipo.equalsIgnoreCase("mensual")){
            return costoBase;
        }
        else if(tipo.equalsIgnoreCase("trimestral")){
            return costoBase * 3;
        }
        else{
            return costoBase * 12;
        }
    }
    
    private float calcularDescuento(){
        if(tipo.equalsIgnoreCase("mensual")){
            return 0;
        }
        else if(tipo.equalsIgnoreCase("trimestral")){
            return calcularCostoBase() * 0.2f;
        }
        else{
            return calcularCostoBase() * 0.3f;
        }
    }
    
    public float costoTotal(){
        return calcularCostoBase() - calcularDescuento();
    }
    
    public void establecerEstado(){
        long dias = ChronoUnit.DAYS.between(fecha, LocalDate.now());
        if(tipo.equalsIgnoreCase("mensual")){
            if(dias < 30){
                estado = true;
            }
            else{
                estado = false;
            }
        }
        else if(tipo.equalsIgnoreCase("trimestral")){
            if(dias < 90){
                estado = true;
            }
            else{
                estado = false;
            }
        }
        else{
            if(dias < 360){
                estado = true;
            }
            else{
                estado = false;
            }
        }
    }
    
    public long calcularTiempoRestante(){
        long dias = ChronoUnit.DAYS.between(fecha, LocalDate.now());
        if(tipo.equalsIgnoreCase("Mensual")){
            dias = 30 - dias;
        }
        else if(tipo.equalsIgnoreCase("Trimestral")){
            dias = 90 - dias;
        }
        else{
            dias = 360 - dias;
        }
        return dias;
    }
    
    public LocalDate calcularFechaVencimiento(){
        LocalDate fechaVencimiento;
        if(tipo.equalsIgnoreCase("Mensual")){
            fechaVencimiento = fecha.plusDays(30);
        }
        else if(tipo.equalsIgnoreCase("Trimestral")){
            fechaVencimiento = fecha.plusDays(90);
        }
        else{
            fechaVencimiento = fecha.plusDays(360);
        }
        return fechaVencimiento;
    }

    @Override
    public String toString() {
        return "Factura{" + "codigo=" + codigo + ", tipo=" + tipo + ", costo=" + costoBase + ", fecha=" + fecha + '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(float costoBase) {
        this.costoBase = costoBase;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
