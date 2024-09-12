package com.mmendoza;

import java.util.ArrayList;
import java.util.List;

public abstract class Transporte {

    private final Integer pesoMaximoDeCarga;

    private final Double volumenMaximoDeCarga;

    private List<Paquete> paquetes;

    protected Transporte(Integer pesoMaximoDeCarga, Double volumenMaximoDeCarga) {
        this.pesoMaximoDeCarga = pesoMaximoDeCarga;
        this.volumenMaximoDeCarga = volumenMaximoDeCarga;
        this.paquetes = new ArrayList<Paquete>();
    }

    public abstract Boolean puedeEnviarLosPaquetes();

    public Integer getPesoMaximoDeCarga() {
        return pesoMaximoDeCarga;
    }

    public Double getVolumenMaximoDeCarga() {
        return volumenMaximoDeCarga;
    }

    /* acceden solo las clases que heredan de transporte */

    protected void cargarPaquetes(List<Paquete> paquetes) {
        this.paquetes.addAll(paquetes);
    }

    protected List<Paquete> paquetes() {
        return this.paquetes;
    }

    protected Integer pesoTotalDeLosPaquetes() {
        return this.paquetes.stream().mapToInt(Paquete::peso).sum();
    }

    public Double volumenTotalDeLosPaquetes() {
        return this.paquetes.stream().mapToDouble(Paquete::volumen).sum();
    }
}
