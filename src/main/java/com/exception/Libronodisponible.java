package com.exception;

/**
 * Excepción que sale cuando se intenta acceder a un libro inexistente o que no esta disponible.
 */
public class Libronodisponible extends Exception{

    /**
     * Crea una excepción con un mensaje.
     * 
     * @param mensaje describe el error producido.
     */
    public Libronodisponible(String mensaje){
        super(mensaje);
    }

}
