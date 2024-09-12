package com.mmendoza;

public class Camion extends Transporte {

    protected Camion() {
        super(16000, 0.20);
    }

    @Override
    public Boolean puedeEnviarLosPaquetes() {
        return this.pesoTotalDeLosPaquetes() < getPesoMaximoDeCarga()
                && this.volumenTotalDeLosPaquetes() < getVolumenMaximoDeCarga();
    }
}
