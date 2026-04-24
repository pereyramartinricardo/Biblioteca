package com.model;

import java.time.LocalDate;

/**
 * Representación de un préstamo realizado en la biblioteca.
 * 
 * Relaciona un libro con un estudiante e incluye la fecha de préstamo y la fecha de devolución.
 */
public class Prestamo {
    private Libro libro;
    private Estudiante estudiante;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    /**
     * Constructor por defecto.
     * Crea un préstamo vacío.
     */
    public Prestamo () {
    }

    /**
     * Constructor parametizado.
     * Crea un prestamo con todos sus datos.
     * 
     * @param libro libro prestado.
     * @param estudiante estudiante que solicita el prestamo.
     * @param fechaPrestamo fecha en la que se realiza el prestamo.
     * @param fechaDevolucion fecha en la que se devuelve el libro.
     */
    public Prestamo (Libro libro, Estudiante estudiante, LocalDate fechaPrestamo, LocalDate fechaDevolucion){
        this.libro = libro;
        this.estudiante = estudiante;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
}
