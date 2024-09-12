package com.mmendoza;

import java.util.ArrayList;
import java.util.List;

public class Bicicleta extends Trasnporte {

    private Boolean estaEnLaCiudad;

    private String destino;

    private List<Paquete> paquetes; /* puedo tener mas de un paquete */


    public Bicicleta(Boolean estaEnLaCiudad) {
        this.estaEnLaCiudad = estaEnLaCiudad;
        this.paquetes = new ArrayList<Paquete>();
    }

    public void ingrearPaquetes(List<Paquete> paquetes) {
        this.paquetes.addAll(paquetes);
    }

    /* cargar un destino */
    public void cargarDestino(String destino) {
        this.destino = destino;
    }

    public String consultarDestino() {
        if (destino == null || destino.isEmpty()) /* verifico que no tenga un destino cargado mi bicicleta */
            destino = paquetes.get(0).destino();
        return this.destino;
    }

    @Override
    public Boolean enviarPaquete() {
        return estaEnLaCiudad && puedeEnviarElPaquete();
    }

    /* validacion de condiciones para enviar el paquete */
    private Boolean puedeEnviarElPaquete() {
        return this.paquetes.size() <= 2 &&
                this.calcularVolumenTotal() <= 0.125
                && calcularPesoTotal() < 15;
    }

    /* calcular el peso total que obtengo de cada uno de los paquetes */
    private Double calcularVolumenTotal() {
        return paquetes.stream().mapToDouble(Paquete::volumen).sum();
    }

    private Integer calcularPesoTotal() {
        return paquetes.stream().mapToInt(Paquete::peso).sum();
    }

}
