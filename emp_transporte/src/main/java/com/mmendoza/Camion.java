package com.mmendoza;

import java.util.LinkedList;

public class Camion extends Transporte {

    // Lista de ciudades a las que el camión ha transportado paquetes
    private LinkedList<String> ciudades = new LinkedList<String>();

    // Constructor que inicializa el camión con peso y volumen específicos
    public Camion() {
        super(16000, 3.00);
    }

    //implementacion del metodo agregarPaquete()
    @Override
    public boolean agregarPaquete(Paquete paquete, String destino) {
        // Verifica si el paquete cumple con las condiciones
        if (condicionDePaquete(paquete)) {
            // Agrega el destino a la lista de ciudades
            this.ciudades.add(destino);
            // Agrega el paquete a la lista de paquetes
            this.paquetes.add(paquete);
            return true;
        }
        return false;
    }
}
