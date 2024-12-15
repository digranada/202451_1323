/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author Granada David
 */
public class Libro { //declara una clase pública llamada Libro
    private static int contadorId = 1; // declara una variable estática contadorId que se inicializa en 1. 
    private final int id; // declara una variable de instancia de tipo int. 
    private String titulo; // una cadena de texto para almacenar el título del libro
    private String autor; // una cadena de texto para almacenar el autor del libro
    private boolean prestado; // una variable booleana para indicar si el libro está prestado o no.

    public Libro(String titulo, String autor) { //declara un constructor público para la clase Libro que toma dos parámetros (titulo y autor) para inicializar un nuevo objeto de tipo Libro.
        this.id = contadorId++; //asigna a la variable de instancia id el valor actual de contadorId y luego incrementa contadorId en 1. 
        this.titulo = titulo;// inicializa los atributos titulo, autor y prestado
        this.autor = autor;
        this.prestado = false;
    }
    public int getId() {// define un método público que devuelve el valor del atributo id
        return id;
    }
    public String getTitulo() {// define un método público que devuelve el valor del atributo titulo
        return titulo;
    }
    public void setTitulo(String titulo) {// define un método público que establece el valor del atributo titulo
        this.titulo = titulo;
    }
    public String getAutor() {// define un método público que devuelve el valor del atributo autor.
        return autor; // Permite modificar el título del libro.
    }
    public void setAutor(String autor) {// define un método público que establece el valor del atributo autor.
        this.autor = autor;// Permite acceder al nombre del autor del libro.
    }
    public boolean isPrestado() {// define un método público que devuelve el valor del atributo prestado 
        return prestado;// permite saber si el libro está prestado (true) o no (false).
    }
    public void setPrestado(boolean prestado) {// define un método público que establece el valor del atributo prestado
        this.prestado = prestado;// permite cambiar el estado del libro a prestado o no prestado
    }
    @Override// sobrescribe el método toString() de la clase Object, devuelve una cadena de texto con el ID, título, autor y si está prestado o no
    public String toString() {
        return "ID: " + id + ", Titulo: " + titulo + ", Autor: " + autor + ", Prestado: " + (prestado ? "Si" : "No");
    }
}
