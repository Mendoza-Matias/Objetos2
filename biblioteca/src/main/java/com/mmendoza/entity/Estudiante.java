package com.mmendoza.entity;

import java.util.ArrayList;

public class Estudiante extends Usuario {

    public Estudiante(String nombre, Biblioteca biblioteca) {
        super(nombre, biblioteca);
    }

    @Override
    public Integer getLimite() {
        return 1;
    }

    @Override
    protected void solicitarLibro(ArrayList<String> titulos) {
        if (!(getLibros().size() >= getLimite()))
            super.solicitarLibro(titulos);
    }
}
