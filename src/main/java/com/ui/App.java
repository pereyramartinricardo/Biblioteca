package com.ui;

import java.util.List;

import com.exception.Estudiantefalso;
import com.exception.Libronodisponible;
import com.exception.Limiteprestamo;
import com.model.Estudiante;
import com.model.Libro;
import com.service.Biblioteca;
import com.service.Registro;

/**
 * Clase principal del sistema de biblioteca.
 * 
 * Se encarga de la creación de libros, registrar estudiantes, realizar búsquedas, registrar prestamos, manejar excepciones y registrar devoluciones.
 */
public class App 
{
    /**
     * @param args argumentos recibidos por consola.
     * @throws Libronodisponible si se intenta prestar un libro no disponible.
     * @throws Estudiantefalso si se busca un estudiante inexistente.
     * @throws Limiteprestamo si se supera el límite de prestamos.
     */
    public static void main( String[] args ) throws Libronodisponible, Estudiantefalso, Limiteprestamo
    {
        Biblioteca biblio = new Biblioteca();
        biblio.agregarLibro(new Libro("1","Dune","Herbert", 1965, true));
        biblio.agregarLibro(new Libro("2","Fundacion","Asimov", 1951, true));
        biblio.agregarLibro(new Libro("3","Meridiano de Sangre","McCarthy", 1985, true));
        biblio.agregarLibro(new Libro("4","Noches Blancas","Dostoievski", 1845, true));
        biblio.agregarLibro(new Libro("5","Dune 2","Herbert", 1969, false));
        Registro registro = new Registro(biblio.getLibros());
        
        //Busqueda por titulo
        List <Libro> encontrado = biblio.buscarPorTitulo("dune");
        if (encontrado.isEmpty()){
            System.out.println("No se encontro el libro");
        } else {
            encontrado.forEach(System.out::println);
        }

        registro.agregarEstudiante (new Estudiante("001","Martin Pereyra", "Sistemas", "email1"));
        registro.agregarEstudiante (new Estudiante("002","Roque Molina", "Sistemas", "email2"));
        registro.agregarEstudiante (new Estudiante("003","Nicolas Nieto", "Sistemas", "email3"));
        
        //Excepcion estudiante no encontrado
        try {
            Estudiante e = registro.obtenerEstudiante("004");
            System.out.println("Encontrado");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        //Registro de prestamos
        try {
        registro.registrarPrestamo("1","001");
        System.out.println("Prestamo registrado");
        } catch (Libronodisponible | Estudiantefalso | Limiteprestamo e){
            System.out.println(e.getMessage());
        }

        try {
        registro.registrarPrestamo("2","001");
        System.out.println("Prestamo registrado");
        } catch (Libronodisponible | Estudiantefalso | Limiteprestamo e){
            System.out.println(e.getMessage());
        }

        try {
        registro.registrarPrestamo("3","001");
        System.out.println("Prestamo registrado");
        } catch (Libronodisponible | Estudiantefalso | Limiteprestamo e){
            System.out.println(e.getMessage());
        }
        
        //Excepcion limite de prestamos
        try {
        registro.registrarPrestamo("4","001");
        System.out.println("Prestamo registrado");
        } catch (Libronodisponible | Estudiantefalso | Limiteprestamo e){
            System.out.println(e.getMessage());
        }

        //Excepcion libro no disponible
        try {
        registro.registrarPrestamo("5","001");
        System.out.println("Prestamo registrado");
        } catch (Libronodisponible | Estudiantefalso | Limiteprestamo e){
            System.out.println(e.getMessage());
        }

        //Registro devolucion
        double multa =registro.registrarDevolucion("1", 15, 1000);
        System.out.println("Multa calculada: " + multa);
    }
}
