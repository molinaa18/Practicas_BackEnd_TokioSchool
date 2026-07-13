package M3_04_Javier_Molina_Garcia;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Mostrar por consola un mensaje con la fecha y hora actual
        LocalDateTime ahora = LocalDateTime.now();
        // DateTimeFormatter para darle un formato más legible
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Fecha y hora actual: " + ahora.format(formatoHora));

        LocalDate fechaNacimiento = null;
        boolean fechaValida = false;

        // 2. Pedir por consola que se introduzca la fecha de nacimiento en formato AAAA-MM-DD
        // Usamos un bucle para repetir la pregunta si hay una excepción
        while (!fechaValida) {
            System.out.print("Introduce tu fecha de nacimiento (AAAA-MM-DD): ");
            String fechaInput = scanner.nextLine();

            try {
                // Se analiza (parse) el texto introducido a un objeto LocalDate
                fechaNacimiento = LocalDate.parse(fechaInput);
                fechaValida = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato incorrecto. Por favor, asegúrate de escribirlo como AAAA-MM-DD (ejemplo: 1990-01-25).");
            }
        }

        LocalDate hoy = LocalDate.now();

        // 3. Calcular los días que quedan para el próximo cumpleaños
        // Primero, calculamos cuándo cae el cumpleaños en el año actual
        LocalDate proximoCumple = fechaNacimiento.withYear(hoy.getYear());

        // Se comprueba si el cumpleaños de este año ya ha pasado
        if (proximoCumple.isBefore(hoy)) {
            // Si ya pasó, el próximo cumpleaños será el año que viene (sumamos 1 año)
            proximoCumple = proximoCumple.plusYears(1);
        }

        // Calcula de días entre la fecha de hoy y el próximo cumpleaños
        long diasRestantes = hoy.until(proximoCumple, ChronoUnit.DAYS);

        System.out.println("Falta(n) " + diasRestantes + " día(s) para tu próximo cumpleaños.");


        scanner.close();
    }
}
