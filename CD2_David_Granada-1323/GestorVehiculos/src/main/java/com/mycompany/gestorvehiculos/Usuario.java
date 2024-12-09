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
import java.util.regex.Pattern;

public class Usuario {
    public String nombre;
    public String numeroCedula;
    public List<Vehiculo> vehiculosMatriculados; // Composición

    public Usuario(String nombre, String numeroCedula) {
        if (!validarCedula(numeroCedula)) {
            throw new IllegalArgumentException("Cédula inválida.");
        }
        this.nombre = nombre;
        this.numeroCedula = numeroCedula;
        this.vehiculosMatriculados = new ArrayList<>();
    }

    private boolean validarCedula(String cedula) {
        return Pattern.matches("[0-9]{10}", cedula); // Ejemplo de formato: 1234567890
    }

    public void matricularVehiculo(Vehiculo vehiculo) {
        vehiculosMatriculados.add(vehiculo);
        System.out.println("Vehículo " + vehiculo.getPlaca() + " matriculado por " + nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Vehiculo> getVehiculosMatriculados() {
        return vehiculosMatriculados;
    }
}
