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
