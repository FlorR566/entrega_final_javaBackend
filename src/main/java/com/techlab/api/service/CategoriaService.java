package com.techlab.api.service;

import com.techlab.api.exception.RecursoNoEncontradoException;
import com.techlab.api.model.Categoria;
import com.techlab.api.repository.CategoriaRepository;
import com.techlab.api.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;
    private final ProductoRepository productoRepository ;

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





}
