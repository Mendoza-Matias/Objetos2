package com.mmendoza.entity;

import java.util.ArrayList;

public class Profesor extends Usuario {

    public Profesor(String nombre, Biblioteca biblioteca) {
        super(nombre, biblioteca);
    }

    @Override
    public Integer getLimite() {
        return 3;
    }

    @Override
    protected void solicitarLibro(ArrayList<String> titulos) {
        if (!(getLibros().size() >= getLimite()))
            super.solicitarLibro(titulos); /*se pueden solicitar libros mientras no se supere el limite*/
    }

}
