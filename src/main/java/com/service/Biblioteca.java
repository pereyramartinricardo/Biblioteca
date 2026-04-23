package com.service;

import java.util.ArrayList;
import java.util.List;

import com.model.Libro;

public class Biblioteca {
    private List<Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

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