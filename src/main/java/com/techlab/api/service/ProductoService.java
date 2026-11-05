package com.techlab.api.service;


import com.techlab.api.exception.ElementoDuplicadoException;
import com.techlab.api.exception.ProductoNoEncontradoException;
import com.techlab.api.model.Producto;
import com.techlab.api.repository.CategoriaRepository;
import com.techlab.api.repository.ProductoRepository;
import com.techlab.api.util.Validador;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service   // indica que esta clase es un servicio de Spring y permite que sea inyectada en otros componentes
public class ProductoService {

    private final ProductoRepository repository;
    private final CategoriaRepository categoriaRepository;

    // inyección de dependencias
    public ProductoService(ProductoRepository repository, CategoriaRepository categoriaRepository) {
        this.repository = repository;
        this.categoriaRepository = categoriaRepository;
    }

    // OPERACIONES CRUD ( create , read , update , delete)

    /**
     *  READ: Devuelve toda la lista de productos.
     */
    // GET /productos
    public List<Producto> listarTodos() {
        return repository.findAll();
    }

    /**
     * READ: Busca un producto por ID. Si no existe, lanza una exception — nunca devuelve null.
     */
    // GET /productos/{id}
    public Producto buscarPorId(Long id) {
        Optional<Producto> producto = repository.findById(id);
        if (producto.isEmpty()) {
            throw new ProductoNoEncontradoException("No se encontró un producto con el id: " + id);
        }
        return producto.get();
    }



//
//    /**
//     * POST: Agrega un nuevo producto. La validación de datos se hace en Main.
//     */
//    public Producto agregar(Producto p) {
//        // primero validamos si ya existe un producto con el mismo nombre guardado
//        boolean existeNombre = productos.stream()
//                .anyMatch(producto -> producto.getNombre().equalsIgnoreCase(p.getNombre()));
//
//        if (existeNombre) {
//            throw new ElementoDuplicadoException("Ya existe un producto con el nombre: " + p.getNombre());
//        }
//
//        // si llega acá, significa que no existe en la base
//        // validamos datos antes de aplicarlos
//        Validador.validarNombre(p.getNombre());
//        Validador.validarPrecio(p.getPrecio());
//        Validador.validarStock(p.getStock());
//        Validador.validarCategoria(p.getCategoria());
//
//        p.setId(contadorId); // el 'id' lo asigna el servicio, no el usuario.
//        contadorId++;
//
//        productos.add(p); // guarda el producto
//
//        return p;
//    }

//
//    /**
//     * UPDATE: Actualiza un producto.
//     * Usa buscarPorId — si no existe, la excepción se propaga sola.
//     */
//    public Producto actualizar(Long id, Producto datos) {
//        Producto p = buscarPorId(id); // si el "id" no existe, se corta en el throw
//
//        // valida datos antes de aplicarlos
//        Validador.validarNombre(datos.getNombre());
//        Validador.validarPrecio(datos.getPrecio());
//        Validador.validarStock(datos.getStock());
//        Validador.validarCategoria(datos.getCategoria());
//
//        // modifica el producto
//        p.setNombre(datos.getNombre());
//        p.setPrecio(datos.getPrecio());
//        p.setStock(datos.getStock());
//        p.setCategoria(datos.getCategoria());
//
//        return p;
//    }
//
//    /**
//     * DELETE: Elimina un producto por ID.
//     * Usa buscarPorId — si no existe, la excepción se propaga sola.
//     */
//    public void eliminar(Long id) {
//        Producto p = buscarPorId(id);
//        productos.remove(p);
//    }


}

