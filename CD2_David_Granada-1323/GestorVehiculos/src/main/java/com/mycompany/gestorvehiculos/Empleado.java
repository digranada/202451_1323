/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorvehiculos;

/**
 *
 * @author David Granada
 */
public class Empleado implements Gestor {
    public String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void gestionarUsuario(Usuario usuario) {
        System.out.println("Gestionando usuario: " + usuario.getNombre());
    }

    @Override
    public void gestionarVehiculo(Vehiculo vehiculo) {
        System.out.println("Gestionando vehículo: " + vehiculo.getPlaca());
    }
}