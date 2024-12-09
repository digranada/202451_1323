/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorvehiculos;
/**
 *
 * @author David Granada
 */
import java.util.regex.Pattern;
public class Vehiculo implements Prestable {
    public String placa;
    public String numeroChasis;
    public int año;
    public String tipo;
    public double costoVehiculo;

    public Vehiculo(String placa, String numeroChasis, int año, String tipo, double costoVehiculo) {
        if (!validarPlaca(placa)) {
            throw new IllegalArgumentException("Placa inválida.");
        }
        this.placa = placa;
        this.numeroChasis = numeroChasis;
        this.año = año;
        this.tipo = tipo;
        this.costoVehiculo = costoVehiculo;
    }

    private boolean validarPlaca(String placa) {
        return Pattern.matches("[A-Z]{3}-[0-9]{3}", placa); // Ejemplo de formato: ABC-123
    }

    @Override
    public void prestar() {
        System.out.println("Vehículo " + placa + " prestado.");
    }

    @Override
    public void devolver() {
        System.out.println("Vehículo " + placa + " devuelto.");
    }

    public String getPlaca() {
        return placa;
    }
}