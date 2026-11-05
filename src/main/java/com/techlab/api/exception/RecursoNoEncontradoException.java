package com.techlab.api.exception;
/**
 * Excepción personalizada que se lanza cuando se busca un recurso por su id y no existe en el sistema
 *
 * hereda de RuntimeException (excepciones no chequeadas) no obliga a quien usa el método a envolver
 * la llamada en try/ catch, pero si permite capturarla cuando nos interesa.
 *
 **/

public class RecursoNoEncontradoException extends RuntimeException {
    public RecursoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}