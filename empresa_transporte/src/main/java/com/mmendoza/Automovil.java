package com.mmendoza;

public class Automovil extends Transporte {

    protected Automovil() {
        super(500, 0.2);
    }

    @Override
    public Boolean puedeEnviarLosPaquetes() {
        return this.pesoTotalDeLosPaquetes() < getPesoMaximoDeCarga()
                && this.volumenTotalDeLosPaquetes() < getVolumenMaximoDeCarga();
    }
}
