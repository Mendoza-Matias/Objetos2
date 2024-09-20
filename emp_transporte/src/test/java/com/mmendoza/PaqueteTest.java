package com.mmendoza;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaqueteTest {

    private Paquete paquete;

    @Before
    public void setUp() {
        paquete = new Paquete(0.2, 0.2, 0.2, 1.20);
    }

    @Test
    public void informarPeso() {
        assertEquals(1.20, paquete.getPeso(), 0);
    }
}