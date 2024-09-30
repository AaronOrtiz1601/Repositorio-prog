package refactorizacion_realizada;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import refactoring.Cliente;
import refactoring.Vehiculo;
import refactoring.Alquiler;

public class PruebasRefactorizadas {

    private Cliente cliente;
    private Vehiculo vehiculo1, vehiculo2, vehiculo3;
    private Alquiler alquiler1, alquiler2, alquiler3;

    @BeforeEach
    public void setUp() {
        vehiculo1 = new Vehiculo("123ABC", Vehiculo.FURGONETA);
        vehiculo2 = new Vehiculo("456DEF", Vehiculo.TURISMO);
        vehiculo3 = new Vehiculo("789GHI", Vehiculo.MOTOCICLETA);

        alquiler1 = new Alquiler(vehiculo1, 3); 
        alquiler2 = new Alquiler(vehiculo2, 12); 
        alquiler3 = new Alquiler(vehiculo3, 7); 

        cliente = new Cliente("Test Cliente");
        cliente.addAlquiler(alquiler1);
        cliente.addAlquiler(alquiler2);
        cliente.addAlquiler(alquiler3);
    }

    @Test
    public void testCalculoImporteTotal() {
        String cuenta = cliente.cuenta();
        assertTrue(cuenta.contains("Importe total 150.0"));
    }

    @Test
    public void testCalculoPuntosFidelidad() {
        String cuenta = cliente.cuenta();
        assertTrue(cuenta.contains("Has ganado 4 puntos de fidelidad"));
    }

    @Test
    public void testDetallesAlquiler() {
        String cuenta = cliente.cuenta();
        assertTrue(cuenta.contains("123ABC\t90.0"));
        assertTrue(cuenta.contains("456DEF\t35.0"));
        assertTrue(cuenta.contains("789GHI\t25.0"));
    }

    @Test
    public void testGetNombreCliente() {
        assertEquals("Test Cliente", cliente.getNombre());
    }

    @Test
    public void testVehiculoGetMatricula() {
        assertEquals("123ABC", vehiculo1.getMatricula());
    }

    @Test
    public void testAlquilerGetDiasAlquiler() {
        assertEquals(3, alquiler1.getDiasAlquiler());
    }
}
