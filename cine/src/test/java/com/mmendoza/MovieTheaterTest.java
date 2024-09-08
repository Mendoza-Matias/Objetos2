package com.mmendoza;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTheaterTest {

    private SalaDeCine sala;
    private SalaDeCine sala2;

    @Before
    public void setUp() {
        sala = new SalaDeCine(6, 6);
        sala2 = new SalaDeCine(3, 3);
    }

    @Test
    public void verificarCreacion() {
        assertEquals(SalaDeCine.class, sala.getClass());
    }

    @Test
    public void verificarEstaVacia() {
        assertTrue(sala.estaVacia());
    }

    @Test
    public void verificarNoEstaVacia() {
        sala.tomarAsiento(1, 1);
        assertFalse(sala.estaVacia());
    }

    @Test
    public void verificarEstaOcupado() {
        assertFalse(sala.estaOcupado(1, 1));
    }

    @Test
    public void verificarNoEstaOcupado() {
        sala.tomarAsiento(1, 1);
        assertTrue(sala.estaOcupado(1, 1));
    }

    @Test
    public void verificarTomarAsiento() {
        sala.tomarAsiento(1, 1);
        assertTrue(sala.estaOcupado(1, 1));
    }

    @Test
    public void verificarAsientosOcupadosDisponibles() {
        sala.tomarAsiento(1, 1);
        sala.tomarAsiento(1, 2);
        sala.tomarAsiento(1, 3);

        assertEquals(3, sala.contarAsientosOcupados().intValue());
    }

    @Test
    public void verificarAcomodarAdyacente() {
        sala.tomarAsiento(0, 1);
        sala.tomarAsiento(0, 2);
        sala.tomarAsiento(1, 1);
        sala.tomarAsiento(1, 2);
        sala.tomarAsiento(2, 1);
        sala.tomarAsiento(2, 5);
        assertTrue(sala.acomodarAdyacentes(5));
    }

    @Test
    public void verificarNoAcomodarAdyacente() {

        sala2.tomarAsiento(0, 1);
        sala2.tomarAsiento(0, 2);
        sala2.tomarAsiento(1, 1);
        sala2.tomarAsiento(1, 2);
        sala2.tomarAsiento(2, 1);
        sala2.tomarAsiento(2, 2);

        assertFalse(sala2.acomodarAdyacentes(2));
    }
}
