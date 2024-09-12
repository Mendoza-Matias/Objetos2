package com.mmendoza;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BicicletaTest {

    private Bicicleta biciEnLaCiudad;

    private Bicicleta biciFueraDeLaCiudad;

    @Before
    public void setUp() {
        biciFueraDeLaCiudad = new Bicicleta(false);
        biciEnLaCiudad = new Bicicleta(true);
    }

    @Test
    public void entregarPaquete() {
        Paquete paquete = new Paquete(10, 0.30, 0.25, 0.25, "Argentina");

        biciEnLaCiudad.ingrearPaquetes(Arrays.asList(paquete));

        Boolean esperado = biciEnLaCiudad.enviarPaquete();

        assertTrue(esperado);
    }

    @Test
    public void entregarPaqueteFueraDeLaCiudad() {

        Paquete paquete = new Paquete(10, 0.30, 0.25, 0.25, "Argentina");
        Paquete paquete2 = new Paquete(5, 0.500, 0.155, 0.25, "Brasil");

        biciFueraDeLaCiudad.ingrearPaquetes(Arrays.asList(paquete, paquete2));

        Boolean esperado = biciFueraDeLaCiudad.enviarPaquete();

        assertFalse(esperado);
    }

    @Test
    public void entregarTresPaquetes() {

        Paquete paquete = new Paquete(10, 0.30, 0.25, 0.25, "Argentina");
        Paquete paquete2 = new Paquete(5, 0.500, 0.155, 0.25, "Brasil");
        Paquete paquete3 = new Paquete(10, 0.30, 0.25, 0.25, "Uruguay");

        biciEnLaCiudad.ingrearPaquetes(Arrays.asList(paquete, paquete2, paquete3));

        Boolean esperado = biciEnLaCiudad.enviarPaquete();

        assertFalse(esperado);
    }

    @Test
    public void entregarPaqueteConPesoSuperiorA15() {
        Paquete paquete = new Paquete(10, 0.30, 0.25, 0.25, "Argentina");
        Paquete paquete2 = new Paquete(6, 0.500, 0.155, 0.25, "Brasil");

        biciEnLaCiudad.ingrearPaquetes(Arrays.asList(paquete, paquete2));

        Boolean esperado = biciEnLaCiudad.enviarPaquete();

        assertFalse(esperado);
    }

    @Test
    public void consultarDestino() {
        Paquete paquete = new Paquete(10, 0.30, 0.25, 0.25, "Argentina");
        Paquete paquete2 = new Paquete(5, 0.500, 0.155, 0.25, "Brasil");

        biciEnLaCiudad.ingrearPaquetes(Arrays.asList(paquete, paquete2));

        String destino = biciEnLaCiudad.consultarDestino();

        assertEquals("Argentina", destino);
    }

    @Test
    public void consultarDestinoIngresado() {
        Paquete paquete = new Paquete(10, 0.30, 0.25, 0.25, "Argentina");
        Paquete paquete2 = new Paquete(5, 0.500, 0.155, 0.25, "Brasil");

        biciEnLaCiudad.cargarDestino("Bolivia");

        biciEnLaCiudad.ingrearPaquetes(Arrays.asList(paquete, paquete2));

        String destino = biciEnLaCiudad.consultarDestino();

        assertEquals("Bolivia", destino);
    }
}