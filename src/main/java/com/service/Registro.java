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

/**
 * Administra los estudiantes y prestamos de la biblioteca.
 * 
 * Permite registrar estudiantes, obtener estudiantes por medio del legajo, registrar prestamos, registrar devoluciones, y calcular multas.
 */
public class Registro {
    private Map<String,Estudiante> estudiantes = new HashMap<>();
    private List<Libro> libros = new ArrayList<>();
    private Set<Prestamo> prestamos = new HashSet<>();

    /**
     * Crea un registro asociado a una lista de libros.
     * 
     * @param libros lista de libros disponibles en la biblioteca.
     */
    public Registro(List<Libro> libros){
        this.libros = libros;
    }

    /**
     * Agrega un estudiante al registro utilizando su legajo como clave.
     * 
     * @param e estudiante que se desea registrar.
     */
    public void agregarEstudiante(Estudiante e){
        estudiantes.put(e.getLegajo(),e);
    }

    /**
     * Busca un estudiante por su legajo.
     * 
     * @param legajo legajo del estudiante buscado.
     * @return estudiante encontrado.
     * @throws Estudiantefalso estudiante inexistente.
     */
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

    /**
     * Registra el prestamo de un libro a un estudiante.
     * 
     * @param ISBN ISBN del libro solicitado.
     * @param legajo legajo del estudiante que se solicita el prestamo.
     * @throws Libronodisponible si el libro no esta disponible.
     * @throws Estudiantefalso si el estudiante no existe.
     * @throws Limiteprestamo si el estudiante llego al limite de prestamos permitidos.
     */
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

    /**
     * Calcular una multa de forma recursiva segun los días de demora.
     * 
     * La multa amenta un 1% del valor indicado por cada día de retraso.
     * Un maximo de 30 días.
     * 
     * @param dias cantidad de días de retraso.
     * @param valor valor base utilizado para calcular la multa.
     * @return monto total de la multa.
     */
    public double calcularMulta(int dias,double valor){
        if (dias <=0) return 0;
        if (dias>=30) dias = 30;
        return valor * 0.01 + calcularMulta(dias-1, valor);
    }

    /**
     * Registra la devolución de un libro y calcula la multa correspondiente.
     * 
     * @param ISBN ISBN del libro devuelto.
     * @param diaRetraso cantidad de días retrasados.
     * @param valor valor base para calcula la multa.
     * @return monto de la multa calculada; retorna 0 si no se encuentra el prestamo.
     */
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
