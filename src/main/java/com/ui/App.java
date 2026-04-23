package com.ui;

import java.util.List;

import com.exception.Estudiantefalso;
import com.exception.Libronodisponible;
import com.exception.Limiteprestamo;
import com.model.Estudiante;
import com.model.Libro;
import com.service.Biblioteca;
import com.service.Registro;


public class App 
{
    public static void main( String[] args ) throws Libronodisponible, Estudiantefalso, Limiteprestamo
    {
        Biblioteca biblio = new Biblioteca();
        biblio.agregarLibro(new Libro("1","Dune","wachin", 1905, true));
        biblio.agregarLibro(new Libro("2","Fundacion","wachin", 1905, true));
        biblio.agregarLibro(new Libro("3","Meridiano de Sangre","wachin", 1905, true));
        biblio.agregarLibro(new Libro("4","Noches Blancas","wachin", 1905, true));
        biblio.agregarLibro(new Libro("5","Dune 2","wachin", 1905, true));
        Registro registro = new Registro(biblio.getLibros());
        List <Libro> encontrado = biblio.buscarPorTitulo("dune");

        if (encontrado.isEmpty()){
            System.out.println("No se encontro el libro");
        } else {
            encontrado.forEach(System.out::println);
        }
        //System.out.println(libro1);
        //System.out.println(estudiante1);

        registro.agregarEstudiante (new Estudiante("001","Martin Pereyra", "Sistemas", "email----"));
        registro.agregarEstudiante (new Estudiante("002","Roque Molina", "Sistemas", "email2"));
        registro.agregarEstudiante (new Estudiante("003","wachin", "Sistemas", "email3"));
        try {
            Estudiante e = registro.obtenerEstudiante("004");
            System.out.println("Encontrado");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
        registro.registrarPrestamo("1","001");
        System.out.println("Prestamo registrado");
        } catch (Libronodisponible | Estudiantefalso | Limiteprestamo e){
            System.out.println(e.getMessage());
        }
        double multa =registro.registrarDevolucion("1", 39, 1000);
        System.out.println("Multa calculada: " + multa);
        //registro.mostrarEstudiantes();
    


    }
}
