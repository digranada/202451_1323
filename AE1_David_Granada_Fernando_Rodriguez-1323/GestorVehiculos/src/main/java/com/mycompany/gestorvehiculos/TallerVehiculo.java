/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorvehiculos;

/**
 *
 * @author David Granada
 */
import java.util.ArrayList;
import java.util.List;

public class TallerVehiculo {
    public String nombre;
    public String dueño;
    public List<Vehiculo> vehiculos; // Composición

    public TallerVehiculo(String nombre, String dueño) {
        this.nombre = nombre;
        this.dueño = dueño;
        this.vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        System.out.println("Vehículo " + vehiculo.getPlaca() + " agregado al taller " + nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDueño() {
        return dueño;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}