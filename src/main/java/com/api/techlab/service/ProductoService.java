package com.api.talentolab.service;

import com.api.talentolab.exception.ProductoNoEncontradoException;
import com.api.talentolab.model.Producto;
import com.api.talentolab.util.Validador;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio que contiene la lógica de negocio.
 * Gestiona la lista de productos en memoria.
 **/
public class ProductoService {
    private List<Producto> productos = new ArrayList<>();

    /**
     * Contador para asignar id`s únicos.
     * Es static, perteneciendo a la clase y no a una instancia, garantizando que el 'id' sea único.
     */
    private static Long contadorId = 1L;

    /**
     * CREATE: Agrega un nuevo producto. La validación de datos se hace en Main.
     */
    public Producto agregar(Producto p) {
        // valida datos antes de aplicarlos
        Validador.validarNombre(p.getNombre());
        Validador.validarPrecio(p.getPrecio());
        Validador.validarStock(p.getStock());
        Validador.validarCategoria(p.getCategoria());

        p.setId(contadorId); // el 'id' lo asigna el servicio, no el usuario.
        contadorId++;

        productos.add(p); // guarda el producto

        return p;
    }

    /**
     * READ: devuelve toda la lista de productos.
     */
    public List<Producto> listarTodos(){
        return productos;
    }

    /**
     * READ: Busca un producto por ID.
     * Si no existe, lanza una exception — nunca devuelve null.
     */
    public Producto buscarPorId(Long id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        throw new ProductoNoEncontradoException("No se encontró un producto con el id: " + id);
    }

    /**
     * UPDATE: Actualiza un producto.
     * Usa buscarPorId — si no existe, la excepción se propaga sola.
     */
    public Producto actualizar(Long id, Producto datos) {
        Producto p = buscarPorId(id); // si el "id" no existe, se corta en el throw

        // valida datos antes de aplicarlos
        Validador.validarNombre(datos.getNombre());
        Validador.validarPrecio(datos.getPrecio());
        Validador.validarStock(datos.getStock());
        Validador.validarCategoria(datos.getCategoria());

        // modifica el producto
        p.setNombre(datos.getNombre());
        p.setPrecio(datos.getPrecio());
        p.setStock(datos.getStock());
        p.setCategoria(datos.getCategoria());

        return p;
    }

    /**
     * DELETE: Elimina un producto por ID.
     * Usa buscarPorId — si no existe, la excepción se propaga sola.
     */
    public void eliminar(Long id) {
        Producto p = buscarPorId(id);
        productos.remove(p);
    }

}
