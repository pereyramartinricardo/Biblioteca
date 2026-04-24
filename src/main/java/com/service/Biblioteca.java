package com.service;

import java.util.ArrayList;
import java.util.List;

import com.model.Libro;

/**
 * Gestiona la colección de libros de la biblioteca.
 * 
 * Permite agregar libros, buscar por titulos y obtener la lista completa.
 */
public class Biblioteca {
    private List<Libro> libros;

    /**
     * Crea una biblioteca con una lista vacia de libros.
     */
    public Biblioteca() {
        libros = new ArrayList<>();
    }

    /**
     * Agrega un libro a la biblioteca.
     * 
     * @param libro libro que se quiera agregar.
     */
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    /**
     * Busca libros cuyo titulo contenga el texto ingresado.
     * La busqueda no distingue entre mayusculas y minúsculas.
     * 
     * @param busqueda texto a buscar dentro del titulo
     * @return lista de libros que coinciden con la busqueda.
     */
    public List<Libro> buscarPorTitulo(String busqueda) {
        String texto = busqueda.toLowerCase();
        List<Libro> resultado = new ArrayList<>();

        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(texto)) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}