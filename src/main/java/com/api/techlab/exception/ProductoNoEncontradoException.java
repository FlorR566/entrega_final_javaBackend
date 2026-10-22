package com.api.talentolab.exception;

/**
 * Excepción personalizada que se lanza cuando se busca un producto por su id y no existe en el sistema
 *
 * hereda de RuntimeException (excepciones no chequeadas) no obliga a quien usa el método a envolver
 * la llamada en try/ catch, pero si permite capturarla cuando nos interesa.
 *
 **/

public class ProductoNoEncontradoException extends RuntimeException {
    public ProductoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
