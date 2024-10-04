package com.mmendoza.entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Libro> librosDeLaBiblioteca; /*representa los libros*/

    private ArrayList<Historial> historial; /*representa el historial de los libros los cuales son prestados*/

    public Biblioteca() {
        librosDeLaBiblioteca = new ArrayList<>();
        historial = new ArrayList<>();
    }

    /* agrega 1 o mas libros */
    public void agregarLibros(ArrayList<Libro> libros) {
        for (Libro libro : libros) {
            if (!(estaEnLaBiblioteca(libro.getTitulo()))) {
                librosDeLaBiblioteca.add(libro);
            }
        }
    }

    public Integer cantidadDeLibros() {
        return librosDeLaBiblioteca.size();
    }

    public Boolean estaDisponible(String titulo) {
        for (Libro libro : librosDeLaBiblioteca) {
            if (libro.getTitulo().equals(titulo)) {
                if (libro.getDisponible()) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean estaEnLaBiblioteca(String titulo) {
        Boolean estaEnLaBiblioteca = false;
        for (Libro libro : librosDeLaBiblioteca) {
            if (libro.getTitulo().equals(titulo)) {
                estaEnLaBiblioteca = true;
            }
        }
        return estaEnLaBiblioteca;
    }

    public ArrayList<Historial> historial() {
        return historial;
    }

    protected void registrarHistorial(Usuario usuario, String titulo) {
        /*Si la lista de libros contiene un libro con el titulo , lo agrega al historial*/
        if (estaEnLaBiblioteca(titulo) && estaDisponible(titulo)) {
            Libro libro = obtenerLibro(titulo);
            historial.add(new Historial(
                    usuario, libro, LocalDate.now()
            ));
            modificarEstadoDelLibro(titulo);
        }
    }

    private Libro obtenerLibro(String titulo) {
        for (Libro libro : librosDeLaBiblioteca) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return new Libro("", "");
    }

    protected void devolverLibros(Usuario usuario) {
        for (Historial h : historial) {
            if (h.getUsuario().equals(usuario)) {
                h.modificarEstadoDeLosLibros();
                h.insertarFechaDeDevolucion();
            }
        }
    }

    /*busca al libro con el titulo pasado y le modifica la disponibilidad*/
    private void modificarEstadoDelLibro(String titulo) {
        for (Libro libro : librosDeLaBiblioteca) {
            if (libro.getTitulo().equals(titulo))
                libro.modificarANoDisponible(); /*cambia la disponibilidad de true a false*/
        }
    }

    public ArrayList<Libro> librosSolicitados(Usuario usuario) {

        ArrayList<Libro> librosSolicitados = new ArrayList<Libro>();

        for (Historial historial : historial) {
            if (historial.getUsuario().equals(usuario)) {
                librosSolicitados.addAll(historial.getLibros());
            }
        }

        return librosSolicitados;
    }

}
