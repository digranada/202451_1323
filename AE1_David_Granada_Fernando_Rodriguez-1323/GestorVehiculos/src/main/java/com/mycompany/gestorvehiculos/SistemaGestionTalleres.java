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
import java.util.Date;
import java.util.List;

public class SistemaGestionTalleres {
    public List<TallerVehiculo> talleres; // Agregación
    public List<VentaTaller> ventas; // Agregación

    public SistemaGestionTalleres() {
        this.talleres = new ArrayList<>();
        this.ventas = new ArrayList<>();
    }

    public void registrarTaller(String nombre, String dueño) {
        TallerVehiculo taller = new TallerVehiculo(nombre, dueño);
        talleres.add(taller);
        System.out.println("Taller " + nombre + " registrado.");
    }

    public void registrarVenta(TallerVehiculo taller, Date fechaVenta) {
        VentaTaller venta = new VentaTaller(taller, fechaVenta);
        ventas.add(venta);
        System.out.println("Venta registrada para el taller " + taller.getNombre());
    }

    public void listarTalleres() {
        System.out.println("Talleres registrados:");
        for (TallerVehiculo taller : talleres) {
            System.out.println("Taller: " + taller.getNombre() + ", Dueño: " + taller.getDueño());
            for (Vehiculo vehiculo : taller.getVehiculos()) {
                System.out.println("  Vehículo: " + vehiculo.getPlaca());
            }
        }
    }

    public void mostrarHistorialVentas() {
        System.out.println("Historial de ventas:");
        for (VentaTaller venta : ventas) {
            System.out.println("Taller: " + venta.getTaller().getNombre() + ", Estado: " + venta.getEstado() + ", Costo: " + venta.getCosto());
        }
    }

    public void actualizarResultadoVenta(VentaTaller venta, double costo) {
        if (venta.getEstado().equals("Pendiente")) {
            venta.finalizarVenta(costo);
        } else {
            System.out.println("La venta ya está finalizada.");
        }
    }
}