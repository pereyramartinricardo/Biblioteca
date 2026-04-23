package com.service;

import com.model.Estudiante;
import com.model.Libro;
import com.model.Prestamo;
import com.exception.*;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Registro {
    private Map<String,Estudiante> estudiantes = new HashMap<>();
    private List<Libro> libros = new ArrayList<>();
    private Set<Prestamo> prestamos = new HashSet<>();
    public Registro(List<Libro> libros){
        this.libros = libros;
    }
    public void agregarEstudiante(Estudiante e){
        estudiantes.put(e.getLegajo(),e);
    }
    public Estudiante obtenerEstudiante (String legajo) throws Estudiantefalso {
        Estudiante e = estudiantes.get(legajo);
        if (e == null){
            throw new Estudiantefalso("No existe estudiante con legajo: "+legajo);
        }
        return e;
    }
    public void mostrarEstudiantes (){
        estudiantes.values().forEach(System.out :: println);
    }
    public void registrarPrestamo(String ISBN, String legajo) throws Libronodisponible, Estudiantefalso,Limiteprestamo{
        Libro libro = libros.stream().filter(librox->librox.getISBN().equals(ISBN)).findFirst().orElse(null);
        Estudiante e = estudiantes.get(legajo);
        if (e==null)throw new Estudiantefalso("No existe el estudiante en el legajo");
        if (libro==null || !libro.isDisponible()) throw new Libronodisponible("El libro no esta disponible");
        int contadorPrestamos = (int) prestamos.stream().filter(p -> p.getEstudiante().getLegajo().equals(e.getLegajo())).count();
        if (contadorPrestamos >= 3) throw new Limiteprestamo("Se alcanzo maximo de prestamos");

        Prestamo prestamo = new Prestamo(libro,e,LocalDate.now(), null);
        prestamos.add(prestamo);
        libro.setDisponible(false);
        
    }
    public double calcularMulta(int dias,double valor){
        if (dias <=0) return 0;
        if (dias>=30) dias = 30;
        return valor * 0.01 + calcularMulta(dias-1, valor);
    }

    public double registrarDevolucion(String ISBN, int diaRetraso, double valor) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getLibro().getISBN().equals(ISBN)) {
                prestamo.setFechaDevolucion(LocalDate.now());
                prestamo.getLibro().setDisponible(true);
                return calcularMulta(diaRetraso, valor);
            }
        }
        return 0;
    }


}
