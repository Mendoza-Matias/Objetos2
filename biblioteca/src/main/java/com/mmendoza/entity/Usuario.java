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

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    protected abstract Integer getLimite();

    protected ArrayList<Libro> getLibros() {
        return libros;
    }

    protected void solicitarLibro(ArrayList<String> titulos) {

        for (String titulo : titulos) {
            //llama al metodo de la biblioteca que registra el historial y en este guardo el usuario y el libro
            biblioteca.registrarHistorial(this, titulo);
        }

        libros.addAll(biblioteca.librosSolicitados(this));
    }

    protected void devolverLibros() {

        biblioteca.devolverLibros(this);

        for (int i = 0; i < libros.size(); i++) {
            libros.remove(i);
        }
    }
}
