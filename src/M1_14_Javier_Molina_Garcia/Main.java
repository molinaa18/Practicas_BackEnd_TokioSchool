package M1_14_Javier_Molina_Garcia;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {

        Personal[] empleados = {
            new Administrativo("Ana", "12345678A", LocalDate.of(2015, 1, 10), 6),
            new Informatico("Luis", "12345678B", LocalDate.of(2021, 5, 3), 15),
            new Profesor("Carlos", "12345678C", LocalDate.of(2000, 3, 20)),
            new Investigador("Marta", "12345678D", LocalDate.of(2022, 11, 15))
        };

        Universidad.imprimirNominas(empleados);

        System.out.println("Presupuesto total: " + 
            (Universidad.obtenerPresupuestoTotal(empleados) / 100.0) + " €");
    }

}
