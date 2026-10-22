package com.techlab.api.controller;

import com.techlab.api.model.Producto;
import com.techlab.api.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/productos") // prefijo común ara todas las rutas de este controlador
public class ProductoController {

    private final ProductoService productoService;

    // Inyección por constructor, con un único constructor.
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // GET /productos -> devuelve la lista de productos
    @GetMapping
    public List<Producto> listar() {
        return productoService.listarTodos();
    }

    // POST /productos -> @RequestBody convierte el JSON del cuerpo en un Producto
    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto p) {
         Producto nuevo = productoService.agregar(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);   // 201
    }


}


