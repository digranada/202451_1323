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

public class Taller {
    public List<Vehiculo> catalogoVehiculos; // Asociación

    public Taller() {
        this.catalogoVehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        catalogoVehiculos.add(vehiculo);
        System.out.println("Vehículo " + vehiculo.getPlaca() + " agregado al taller.");
    }

    public List<Vehiculo> getCatalogoVehiculos() {
        return catalogoVehiculos;
    }
}