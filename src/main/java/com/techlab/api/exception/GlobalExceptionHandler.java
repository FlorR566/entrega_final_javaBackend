package com.techlab.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // atiende los errores de todos los controladores
public class GlobalExceptionHandler {

    // si algún método lanza ProductoNoEncontradoException, se ejecuta este
    @ExceptionHandler(ProductoNoEncontradoException.class)
    public ResponseEntity<String> manejarNoEncontrado(ProductoNoEncontradoException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());    // 404
    }

    // Stock negativo: dato inválido enviado por el cliente
    @ExceptionHandler(StockInsuficienteException.class)
    public ResponseEntity<String> manejarStock(StockInsuficienteException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());  // 400
    }

    // Nombre, precio o categoria inválidos (los lanza Validador)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> manejarArgumentoInvalido(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());  // 400
    }

    // cuando se intenta crear un producto y ya existe otro igual
    @ExceptionHandler(ElementoDuplicadoException.class)
    public ResponseEntity<String> manejarElementoDuplicado(ElementoDuplicadoException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());    // 409
    }


}
