package com.mmendoza;

import java.util.LinkedList;
import java.util.List;

public class Vehiculo extends Transporte {

    private List<String> ciudades = new LinkedList<String>();

    public Vehiculo() {
        super(15, 1.25);
    }

    @Override
    public boolean agregarPaquete(Paquete paquete, String destino) {
        if (!ciudades.contains(destino) && ciudades.size() < 3)
            ciudades.add(destino);

        if (condicionDePaquete(paquete)) {
            this.paquetes.add(paquete);
            return true;
        }
        return false;
    }

}
