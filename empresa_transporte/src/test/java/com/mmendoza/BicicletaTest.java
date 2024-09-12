package com.mmendoza;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BicicletaTest {

    @Test
    public void enviarPaquetes() {

        Bicicleta bicicleta = new Bicicleta();

        bicicleta.cargarPaquetes(Arrays.asList(
                new Paquete(10, 0.20, 0.20, 0.40),
                new Paquete(2, 0.20, 0.20, 0.40)
        ));

        assertTrue(bicicleta.puedeEnviarLosPaquetes());
    }

}