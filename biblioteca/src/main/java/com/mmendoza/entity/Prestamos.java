package com.mmendoza.entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Prestamos {

    private Usuario usuario; /*usuario que solicito el libro*/
    private ArrayList<Libro> librosSolicitados; /*libros solicitados*/
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    /*inicializo mi lista en el constructor vacio*/

    public Prestamos(Usuario usuario, Libro libro, LocalDate fecha) {
        this.usuario = usuario;
        ingresarLibro(libro); /*se llama al metodo que se encarga de ingresar un l*/
        this.fechaPrestamo = fecha;
    }

    private void ingresarLibro(Libro libro) {
        if (librosSolicitados == null) {
            librosSolicitados = new ArrayList<>();
        }
        if (libro != null)
            librosSolicitados.add(libro);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    protected ArrayList<Libro> getLibrosSolicitados() {
        return librosSolicitados;
    }

    /*
     * inserta la fecha de devolucion del libro
     * */
    protected void insertarFechaDeDevolucion() {
        fechaDevolucion = LocalDate.now();
    }

    protected Boolean estaElLibroConTitulo(String titulo) {
        for (Libro libro : getLibrosSolicitados()) {
            if (libro.getTitulo().equals(titulo)) {
                return true;
            }
        }
        return false;
    }

    protected Libro obtenerLibroConTitulo(String titulo) {
        Integer indice = 0;
        for (int i = 0; i < librosSolicitados.size(); i++) {
            if (titulo.equals(librosSolicitados.get(i).getTitulo())) {
                indice = i;
            }
        }
        return librosSolicitados.get(indice);
    }
}
