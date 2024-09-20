package com.mmendoza;

import java.util.LinkedList;

public class Bicicleta extends Transporte {

    private String destino;

    public Bicicleta() {
        super(15, 1.25);
    }

    @Override
    public boolean agregarPaquete(Paquete paquete, String destino) {
        if (this.destino == null) {
            this.destino = destino; /*valido que el destino sea null y le cargo el primer destino*/
        }
        /*verifico que el destino sea el mismo*/
        if (this.paquetes.size() < 2 && this.condicionDePaquete(paquete) && this.destino.equals(destino)) {
            this.paquetes.add(paquete);
            return true;
        }
        return false;
    }

}
