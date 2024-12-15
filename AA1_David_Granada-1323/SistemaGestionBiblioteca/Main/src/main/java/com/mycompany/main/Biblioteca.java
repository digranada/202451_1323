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
public class Biblioteca { //declaración de la clase Biblioteca
    private ArrayList<Libro> libros; //declara una lista para almacenar libros
    private ArrayList<Usuario> usuarios; // declara una lista para almacenar usuarios
    public Biblioteca() { // Inicializa las listas libros y usuarios como nuevas instancias de ArrayList
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }
    public void agregarLibro(String titulo, String autor) { 
        Libro libro = new Libro(titulo, autor); //crea un nuevo objeto Libro con el título y auto
        libros.add(libro);// agrega a la lista de libros
        System.out.println("Libro agregado: " + libro.getTitulo() + " con ID: " + libro.getId());//imprime un mensaje confirmando que el libro ha sido agregad
    }
    public void registrarUsuario(String nombre) {
        Usuario usuario = new Usuario(nombre);// crea un nuevo objeto Usuario con el nombre del parámetro 
        usuarios.add(usuario);// agrega a la lista de usuarios
        System.out.println("Usuario registrado: " + usuario.getNombre() + " con ID: " + usuario.getId());//imprime un mensaje confirmando que el usuario ha sido registrado
    }
    public void prestarLibro(int idUsuario, int idLibro) {
        Usuario usuario = buscarUsuario(idUsuario); // busca al usuario y al libro mediante sus ID
        Libro libro = buscarLibro(idLibro);
    
        if (usuario != null && libro != null) {// Si ambos existen, verifica si el libro no está prestado.

            if (!libro.isPrestado()) {// Si no lo está prestado
                libro.setPrestado(true);// lo marca como prestado
                usuario.agregarLibroPrestado(libro);// agrega el libro a la lista de libros prestados del usuario.

                System.out.println("El libro '" + libro.getTitulo() + "' ha sido prestado a " + usuario.getNombre());
            } else {
                System.out.println("El libro ya está prestado.");// si el libro ya está prestado, muestra un mensaje indicando que no se puede prestar.
            }
        } else {
            System.out.println("Usuario o libro no encontrado.");// si no se encuentra al usuario o al libro, muestra un mensaje de error.
        }
    }
    public void devolverLibro(int idUsuario, int idLibro) {
        Usuario usuario = buscarUsuario(idUsuario);// se buscan el usuario y el libro por sus ID
        Libro libro = buscarLibro(idLibro);
        
        if (usuario != null && libro != null) {// Si ambos existen 
            if (libro.isPrestado()) {// y el libro está prestado
                libro.setPrestado(false);// se marca como no prestado
                usuario.devolverLibro(libro);// se elimina de la lista de libros prestados del usuario.
                System.out.println("El libro '" + libro.getTitulo() + "' ha sido devuelto por " + usuario.getNombre());
            } else {
                System.out.println("El libro no estaba prestado.");// Si el libro no estaba prestado, muestra un mensaje indicando que no se puede devolver
            }
        } else {
            System.out.println("Usuario o libro no encontrado.");// Si no se encuentra el usuario o el libro, muestra un mensaje de error
        }
    }
    public void mostrarLibrosDisponibles() {// Muestra todos los libros que no están prestados.
        System.out.println("\n--- Lista de libros disponibles ---");
        boolean hayLibros = false;
        for (Libro libro : libros) {// Recorre la lista de libros
            if (!libro.isPrestado()) {// si el libro no está prestado, lo muestra con su ID, título y autor.
                System.out.println("ID: " + libro.getId() + " - Titulo: " + libro.getTitulo() + " - Autor: " + libro.getAutor());
                hayLibros = true;
            }
        }
        if (!hayLibros) {// Si no hay libros disponibles
            System.out.println(" No hay libros disponibles.");// imprime un mensaje indicando que no hay libros disponibles.
        }
    }
    public void mostrarUsuariosDisponibles() { // muestra todos los usuarios registrados en la biblioteca.
        System.out.println("\n--- Lista de usuarios disponibles ---");
        if (usuarios.isEmpty()) {
            System.out.println(" No hay usuarios registrados.");// Si no hay usuarios registrados, imprime un mensaje indicando que no hay usuarios
        } else {
            for (Usuario usuario : usuarios) {// de lo contrario, imprime la ID y el nombre de cada usuario
                System.out.println("ID: " + usuario.getId() + " - Nombre: " + usuario.getNombre());
            }
        }
    }
    public void mostrarUsuariosConLibrosPrestados() {// muestra los usuarios que tienen libros prestados.
        System.out.println("\n--- Lista de usuarios con libros prestados ---");
        boolean hayUsuariosConLibros = false;
        
        for (Usuario usuario : usuarios) {// recorre la lista de usuarios
            if (!usuario.getLibrosPrestados().isEmpty()) {// si un usuario tiene libros prestados
                System.out.println(" ID: " + usuario.getId() + " - Nombre: " + usuario.getNombre() + 
                                   " - Libros prestados: " + usuario.getLibrosPrestados().size());//muestra su ID, nombre y la cantidad de libros prestados.
                hayUsuariosConLibros = true;
            }
        }  
        if (!hayUsuariosConLibros) {// si no hay usuarios con libros prestados, imprime un mensaje indicándolo
            System.out.println("No hay usuarios con libros prestados.");
        }
    }
    public void mostrarLibrosPrestados(int idUsuario) {// muestra los libros prestados a un usuario específico.
        Usuario usuario = buscarUsuario(idUsuario);// busca al usuario por su ID
        
        if (usuario != null) {// si lo encuentra, muestra los libros que tiene prestados.
            System.out.println("\n--- Libros prestados al usuario " + usuario.getNombre() + " ---");
            if (!usuario.getLibrosPrestados().isEmpty()) {// si el usuario no tiene libros prestados, muestra un mensaje indicándolo
                for (Libro libro : usuario.getLibrosPrestados()) {
                    System.out.println("ID: " + libro.getId() + " - Titulo: " + libro.getTitulo() + " - Autor: " + libro.getAutor());
                }
            } else {
                System.out.println(" El usuario no tiene libros prestados.");
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }
    private Libro buscarLibro(int idLibro) {// busca un libro en la lista de libros por su ID
        for (Libro libro : libros) {// si lo encuentra, lo devuelve
            if (libro.getId() == idLibro) {
                return libro;
            }
        }
// Si no, devuelve null.
        return null;
    }
    private Usuario buscarUsuario(int idUsuario) { //busca un usuario en la lista de usuarios por su ID
        for (Usuario usuario : usuarios) {// Si lo encuentra, lo devuelve
            if (usuario.getId() == idUsuario) {
                return usuario;
            }
        }
// Si no, devuelve null.
        return null;
    }   
}