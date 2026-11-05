package com.techlab.api.controller;

import com.techlab.api.model.Categoria;
import com.techlab.api.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // GET /categorias <- devuelve una lista de categorias
    @GetMapping
    public ResponseEntity<List<Categoria>> listar() {
        return ResponseEntity.ok(categoriaService.listarTodas());  // 200
    }

    // GET /categorias/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.buscarPorId(id));  // 200
    }

    // POST /categorias
    @PostMapping
    public ResponseEntity<Categoria> crear(@RequestBody Categoria c) {
        Categoria nuevo = categoriaService.agregar(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);   // 201
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(@PathVariable Long id, @RequestBody Categoria datos) {
        return ResponseEntity.ok(categoriaService.actualizar(id, datos)); // 200
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        categoriaService.eliminar(id);
        return ResponseEntity.noContent().build(); // 204
    }
}
