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
    public void solicitarLibro(ArrayList<String> titulos) {
        /*
         * se puede solicitar mientras el usuario no haya superado su limite de prestamos
         * */
        if (!(getLibros().size() >= getLimite()))
            super.solicitarLibro(titulos);
    }

    @Override
    public void devolverLibro(String titulo) {
        super.devolverLibro(titulo);
    }
}
