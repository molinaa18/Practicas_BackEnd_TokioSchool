package learning.tokioschool.parking;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CocheTest {

    @Test
    void testCantidadAPagar_CalculoNormal() {
        // 1. Preparación (Arrange)
        // Simulamos una estancia de exactamente 1 hora (60 minutos)
        LocalDateTime horaEntrada = LocalDateTime.of(2023, 10, 26, 10, 0);
        LocalDateTime horaSalida = LocalDateTime.of(2023, 10, 26, 11, 0);

        Coche coche = new Coche("Seat", "Ibiza", horaEntrada, horaSalida);

        // 2. Ejecución (Act)
        float importe = coche.cantidadAPagar();

        // 3. Comprobación (Assert)
        // 60 minutos * 0.15f = 9.0f
        // Añadimos un "delta" de 0.001f por la posible pérdida de precisión al trabajar con números decimales (float)
        assertEquals(9.0f, importe, 0.001f, "El importe para 60 minutos debe ser 9.0");
    }

    @Test
    void testCantidadAPagar_MismoMinuto() {
        // 1. Preparación (Arrange)
        // Simulamos que el coche entra y sale en el mismo minuto (0 minutos)
        LocalDateTime horaEntrada = LocalDateTime.of(2023, 10, 26, 15, 30);
        LocalDateTime horaSalida = LocalDateTime.of(2023, 10, 26, 15, 30);

        Coche coche = new Coche("Ford", "Focus", horaEntrada, horaSalida);

        // 2. Ejecución (Act)
        float importe = coche.cantidadAPagar();

        // 3. Comprobación (Assert)
        // 0 minutos * 0.15f = 0.0f
        assertEquals(0.0f, importe, 0.001f, "El importe para 0 minutos debe ser 0.0");
    }

    @Test
    void testCantidadAPagar_FraccionDeHora() {
        // 1. Preparación (Arrange)
        // Simulamos una estancia de 15 minutos
        LocalDateTime horaEntrada = LocalDateTime.of(2023, 10, 26, 18, 0);
        LocalDateTime horaSalida = LocalDateTime.of(2023, 10, 26, 18, 15);

        Coche coche = new Coche("Toyota", "Corolla", horaEntrada, horaSalida);

        // 2. Ejecución (Act)
        float importe = coche.cantidadAPagar();

        // 3. Comprobación (Assert)
        // 15 minutos * 0.15f = 2.25f
        assertEquals(2.25f, importe, 0.001f, "El importe para 15 minutos debe ser 2.25");
    }
}
