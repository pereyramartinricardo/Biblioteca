package com.exception;

/**
 * Excepción que sale cuando un estudiante llega al límite de prestamos.
 */
public class Limiteprestamo extends Exception {

    /**
     * Crea una excepción con un mensaje.
     * 
     * @param mensaje describe el error producido.
     */
    public Limiteprestamo (String mensaje) {
        super (mensaje);
    }

}
