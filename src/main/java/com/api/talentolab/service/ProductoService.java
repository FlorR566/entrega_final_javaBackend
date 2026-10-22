package com.api.talentolab.service;

import com.api.talentolab.exception.ProductoNoEncontradoException;
import com.api.talentolab.model.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio que contiene la lógica de negocio.
 * Gestiona la lista de productos en memoria.
 **/
public class ProductoService {
    private List<Producto> productos = new ArrayList<>();

    /**
     * Agrega un nuevo producto. La validación de datos se hace en Main.
     */
    public void agregar(String nombre, double precio, int stock, String categoria) {
        Producto nuevo = new Producto(nombre, precio, stock, categoria);
        productos.add(nuevo);
        System.out.println("Producto agregado: " + nuevo);
    }

    /**
     * Lista todos los productos. Si no hay ninguno, avisa.
     */
    public void listar() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos cargados.");
            return;
        }
        System.out.println("\n--- Listado de productos ---");
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    /**
     * Busca un producto por ID.
     * Si no existe, lanza ProductoNoEncontrado — nunca devuelve null.
     */
    public Producto buscarPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        // Si llegamos acá es porque no lo encontramos
        throw new ProductoNoEncontradoException("No se encontró ningún producto con id: " + id);
    }

    /**
     * Actualiza un producto por ID.
     * Usa buscarPorId — si no existe, la excepción se propaga sola.
     */
    public void actualizarPorId(int id, String nombre, double precio, int stock, String categoria) {
        Producto p = buscarPorId(id); // si el "id" no existe, se corta en el throw
        p.setNombre(nombre);
        p.setPrecio(precio);
        p.setStock(stock);
        p.setCategoria(categoria);
        System.out.println("Producto actualizado: " + p);
    }

    /**
     * Elimina un producto por ID.
     * Usa buscarPorId — si no existe, la excepción se propaga sola.
     */
    public void eliminar(int id) {
        Producto p = buscarPorId(id);
        productos.remove(p);
        System.out.println("Producto eliminado: " + p.getNombre());
    }

}
