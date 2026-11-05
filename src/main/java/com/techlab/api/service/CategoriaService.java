package com.techlab.api.service;

import com.techlab.api.exception.ElementoDuplicadoException;
import com.techlab.api.exception.RecursoNoEncontradoException;
import com.techlab.api.model.Categoria;
import com.techlab.api.repository.CategoriaRepository;
import com.techlab.api.repository.ProductoRepository;
import com.techlab.api.util.Validador;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;
    private final ProductoRepository productoRepository;


    // inyección de dependencias
    public CategoriaService(CategoriaRepository repository, ProductoRepository productoRepository) {
        this.repository = repository;
        this.productoRepository = productoRepository;
    }

    // GET /categorias
    public List<Categoria> listarTodas() {
        return repository.findAll();
    }

    // GET /categoria/{id}
    public Categoria buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró una categoria con el id: " + id));
    }

    // POST /categorias
    public Categoria agregar(Categoria c) {
        Validador.validarNombre(c.getNombre());

        // validamos si ya existe una categoría con el mismo nombre
        repository.findByNombreIgnoreCase(c.getNombre()).ifPresent(existente -> {
            throw new ElementoDuplicadoException("Ya existe una categoría con el nombre: " + existente.getNombre());
        });

        return repository.save(c);
    }


    // PUT /categorias{id}
    public Categoria actualizar(Long id, Categoria datos) {
        Categoria c = buscarPorId(id); // si el ID no existe, se corta con el throw

        Validador.validarNombre(datos.getNombre());
        // valida que no exista un nombre igual en la DB
        repository.findByNombreIgnoreCase(datos.getNombre()).ifPresent(existente -> {
            if(!existente.getId().equals(id)) {
                throw new ElementoDuplicadoException("Ya existe una categoria con el nombre: " +  existente.getNombre());
            }
        });

        // modifica la categoría
        c.setNombre(datos.getNombre());

        return repository.save(c);
    }

    // DELETE /categorias/{id}
    public void eliminar(Long id) {
        Categoria c = buscarPorId(id);

        // restricción: no se pueden eliminar categorías con productos asociados
        if (productoRepository.existsByCategoriaId(id)) {
            throw new IllegalStateException("No se puede eliminar la categoria porque tiene productos asociados.");
        }
        repository.delete(c); // elimina de la DB (no es baja lógica)
    }

}
