package com.techlab.api.util;

import com.techlab.api.exception.StockInsuficienteException;
import com.techlab.api.model.Categoria;

import java.math.BigDecimal;

public class Validador {

    public static void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }

    public static void validarPrecio(BigDecimal precio) {
        if (precio == null) {
            throw new IllegalArgumentException("El precio es obligatorio.");
        }
        // compareTo devuelve un número negativo si precio es menor que cero
        if (precio.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
    }

    public static void validarStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
    }

    public static void validarStockDisponible(int stockActual, int cantidadPedida) {
        if (cantidadPedida <= 0) {
            throw new IllegalArgumentException("La cantidad pedida debe ser mayor a cero.");
        }
        if (stockActual < cantidadPedida) {
            throw new StockInsuficienteException(
                    "Stock insuficiente. Disponible: " + stockActual + ", pedido: " + cantidadPedida);
        }
    }

    public static void validarCategoria(Categoria categoria) {
        if (categoria == null || categoria.getId() == null) {
            throw new IllegalArgumentException("La categoría es obligatoria.");
        }
    }


}
