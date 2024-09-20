import com.mmendoza.Bicicleta;
import com.mmendoza.Paquete;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BicicletaTest {

    private Bicicleta bici;
    private Paquete paquete;

    @Before
    public void setUp() {
        bici = new Bicicleta();

        /* al crear el paquete este no cambia */
        paquete = new Paquete(0.1, 0.1, 0.1, 0.1);
    }

    @Test
    public void puedeCargarPaqueteChico() {
        assertTrue(bici.agregarPaquete(paquete, "Hurlingham"));
    }

    @Test
    public void probarLimiteDePaquetes() {
        Paquete paquete = new Paquete(0.1, 0.1, 0.1, 0.1);
        Paquete paquete2 = new Paquete(0.2, 0.2, 0.2, 0.2);
        Paquete paquete3 = new Paquete(0.3, 0.3, 0.3, 0.3);

        assertTrue(bici.agregarPaquete(paquete, "Hurlingham"));
        assertTrue(bici.agregarPaquete(paquete2, "Hurlingham"));
        assertFalse(bici.agregarPaquete(paquete3, "Hurlingham"));
    }

    @Test
    public void cantidadDePaquetes() {
        Paquete paquete = new Paquete(0.1, 0.1, 0.1, 0.1);
        bici.agregarPaquete(paquete, "Hurlingham");
        assertEquals(1, bici.cantidadDePaquetes().intValue());
    }

    @Test
    public void queNoSePuedaAgregarUnPaqueteGrande() {
        Paquete paquete = new Paquete(0.5, 0.5, 0.5, 15.1);
        assertFalse(bici.agregarPaquete(paquete, "Hurlingham"));
    }

    @Test
    public void queNoSePuedaAgregarUnPaqueteConVolumenMayor() {
        Paquete paquete = new Paquete(0.51, 0.5, 0.5, 16.0);
        assertFalse(bici.agregarPaquete(paquete, "San Miguel"));
    }

    @Test
    public void queNoSePuedeCargarUnDestinoDistinto() {
        Paquete paquete = new Paquete(0.1, 0.1, 0.1, 1.1);
        Paquete paquete2 = new Paquete(0.2, 0.2, 0.2, 1.2);

        assertTrue(bici.agregarPaquete(paquete, "Hurlingham"));
        assertFalse(bici.agregarPaquete(paquete2, "Bolivia"));
    }
}
