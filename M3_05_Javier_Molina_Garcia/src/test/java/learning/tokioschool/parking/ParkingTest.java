package learning.tokioschool.parking;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ParkingTest {

    private Parking parking;
    private Coche cocheTerminado;
    private Coche cocheEnParking;

    // Variables para capturar la salida por consola (System.out)
    private final ByteArrayOutputStream salidaConsola = new ByteArrayOutputStream();
    private final PrintStream salidaOriginal = System.out;

    // @BeforeEach se ejecuta ANTES de cada uno de los @Test.
    // Nos sirve para tener el entorno limpio y listo antes de cada prueba.
    @BeforeEach
    void setUp() {
        parking = new Parking();

        // Coche que ya ha salido del parking (1 hora de estancia)
        cocheTerminado = new Coche("Seat", "Ibiza",
                LocalDateTime.of(2023, 10, 26, 10, 0),
                LocalDateTime.of(2023, 10, 26, 11, 0));

        // Coche que sigue dentro del parking (horaSalida = null)
        cocheEnParking = new Coche("Ford", "Focus",
                LocalDateTime.of(2023, 10, 26, 12, 0),
                null);

        // Redirigimos la consola para que los "System.out.println" vayan a nuestra variable
        System.setOut(new PrintStream(salidaConsola));
    }

    // @AfterEach se ejecuta DESPUÉS de cada @Test para dejar todo como estaba.
    @AfterEach
    void tearDown() {
        // Restauramos la consola a su estado original
        System.setOut(salidaOriginal);
    }

    @Test
    void testPutYExisteCoche() {
        parking.putCoche("1111AAA", cocheTerminado);

        assertTrue(parking.existeCoche("1111AAA"), "El coche debería existir tras ser añadido");
        assertFalse(parking.existeCoche("9999ZZZ"), "Un coche no añadido no debería existir");
    }

    @Test
    void testImprimirCochesSistema() {
        parking.putCoche("1111AAA", cocheTerminado);
        parking.putCoche("2222BBB", cocheEnParking);

        parking.imprimirCochesSistema();

        // Comprobamos que lo que se ha impreso por consola contiene ambas matrículas
        String salida = salidaConsola.toString();
        assertTrue(salida.contains("1111AAA"), "Debe imprimir la matrícula del primer coche");
        assertTrue(salida.contains("2222BBB"), "Debe imprimir la matrícula del segundo coche");
    }

    @Test
    void testImprimirCochesParking() {
        parking.putCoche("1111AAA", cocheTerminado); // Este ya salió
        parking.putCoche("2222BBB", cocheEnParking); // Este sigue dentro

        parking.imprimirCochesParking();

        String salida = salidaConsola.toString();
        // Solo debe imprimir el coche cuya hora de salida es null
        assertFalse(salida.contains("1111AAA"), "No debe imprimir el coche que ya salió");
        assertTrue(salida.contains("2222BBB"), "Debe imprimir el coche que sigue dentro");
    }

    @Test
    void testCantidadAPagar() {
        // cocheTerminado estuvo 60 minutos. 60 * 0.15 = 9.0
        parking.putCoche("1111AAA", cocheTerminado);

        parking.cantidadAPagar("1111AAA");

        String salida = salidaConsola.toString();
        assertTrue(salida.contains("9.0"), "El texto impreso debe contener la cantidad correcta a pagar (9.0)");
    }
}