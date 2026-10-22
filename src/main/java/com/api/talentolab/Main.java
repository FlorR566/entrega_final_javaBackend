package com.api.talentolab;

import com.api.talentolab.exception.ProductoNoEncontradoException;
import com.api.talentolab.exception.StockInsuficienteException;
import com.api.talentolab.model.Producto;
import com.api.talentolab.service.ProductoService;
import com.api.talentolab.ui.MenuProducto;
import com.api.talentolab.util.Validador;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // se crean las dependencias una sola vez y luego se comparten durante toda la ejecución del programa.
        ProductoService service = new ProductoService();
        Scanner sc = new Scanner(System.in);
        MenuProducto menu = new MenuProducto(sc, service);
        cargarDatosDePrueba(service);

        int opcion;

        /**
         *  Cada opción del menú está envuelta en try/catch.
         *  Si una operación lanza una excepción (producto
         *  inexistente, datos inválidos, etc.), el programa NO
         *  se cae: muestra el mensaje y vuelve a mostrar el menú.
         */
        do {
            menu.mostrarMenu();
            opcion = Validador.leerEntero(sc, "Elija una opción: ");
            try {
                switch (opcion) {
                    case 1 -> menu.agregarProducto();
                    case 2 -> menu.listarProductos();
                    case 3 -> menu.buscarProducto();
                    case 4 -> menu.actualizarProducto();
                    case 5 -> menu.eliminarProducto();
                    case 6 -> System.out.println("¡Hasta luego!");
                    default -> System.out.println("Opción inválida. Elija un número del 1 al 6.");
                }
            } catch (ProductoNoEncontradoException | StockInsuficienteException e) {
                // captura las excepciones personalizadas
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                // Validador de datos genericos invalidos (nombre, precio negativo, etc...)
                System.out.println(e.getMessage());
            }
        } while (opcion != 6);

        sc.close();
    }

    // Datos de prueba:
    private static void cargarDatosDePrueba(ProductoService service) {
        service.agregar(new Producto("Café molido 500g", 4500, 30, "Bebidas"));
        service.agregar(new Producto("Yerba mate 1kg", 3200, 50, "Bebidas"));
        service.agregar(new Producto("Galletitas dulces", 1850, 100, "Almacén"));
        service.agregar(new Producto("Aceite de oliva 500ml", 6700, 20, "Almacén"));
        service.agregar(new Producto("Chocolate amargo 70%", 2900, 15, "Golosinas"));
        System.out.println("\nNOTA: ✔ Se cargaron 5 productos de prueba.\n");
    }

}
