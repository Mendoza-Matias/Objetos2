package com.mmendoza;

public class Bicicleta extends Transporte {

    // Constructor con valores específicos para Bicicleta

    public Bicicleta() {
        super(15, 0.125); // Peso máximo de carga y volumen máximo de carga para la bicicleta
    }

    @Override
    public Boolean puedeEnviarLosPaquetes() {
        return this.paquetes().size() <= 2
                && this.pesoTotalDeLosPaquetes() < getPesoMaximoDeCarga()
                && this.volumenTotalDeLosPaquetes() < getVolumenMaximoDeCarga();
    }
}
