package com.techlab.api.exception;

/**
 * Excepción personalizada que se lanza cuando se intenta crear un producto nuevo
 * y ya existe otro igual en la base.
 */
public class ElementoDuplicadoException extends RuntimeException {
    public ElementoDuplicadoException(String mensaje) {
        super(mensaje);
    }
}
