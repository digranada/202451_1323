/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorvehiculos;

/**
 *
 * @author David Granada
 */
import java.util.Date;

public class VentaTaller {
    public TallerVehiculo taller;
    public Date fechaVenta;
    public String estado; // "Pendiente" o "Finalizado"
    public double costo;

    public VentaTaller(TallerVehiculo taller, Date fechaVenta) {
        this.taller = taller;
        this.fechaVenta = fechaVenta;
        this.estado = "Pendiente"; // Estado inicial
        this.costo = 0.0;
    }

    public void finalizarVenta(double costo) {
        this.estado = "Finalizado";
        this.costo = costo;
        System.out.println("Venta finalizada para el taller " + taller.getNombre() + " con costo: " + costo);
    }

    public String getEstado() {
        return estado;
    }

    public TallerVehiculo getTaller() {
        return taller;
    }

    public double getCosto() {
        return costo;
    }
}