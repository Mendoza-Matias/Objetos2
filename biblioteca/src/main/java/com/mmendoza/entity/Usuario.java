package com.mmendoza.entity;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Usuario {

    private String nombre;

    private Integer numeroUsuario;

    private Biblioteca biblioteca;

    private ArrayList<Libro> libros;

    public Usuario(String nombre, Biblioteca biblioteca) {
        this.nombre = nombre;
        this.numeroUsuario = Integer.getInteger(String.valueOf(Math.random()));
        this.biblioteca = biblioteca;
        this.libros = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    /*
     * libros del usuario
     * */
    protected ArrayList<Libro> getLibros() {
        return libros;
    }

    /*condiciones de limite el cual tiene cada usuario*/
    protected abstract Integer getLimite();

    /*
     * solicito los libros mediante su nombre
     * */
    protected void solicitarLibro(ArrayList<String> titulos) {
        for (String titulo : titulos) {
            /*
             * le paso el titulo del libro y al usuario para que este se almacene en el historial del prestamo
             * */
            biblioteca.registrarPrestamo(this, titulo);
        }

        libros.addAll(biblioteca.librosSolicitados(this));
    }

    protected void devolverLibro(String titulo) {
        /*
         * veo la lista de libros que tiene mi usuario y si este se encuentra realiza la devolución
         * */
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getTitulo().equals(titulo)) {
                biblioteca.devolverLibros(libros.get(i).getTitulo());
                libros.remove(i);
            }
        }
    }

}


