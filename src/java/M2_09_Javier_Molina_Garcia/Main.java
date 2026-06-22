package M2_09_Javier_Molina_Garcia;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Inicializo la lista y las ciudades.
        List<Ciudad> ciudades;
        ciudades = new ArrayList<>();
        ciudades.add(new Ciudad ("Madrid", "Madrid", 3500000));
        ciudades.add(new Ciudad("Málaga", "Málaga", 600000));
        ciudades.add(new Ciudad("Barcelona", "Barcelona", 1700000));
        ciudades.add(new Ciudad("Alcalá de Henares", "Madrid", 200000));


        // Realiza las operaciones con Streams que permitan contestar a las preguntas
        System.out.println("1. ¿Cuántas ciudades hay en total?");
        long numCiudades = ciudades.stream().count();
        System.out.println("Hay un total de " + numCiudades + " ciudades en la lista.");
        System.out.println("....................");

        //Se filtran ciudades cuya provincia sea 'Madrid' y tenga +1000 habitantes
        System.out.println("2. ¿Cuántas ciudades de “Madrid” tienen más de 1.000 habitantes?");
        long madridMasMil = ciudades.stream()
                .filter(c -> c.getProvincia().equalsIgnoreCase("Madrid") && c.getHabitantes() > 1000).count();
        System.out.println("Hay " + madridMasMil + " ciudades de Madrid con más del 1.000 habitantes en la lista.");
        System.out.println("....................");

        //.distinct() evitará duplicidades
        System.out.println("3. ¿De qué provincias son las ciudades?");
        System.out.println("Las provincias que aparecen en la lista son: ");
        ciudades.stream()
                .map(c -> c.getProvincia())
                .distinct()
                .forEach(p -> System.out.println(p));
        System.out.println("....................");

        //Similar a la anterior, cuenta descartando duplicidades
        System.out.println("4. ¿De cuántas provincias diferentes son las ciudades?");
        long pDif = ciudades.stream()
                .map(c -> c.getProvincia())
                .distinct()
                .count();
        System.out.println("De " + pDif + " provincias diferentes.");
        System.out.println("....................");

        //Similar a la pregunta 2
        System.out.println("5. ¿Alguna ciudad de Madrid tiene más de 50.000 habitantes?");
        long madridMasCincuentaMil = ciudades.stream()
                .filter(c -> c.getProvincia().equalsIgnoreCase("Madrid") && c.getHabitantes() > 60000).count();
        if (madridMasCincuentaMil >= 1) {
            System.out.println("Sí, en la lista hay una o más.");
        } else {
            System.out.println("No, no hay ninguna en la lista.");
        }
        System.out.println("....................");


        System.out.println("Fin del programa");
    }
}
