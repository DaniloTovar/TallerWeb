/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author danil
 */
public class Persona {
    int id;
    String nombre;
    String apellido;
    double valorPrestamo;
    int mes;
    
    public Persona() {
    }
    public Persona(String nombre, String apellido, double valorPrestamo, int mes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.valorPrestamo = valorPrestamo;
        this.mes = mes;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public double getValorPrestamo() {
        return valorPrestamo;
    }
    public void setValorPrestamo(double valorPrestamo) {
        this.valorPrestamo = valorPrestamo;
    }
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    
    
}
