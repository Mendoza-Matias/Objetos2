package com.mmendoza.entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Libro> librosDeLaBiblioteca; /*representa los libros*/

    private ArrayList<Prestamos> historialDePrestamos; /*representa el historial de los libros los cuales son prestados*/

    public Biblioteca() {
        librosDeLaBiblioteca = new ArrayList<>();
        historialDePrestamos = new ArrayList<>();
    }

    /*
     * agrega uno o varios libros a la biblioteca
     *  */
    public void agregarLibros(ArrayList<Libro> libros) {
        for (Libro libro : libros) {
            if (!(estaEnLaBibliotecaElLibro(libro.getTitulo()))) {
                librosDeLaBiblioteca.add(libro);
            }
        }
    }

    public Boolean estaDisponibleElLibro(String titulo) {
        for (Libro libro : librosDeLaBiblioteca) {
            if (libro.getTitulo().equals(titulo)) {
                if (libro.getDisponible()) {
                    return true;
                }
            }
        }
        return false;
    }

    public Integer cantidadDeLibros() {
        return librosDeLaBiblioteca.size();
    }

    protected void registrarPrestamo(Usuario usuario, String titulo) {
        /*
         * si esta el libro en la biblioteca y este esta disponible se guarda en el historial
         * */
        if (estaEnLaBibliotecaElLibro(titulo) && estaDisponibleElLibro(titulo)) {
            historialDePrestamos.add(
                    new Prestamos(
                            usuario,
                            obtenerLibro(titulo),
                            LocalDate.now())
            );
            modificarEstadoDelLibro(titulo);
        }
    }

    /*
     * modifica el estado del libro y guarda la fecha de devolucion en el historial
     * */
    protected void devolverLibros(String titulo) {
        for (Prestamos prestamo : historialDePrestamos) {
            if (prestamo.estaElLibroConTitulo(titulo)) {
                prestamo.obtenerLibroConTitulo(titulo).modificarEstado();
                prestamo.insertarFechaDeDevolucion();
            }
        }
    }

    public ArrayList<Prestamos> getHistorialDePrestamos() {
        return historialDePrestamos;
    }

    /*
     * devuelve la lista de libros los cuales fueron solicitados por el usuario
     * */
    protected ArrayList<Libro> librosSolicitados(Usuario usuario) {

        ArrayList<Libro> librosSolicitados = new ArrayList<Libro>();

        for (Prestamos prestamos : historialDePrestamos) {
            if (prestamos.getUsuario().equals(usuario)) {
                librosSolicitados.addAll(prestamos.getLibrosSolicitados());
            }
        }

        return librosSolicitados;
    }

    /*
     * busca el libro en la lista y modifica su estado
     * */
    private void modificarEstadoDelLibro(String titulo) {
        for (Libro libro : librosDeLaBiblioteca) {
            if (libro.getTitulo().equals(titulo))
                libro.modificarEstado();
        }
    }

    /*
     * verifica que el libro este en la biblioteca
     * */
    private Boolean estaEnLaBibliotecaElLibro(String titulo) {
        Boolean estaEnLaBiblioteca = false;
        for (Libro libro : librosDeLaBiblioteca) {
            if (libro.getTitulo().equals(titulo)) {
                estaEnLaBiblioteca = true;
            }
        }
        return estaEnLaBiblioteca;
    }

    /*
     * nos devuelve un libro
     * */
    private Libro obtenerLibro(String titulo) {
        for (Libro libro : librosDeLaBiblioteca) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return new Libro("", "");
    }
}
