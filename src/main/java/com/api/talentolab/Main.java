package com.api.talentolab;

import com.api.talentolab.exception.ProductoNoEncontradoException;
import com.api.talentolab.model.Producto;
import com.api.talentolab.service.ProductoService;
import com.api.talentolab.util.Validador;

import java.util.Scanner;

public class Main {

    private static final String MENU = """

            ¿Qué querés hacer?
            1. Agregar producto
            2. Listar productos
            3. Buscar por ID
            4. Actualizar producto
            5. Eliminar por ID
            0. Salir
            """;

    public static void main(String[] args) {
        ProductoService servicio = new ProductoService();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== GESTIÓN DE PRODUCTOS ===");

            int opcion;
            do {
                System.out.println(MENU);
                opcion = Validador.leerEntero(sc, "Opción: ");

                try {
                    ejecutar(opcion, sc, servicio);
                } catch (ProductoNoEncontradoException | IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } while (opcion != 0);
        }
    }

    private static void ejecutar(int opcion, Scanner sc, ProductoService servicio) {
        switch (opcion) {
            case 1 -> agregarProducto(sc, servicio);
            case 2 -> servicio.listar();
            case 3 -> buscarProducto(sc, servicio);
            case 4 -> actualizarPorId(sc, servicio);
            case 5 -> eliminarProducto(sc, servicio);
            case 0 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción no válida. Elegí entre 0 y 4.");
        }
    }

    private static void agregarProducto(Scanner sc, ProductoService servicio) {
        String nombre = Validador.leerTexto(sc, "Ingresá el nombre del producto: ");
        Validador.validarNombre(nombre);

        double precio = Validador.leerDecimal(sc, "Ingresá el precio: ");
        Validador.validarPrecio(precio);

        int stock = Validador.leerEntero(sc, "Ingresá el stock: ");
        Validador.validarStock(stock);

        String categoria = Validador.leerTexto(sc, "Ingresá la categoría: ");
        Validador.validarCategoria(categoria);

        servicio.agregar(nombre, precio, stock, categoria);
    }

    private static void buscarProducto(Scanner sc, ProductoService servicio) {
        int id = Validador.leerEntero(sc, "ID a buscar: ");
        Producto p = servicio.buscarPorId(id);
        System.out.println("Encontrado: " + p);
    }

    private static void actualizarPorId(Scanner sc, ProductoService servicio) {
        int id = Validador.leerEntero(sc, "ID a actualizar: ");
        Producto p = servicio.buscarPorId(id);

        int dato = Validador.leerEntero(sc, """ 
                ¿Cuál es el dato que querés actualizar? 
                1. Nombre
                2. Precio
                3. Stock
                4. Categoria
                5. Salir
                """);

        switch (dato) {
            case 1:
                String nombre = Validador.leerTexto(sc, "Ingresá el nuevo nombre: ");
                Validador.validarNombre(nombre);
                servicio.actualizarPorId(id, nombre, p.getPrecio(), p.getStock(), p.getCategoria());
                return;
            case 2:
                double precio = Validador.leerDecimal(sc, "Ingresá e nuevo precio: ");
                Validador.validarPrecio(precio);
                servicio.actualizarPorId(id, p.getNombre(),precio, p.getStock(), p.getCategoria());
                return;
            case 3:
                int stock = Validador.leerEntero(sc, "Ingresá el nuevo stock: ");
                Validador.validarStock(stock);
                servicio.actualizarPorId(id, p.getNombre(), p.getPrecio(), stock, p.getCategoria());
                return;
            case 4:
                String categoria = Validador.leerTexto(sc, "Ingresá la nueva categoria: ");
                Validador.validarCategoria(categoria);
                servicio.actualizarPorId(id, p.getNombre(), p.getPrecio(), p.getStock(), categoria);
                return;
            case 5:
                System.out.println("Saliendo...");
                return;
            default: System.out.println("Opción no válida. Elegí entre 1 y 5.");
        }
    }

    private static void eliminarProducto(Scanner sc, ProductoService servicio) {
        int id = Validador.leerEntero(sc, "ID a eliminar: ");
        servicio.eliminar(id);
    }
}
