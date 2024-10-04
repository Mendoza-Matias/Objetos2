package com.mmendoza.entity;

import java.util.UUID;

public class Libro {

    private String titulo;
    private String autor;
    private String isbn;
    private Boolean disponible;


    /*constructor para crear un libro*/

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.disponible = true;
        this.autor = autor;
        this.isbn = UUID.randomUUID().toString();
    }

    protected String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    protected void estaDisponible() {
        disponible = true;
    }

    protected void modificarANoDisponible() {
        disponible = false;
    }

    protected Boolean getDisponible() {
        return disponible;
    }


}
