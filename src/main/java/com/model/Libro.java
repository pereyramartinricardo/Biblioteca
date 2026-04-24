package com.model;

/**
 * Representacion de un libro alojado en el sistema de biblioteca.
 * 
 * Contiene información como lo son el ISBN, título, autor/a, año de publicación y disponibilidad para préstamo.
 */
public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private int anio;
    private boolean disponible;

    /**
     * Constructor por defecto.
     * Crea un libro vacío con valores por defecto.
     * La disponibilidad se inicializa como verdadera.
     */
    public Libro () {
        this.ISBN = "";
        this.titulo = "";
        this.autor = "";
        this.anio = 0;
        this.disponible = true;
    }

    /**
     * Constructor parametizado.
     * Crea un libro con todos sus datos.
     * 
     * @param ISBN código identificador del libro.
     * @param titulo titulo del libro.
     * @param autor autor/a del libro.
     * @param disponible estado de disponibilidad del libro para el préstamo.
     */
    public Libro (String ISBN,String titulo,String autor,int anio,boolean disponible){
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.disponible = disponible;
    }

    public String getISBN() {
        return ISBN;
    }
    
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio () {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible (boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Devuelve una representación en texto del libro.
     * 
     * @return información completa del libro.
     */
    @Override
    public String toString() {
        return "Libro encontrado ISBN:" + ISBN + " Titulo: " + titulo + " Autor: " + autor + " ISBN: " + ISBN + " Año: " + anio + " Disponibilidad: " + disponible;
    }
}
