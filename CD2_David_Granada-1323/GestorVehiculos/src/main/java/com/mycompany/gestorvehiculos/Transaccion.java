/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorvehiculos;

/**
 *
 * @author David Granada
 */
public class Transaccion {
    public Usuario usuario; // Agregación
    public Vehiculo vehiculo; // Agregación

    public Transaccion(Usuario usuario, Vehiculo vehiculo) {
        this.usuario = usuario;
        this.vehiculo = vehiculo;
    }

    public void registrarPrestamo() {
        vehiculo.prestar();
        System.out.println("Préstamo registrado para " + usuario.getNombre());
    }

    public void registrarDevolucion() {
        vehiculo.devolver();
        System.out.println("Devolución registrada para " + usuario.getNombre());
    }
}
