package com.techlab.api.util;

import com.techlab.api.exception.StockInsuficienteException;

import java.math.BigDecimal;

public class Validador {

    public static void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }

    public static void validarPrecio(BigDecimal precio) {
        if (precio == null) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        // compareTo devuelve un número negativo si precio es menor que cero
        if (precio.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
    }

    public static void validarStock(int stock) {
        if (stock < 0) {
            throw new StockInsuficienteException("El stock no puede ser negativo.");
        }
    }

    public static void validarCategoria(String categoria) {
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("El categoria no puede estar vacía.");
        }
    }


}
