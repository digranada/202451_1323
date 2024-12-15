/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author Granada David
 */
import java.util.InputMismatchException;// Maneja excepciones cuando el tipo de entrada no coincide con el tipo esperado
import java.util.Scanner;// usa para leer la entrada del usuario desde la consola


public class Main {// clase principal que ejecuta el programa
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();//crea una instancia de la clase Biblioteca
        Scanner scanner = new Scanner(System.in);// crea un objeto Scanner llamado scanner para leer la entrada del usuario desde la consola.
        int opcion = 0;// guarda la opcion seleccionada por el usuario en el menu


// se muestra un menu de opciones para que el usuario elija una accion que desea realizar en la biblioteca
        do {
            System.out.println("\n--- Menu de la Biblioteca ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Mostrar libros disponibles");
            System.out.println("6. Mostrar usuarios con libros prestados");
            System.out.println("7. Salir");
            System.out.print("Ingrese una opcion: ");// solicita al usuario que ingrese una opcion


            try {
                opcion = scanner.nextInt();//leer un numero entero introducido por el usuario, que se asigna a la variable opcion
                scanner.nextLine(); // Limpiar el buffer de entrada
            } catch (InputMismatchException e) {//si el usuario ingresa algo diferente a un numero se captura la excepcion, muestra un mensaje de error y permite que el usuario ingrese nuevamente la opcion.
                System.out.println("Opcion no valida, debe ser un numero.");
                scanner.nextLine(); // Limpiar el buffer de entrada
                continue;  
            }


            switch (opcion) {
                case 1: // pide que ingrese el titulo y el autor del libro
                    System.out.print("Ingrese el titulo del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    biblioteca.agregarLibro(titulo, autor);// llama al metodo agregarLibro de la clase Biblioteca
                    break;


                case 2: // pide que ingrese el nombre del usuario
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombre = scanner.nextLine();
                    biblioteca.registrarUsuario(nombre);// llama al metodo registrarUsuario de la clase Biblioteca para registrar al nuevo usuario.
                    System.out.println(" Usuario registrado exitosamente.");
                    break;


                case 3:
                    System.out.println("\n--- Lista de usuarios ---");
                    biblioteca.mostrarUsuariosDisponibles();//muestra la lista de usuarios registrados
                    
                    try {
                        System.out.print("\nIngrese el ID del usuario que tomara el libro: ");
                        int idUsuarioPrestar = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer de entrada
                        
                        System.out.println("\n--- Lista de libros disponibles ---");
                        biblioteca.mostrarLibrosDisponibles(); // muestra la lista libros disponibles
                        
                        System.out.print("\nIngrese el ID del libro a prestar: ");
                        int idLibroPrestar = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer de entrada
                        
                        biblioteca.prestarLibro(idUsuarioPrestar, idLibroPrestar);// llama al metodo prestarLibro de la clase Biblioteca con los Ids proporcionados
                        System.out.println("Libro prestado exitosamente.");
                    } catch (InputMismatchException e) {// Si ocurre un error se captura la excepcion y se muestra un mensaje de error
                        System.out.println("Error: El ID debe ser un numero.");
                        scanner.nextLine(); // Limpiar el buffer de entrada
                    }
                    break;


                case 4:
                    System.out.println("\n--- Lista de usuarios con libros prestados ---");
                    biblioteca.mostrarUsuariosConLibrosPrestados();// muestra la lista de usuarios que tienen libros prestados 
                    
                    try {
                        System.out.print("\nIngrese el ID del usuario que devolvera el libro: ");
                        int idUsuarioDevolver = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer de entrada
                        
                        System.out.println("\n--- Lista de libros prestados ---");
                        biblioteca.mostrarLibrosPrestados(idUsuarioDevolver);
                        
                        System.out.print("\nIngrese el ID del libro a devolver: ");
                        int idLibroDevolver = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer de entrada
                        
                        biblioteca.devolverLibro(idUsuarioDevolver, idLibroDevolver);// llama al metodo devolverLibro de la clase Biblioteca con los IDs proporcionados
                        System.out.println("Libro devuelto exitosamente.");
                    } catch (InputMismatchException e) {// Si ocurre un error se captura la excepcion y se muestra un mensaje de error

                        System.out.println("Error: El ID debe ser un numero.");
                        scanner.nextLine(); // Limpiar el buffer de entrada
                    }
                    break;


                case 5:
                    System.out.println("\n--- Lista de libros disponibles ---");
                    biblioteca.mostrarLibrosDisponibles();//llama al metodo mostrarLibrosDisponibles de la clase Biblioteca, que muestra la lista de libros que no estan prestados
                    break;


                case 6:
                    biblioteca.mostrarUsuariosConLibrosPrestados();//llama al metodo mostrarUsuariosConLibrosPrestados de la clase Biblioteca, que muestra la lista de usuarios que tienen libros prestados
                    break;

                case 7:// imprime un mensaje de salida y se termina el ciclo do-while.
                    System.out.println("Saliendo...");
                    break;
                    
                default:
                    System.out.println("Opcion no valida.");// Si se ingresa una opcion que no es valida, se muestra un mensaje de error
            }
        } while (opcion != 7);
        scanner.close();//cierra el objeto scanner para liberar los recursos asociados.
    }
}