package com.api.talentolab.util;

import com.api.talentolab.exception.StockInsuficienteException;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase con métodos de validación reutilizables.
 * Todos los métodos son estáticos, no necesitan de una instancia de validador para usarlos.
 *
 **/
public class Validador {

    // Privatizamos el constructor para evitar instanciaciones innecesarias
    private Validador(){}

    // validar nombre
    public static void validarNombre(String nombre){
        // Un nombre vacío no representa un producto válido
        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }

    // validar precio
    public static void validarPrecio(double precio){
        // no sean negativos
        // acepta 0
        if (precio < 0){
            throw new  IllegalArgumentException("El precio no puede ser negativo.");
        }
    }

    // validad stock
    public static void validarStock(int stock){
        // no acepta stock negativo
        // usa excepción personalizada
        if(stock < 0){
            throw new StockInsuficienteException("El stock no puede ser negativo.");
        }
    }

    // validar categoría
    public static void validarCategoria(String categoria){
        // una categoría vacía no representa a una categoria
        if (categoria == null || categoria.isBlank()){
            throw new IllegalArgumentException("La categoría no puede estar vacía.");
        }
    }

    // Lectura por consola
    public static int leerEntero(Scanner sc, String mensaje){
        // bucle infinito que se rompe cuando el usuario ingresa un entero válido
        while(true){
            System.out.print(mensaje);
            try {
                int valor = sc.nextInt();
                sc.nextLine(); // limpia el salto de línea pendiente
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número entero. Inténtelo nuevamente.");
                sc.nextLine(); // limpia el salto de línea pendiente
            }
        }
    }

    public static double leerDecimal(Scanner sc, String mensaje){
        while(true){
            System.out.print(mensaje);
            try {
                double valor = sc.nextDouble();
                sc.nextLine();
                return valor;
            } catch (Exception e) {
                System.out.println("Debe ingresar un número decimal (con punto)");
                sc.nextLine();
            }
        }
    }

    public static String leerTexto(Scanner sc, String mensaje){
        // lectura simple de texto
        System.out.print(mensaje);
        return  sc.nextLine();
    }


}
