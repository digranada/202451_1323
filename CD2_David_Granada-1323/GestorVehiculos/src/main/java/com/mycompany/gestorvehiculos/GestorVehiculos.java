/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestorvehiculos;

/**
 *
 * @author David Granada
 */
public class GestorVehiculos {

    public static void main(String[] args) {
        // Creamos Objeto 1
        Taller taller = new Taller();
        // Creamos Objeto 2
        Vehiculo vehiculo1 = new Vehiculo("PYH-706", "CH251545", 2024, "Aveo", 7000);
        taller.agregarVehiculo(vehiculo1);
        // Creamos Objeto 3
        Usuario usuario1 = new Usuario("David Granada", "1724034066");
        usuario1.matricularVehiculo(vehiculo1);
        // Creamos Objeto 4
        Transaccion transaccion = new Transaccion(usuario1, vehiculo1);
        transaccion.registrarPrestamo();
        transaccion.registrarDevolucion();
        // Creamos Objeto 5
        Empleado empleado = new Empleado("Roberto");
        empleado.gestionarUsuario(usuario1);
        empleado.gestionarVehiculo(vehiculo1);
    }
}