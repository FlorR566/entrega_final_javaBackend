package com.api.talentolab.ui;

import com.api.talentolab.model.Producto;
import com.api.talentolab.service.ProductoService;
import com.api.talentolab.util.Validador;

import java.util.List;
import java.util.Scanner;

/**
 * Mejora la interacción con el usuario, muestra el menú, lee datos, muestra mensajes de error o éxito.
 */
public class MenuProducto {
    // El scanner y el service se reciben por constructor, no se crean en esta clase
    private final Scanner sc;
    private final ProductoService service;


    // Inyección por constructor: patrón utilizado en Spring Boot
    public MenuProducto(Scanner sc, ProductoService service) {
        this.sc = sc;
        this.service = service;
    }

    // Menu principal

    public void mostrarMenu() {
        System.out.println("======= TalentoLab - Gestión de Productos =======");
        System.out.println("1) Agregar producto");
        System.out.println("2) Listar productos");
        System.out.println("3) Buscar producto por ID");
        System.out.println("4) Actualizar producto");
        System.out.println("5) Eliminar producto");
        System.out.println("6) Salir");
        System.out.println("==============================================");
    }

    // Operaciones CRUD

    public void agregarProducto() {
        System.out.println("--- Nuevo producto ---");
        String nombre = Validador.leerTexto(sc, "Nombre: ");
        double precio = Validador.leerDecimal(sc, "Precio: ");
        int stock = Validador.leerEntero(sc, "Stock: ");
        String categoria = Validador.leerTexto(sc, "Categoría: ");

        // Construimos el producto
        Producto p = new Producto(nombre,precio,stock,categoria);
        // Lo enviamos al servicio
        Producto guardado = service.agregar(p); // El servicio valida y asigna el id

        System.out.println("Producto agregado, id: " + guardado.getId());
    }

    public void listarProductos() {
        List<Producto> lista = service.listarTodos();

        if (lista.isEmpty()) {
            System.out.println("No hay productos cargados.");
        }

        System.out.println("--- Catálogo ---");
        for (Producto p : lista) {
            p.mostrar();
        }
    }

    public void buscarProducto() {
        Long id = (long) Validador.leerEntero(sc, "Ingrese el id del producto: ");
        Producto p =  service.buscarPorId(id);
        System.out.println("Encontrado: " + p);
    }

}
