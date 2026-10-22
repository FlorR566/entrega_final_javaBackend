package com.techlab.api.exception;

/**
 * Excepción personalizada que se lanza cuando se intenta asignar un stock inválid (ej: un valor negativo)
 **/
public class StockInsuficienteException extends RuntimeException{
    public StockInsuficienteException(String message) {
        super(message);
    }
}
