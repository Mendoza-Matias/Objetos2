package com.mmendoza.entity;

import java.util.UUID;

public class Libro {

    private String titulo;
    private String autor;
    private String isbn;
    private Boolean disponible;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.disponible = true;
        this.autor = autor;
        this.isbn = UUID.randomUUID().toString();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    protected void modificarEstado() {
        /*
         * si esta disponible lo cambio a false y sino no esta disponible a true
         * */
        disponible = (getDisponible()) ? false : true;
    }
}
