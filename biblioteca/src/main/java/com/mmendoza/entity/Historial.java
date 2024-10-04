package com.mmendoza.entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Historial {

    private Usuario usuario; /*usuario que solicito el libro*/
    private ArrayList<Libro> librosSolicitados; /*libros solicitados*/
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    /*inicializo mi lista en el constructor vacio*/

    public Historial(Usuario usuario, Libro libro, LocalDate fecha) {
        this.usuario = usuario;
        ingresarLibro(libro); /*se llama al metodo que se encarga de ingresar un l*/
        this.fechaPrestamo = fecha;
    }

    private void ingresarLibro(Libro libro) {
        if (librosSolicitados == null) {
            librosSolicitados = new ArrayList<>();
        }
        librosSolicitados.add(libro);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public ArrayList<Libro> getLibrosSolicitados() {
        return librosSolicitados;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    protected void modificarEstadoDeLosLibros() {
        for (Libro libro : librosSolicitados) {
            libro.estaDisponible();
        }
    }

    protected ArrayList<Libro> getLibros() {
        return librosSolicitados;
    }

    protected void insertarFechaDeDevolucion() {
        fechaDevolucion = LocalDate.now();
    }

    /*imprimir datos del historial*/

    @Override
    public String toString() {
        return "Historial "
                + "[usuario=" + usuario +
                ", libro=" + librosSolicitados +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion + "]";
    }

}
