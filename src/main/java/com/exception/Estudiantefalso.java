package com.exception;

/**
 * Excepción que sale cuando se intenta acceder a un estudiante inexistente.
 */
public class Estudiantefalso extends Exception {

    /**
     * Crea una excepción con un mensaje.
     * 
     * @param mensaje describe el error producido.
     */
    public Estudiantefalso (String mensaje){
        super(mensaje);
    }

}
