package com.model;
/**
 * Representación de un estudiante registrado dentro del sistema de biblioteca.
 * 
 * Cada estudiante posee legajo, nombre, carrera y email.
 */
public class Estudiante {
    private String legajo;
    private String nombre;
    private String carrera;
    private String email;


    /**
     * Constructor por defecto.
     * Crea un estudiante vacio con valores por defecto.
     */
    public Estudiante (){
        this.legajo = "";
        this.nombre = "";
        this.carrera = "";
        this.email = "";
    }

    /**
     * Constructor parametizado.
     * Crea un estudiante con sus datos.
     * 
     * @param legajo número de legajo del estudiante.
     * @param nombre nombre completo del estudiante.
     * @param carrera carrera a la que pertenece el estudiante.
     * @param email email del estudiante.
     */
    public Estudiante (String legajo, String nombre, String carrera, String email) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.carrera = carrera;
        this.email = email;
    }

    public String getLegajo () {
        return legajo;
    }
    public void setLegajo (String legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera () {
        return carrera;
    }
    public void setCarrera (String carrera) {
        this.carrera = carrera;
    }

    public String getEmail () {
        return email;
    }
    public void setEmail (String email) {
        this.email = email;
    }

    /**
     * Devuelve una representación en texto del estudiante.
     * 
     * @return información completa del estudiante.
     */
    @Override
    public String toString() {
        return "Estudiante: Legajo: " + legajo + " Nombre: " + nombre + "Carrera: " + carrera + "Email: " + email;
    }
}

