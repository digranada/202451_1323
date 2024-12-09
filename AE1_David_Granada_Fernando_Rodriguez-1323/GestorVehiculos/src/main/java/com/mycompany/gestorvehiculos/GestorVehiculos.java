/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestorvehiculos;

/**
 *
 * @author David Granada
 */
import java.util.Date;
public class GestorVehiculos {
    
    public static void main(String[] args) {
        
        SistemaGestionTalleres sistema = new SistemaGestionTalleres();

        // Registrar talleres
        sistema.registrarTaller("Taller A", "Juan Pérez");
        sistema.registrarTaller("Taller B", "María López");

        // Crear vehículos
        Vehiculo vehiculo1 = new Vehiculo("ABC-123", "CH123456", 2020, "Sedan", 15000);
        Vehiculo vehiculo2 = new Vehiculo("XYZ-789", "CH654321", 2021, "SUV", 20000);

        // Agregar vehículos a talleres
        TallerVehiculo tallerA = sistema.talleres.get(0);
        TallerVehiculo tallerB = sistema.talleres.get(1);
        tallerA.agregarVehiculo(vehiculo1);
        tallerB.agregarVehiculo(vehiculo2);

        // Listar talleres y vehículos
        sistema.listarTalleres();

        // Registrar ventas
        sistema.registrarVenta(tallerA, new Date());
        sistema.registrarVenta(tallerB, new Date());

        // Mostrar historial de ventas
        sistema.mostrarHistorialVentas();

        // Actualizar resultado de una venta
        VentaTaller venta = sistema.ventas.get(0);
        sistema.actualizarResultadoVenta(venta, 18000);

        // Mostrar historial de ventas actualizado
        sistema.mostrarHistorialVentas();
    }
}