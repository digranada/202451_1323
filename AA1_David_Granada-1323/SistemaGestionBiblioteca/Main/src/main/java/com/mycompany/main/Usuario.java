/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author Granada David
 */
import java.util.ArrayList; //importa la clase ArrayList y almacen una lista dinámica de objetos
public class Usuario { //declara una clase pública que será accesible desde otras clases.
    private static int contadorId = 1; // Atributo estático que se inicializa en 1. 
    private final int id; // declara una variable de instancia de tipo int que no puede cambiar después de ser asignada. 
    private String nombre; //declara una variable de tipo String para almacenar el nombre del usuario.
    private ArrayList<Libro> librosPrestados; // declara una variable de instancia librosPrestados que será utilizada para almacenar una lista dinámica de objetos Libro 
    public Usuario(String nombre) {//declara el constructor público de la clase Usuario, para inicializar un nuevo objeto Usuario.
        this.id = contadorId++; //asigna a la variable id el valor actual de contadorId y luego incrementa contadorId en 1. 
        this.nombre = nombre; //inicializa la variable nombre con el valor del argumento en el constructor.
        this.librosPrestados = new ArrayList<>();// inicializa la lista librosPrestados que almacenará los libros prestados por el usuario.
    }
    public int getId() { // define un método público que devuelve el valor del atributo id
        return id;
    }
    public String getNombre() { // define un método público que devuelve el valor del atributo nombre
        return nombre;
    }
    public void setNombre(String nombre) {// define un método público que permite modificar el nombre del usuario
        this.nombre = nombre;
    }
    public void agregarLibroPrestado(Libro libro) {// define un método público que agrega un libro a la lista de librosPrestados del usuario
        librosPrestados.add(libro);
    }
    public void devolverLibro(Libro libro) { // define un método público que elimina un libro de la lista librosPrestados
        librosPrestados.remove(libro);
    }
    public ArrayList<Libro> getLibrosPrestados() {// define un método público que devuelve la lista de libros prestados por el usuario.
        return librosPrestados;
    }
    @Override // sobrescribe el método toString() de la clase Object, devuelve una cadena de texto con el ID y nombre.
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre;
    }
}
